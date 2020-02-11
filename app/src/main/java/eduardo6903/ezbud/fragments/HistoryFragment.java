package eduardo6903.ezbud.fragments;


import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import eduardo6903.ezbud.R;
import eduardo6903.ezbud.database.DatabaseHelper;
import eduardo6903.ezbud.entities.Transactions;
import eduardo6903.ezbud.entities.User;
import eduardo6903.ezbud.recyclerview.TransactionsRecyclerViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    List<Transactions> transactionsList;
    TransactionsRecyclerViewAdapter adapter;
    DatabaseHelper database;


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        final RecyclerView transactionsRecyclerView = view.findViewById(R.id.historyRecyclerView);
        database = new DatabaseHelper(this.getContext());
        transactionsList = database.getTa();
        Collections.reverse(transactionsList);
        //create adapter passing the data, and the context
        adapter = new TransactionsRecyclerViewAdapter(transactionsList, this.getContext());
        //attach the adapter to the RecyclerView
        transactionsRecyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        transactionsRecyclerView.setLayoutManager(layoutManager);


        return view;
    }

}