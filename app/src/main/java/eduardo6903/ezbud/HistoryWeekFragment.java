package eduardo6903.ezbud;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryWeekFragment extends Fragment implements View.OnClickListener{


    public HistoryWeekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history_week, container, false);


        Button btnIncome = view.findViewById(R.id.btnWeek);
        Button btnOutcome = view.findViewById(R.id.btnMonth);

        btnIncome.setOnClickListener(this);
        btnOutcome.setOnClickListener(this);


        return view;
    }



    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.btnWeek:
                view.findViewById(R.id.btnWeek).setBackgroundColor(Color.GRAY);
                fragment = new HistoryWeekFragment();
                loadFragment(fragment);
                break;

            case R.id.btnMonth:
                view.findViewById(R.id.btnMonth).setBackgroundColor(Color.GRAY);
                fragment = new HistoryMonthFragment();
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