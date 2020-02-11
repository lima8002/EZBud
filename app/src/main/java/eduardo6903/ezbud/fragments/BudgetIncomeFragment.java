package eduardo6903.ezbud.fragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import eduardo6903.ezbud.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BudgetIncomeFragment extends Fragment implements View.OnClickListener{


    public BudgetIncomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_budget_income, container, false);

        Button btnIncome = view.findViewById(R.id.btnIncome);
        Button btnOutcome = view.findViewById(R.id.btnOutcome);

        btnIncome.setOnClickListener(this);
        btnOutcome.setOnClickListener(this);


        return view;

    }


    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.btnIncome:
                view.findViewById(R.id.btnIncome).setBackgroundColor(Color.GRAY);
                fragment = new BudgetIncomeFragment();
                loadFragment(fragment);
                break;

            case R.id.btnOutcome:
                view.findViewById(R.id.btnOutcome).setBackgroundColor(Color.GRAY);
                fragment = new BudgetOutcomeFragment();
                loadFragment(fragment);
                break;
        }
    }

    public void loadFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrameLayoutContainer, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}