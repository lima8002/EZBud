package eduardo6903.ezbud;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BudgetOutcomeFragment extends Fragment implements View.OnClickListener {


    public BudgetOutcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view =  inflater.inflate(R.layout.fragment_budget_outcome, container, false);

        Button btnIncome = view.findViewById(R.id.btnIncome);
        Button btnOutcome = view.findViewById(R.id.btnOutcome);

        ImageButton ImageButton1 = view.findViewById(R.id.ib1);
        ImageButton ImageButton2 = view.findViewById(R.id.ib2);
        ImageButton ImageButton3 = view.findViewById(R.id.ib3);
        ImageButton ImageButton4 = view.findViewById(R.id.ib4);
        ImageButton ImageButton5 = view.findViewById(R.id.ib5);
        ImageButton ImageButton6 = view.findViewById(R.id.ib6);
        ImageButton ImageButton7 = view.findViewById(R.id.ib7);
        ImageButton ImageButton8 = view.findViewById(R.id.ib8);
        ImageButton ImageButton9 = view.findViewById(R.id.ib9);
        ImageButton ImageButton10 = view.findViewById(R.id.ib10);
        ImageButton ImageButton11 = view.findViewById(R.id.ib11);
        ImageButton ImageButton12 = view.findViewById(R.id.ib12);

        btnIncome.setOnClickListener(this);
        btnOutcome.setOnClickListener(this);

        ImageButton1.setOnClickListener(this);
        ImageButton2.setOnClickListener(this);
        ImageButton3.setOnClickListener(this);
        ImageButton4.setOnClickListener(this);
        ImageButton5.setOnClickListener(this);
        ImageButton6.setOnClickListener(this);
        ImageButton7.setOnClickListener(this);
        ImageButton8.setOnClickListener(this);
        ImageButton9.setOnClickListener(this);
        ImageButton10.setOnClickListener(this);
        ImageButton11.setOnClickListener(this);
        ImageButton12.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.btnIncome:
                view.findViewById(R.id.btnIncome).setBackgroundColor(Color.GRAY);
                fragment = new BudgetIncomeFragment();
                replaceFragment(fragment);
                break;

            case R.id.btnOutcome:
                view.findViewById(R.id.btnOutcome).setBackgroundColor(Color.GRAY);
                fragment = new BudgetOutcomeFragment();
                replaceFragment(fragment);
                break;

            case R.id.ib1:
                view.findViewById(R.id.ib1).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib2:
                view.findViewById(R.id.ib2).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib3:
                view.findViewById(R.id.ib3).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib4:
                view.findViewById(R.id.ib4).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib5:
                view.findViewById(R.id.ib5).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib6:
                view.findViewById(R.id.ib6).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib7:
                view.findViewById(R.id.ib7).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib8:
                view.findViewById(R.id.ib8).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib9:
                view.findViewById(R.id.ib9).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib10:
                view.findViewById(R.id.ib10).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib11:
                view.findViewById(R.id.ib11).setBackgroundColor(Color.GRAY);
                break;

            case R.id.ib12:
                view.findViewById(R.id.ib12).setBackgroundColor(Color.GRAY);
                break;

        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrameLayoutContainer, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}
