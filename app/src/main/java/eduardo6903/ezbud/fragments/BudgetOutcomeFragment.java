package eduardo6903.ezbud.fragments;


import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import eduardo6903.ezbud.R;
import eduardo6903.ezbud.database.DatabaseHelper;
import eduardo6903.ezbud.entities.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class BudgetOutcomeFragment extends Fragment implements View.OnClickListener {

    private DatabaseHelper database;
    private String date;
    private Cursor cursor;
    private User user;


    public BudgetOutcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_budget_outcome, container, false);

        date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        user = new User();

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

        //Load Data from the database
        database = new DatabaseHelper(this.getContext());
        cursor = database.getUser();
        cursor.moveToFirst();
        if (cursor.getCount() > 0 ) {
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setBalance(Double.parseDouble(cursor.getString(2)));
            user.setIncome(Double.parseDouble((cursor.getString(3))));
            user.setDateIncome(cursor.getString(4));
        }
        cursor.close();
        database.close();



        return view;

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnIncome:
                view.findViewById(R.id.btnIncome).setBackgroundColor(Color.GRAY);
                replaceFragment(new BudgetIncomeFragment());
                break;

            case R.id.btnOutcome:
                view.findViewById(R.id.btnOutcome).setBackgroundColor(Color.GRAY);
                replaceFragment(new BudgetOutcomeFragment());
                break;

            case R.id.ib1:
                view.findViewById(R.id.ib1).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("Education");
                view.findViewById(R.id.ib1).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib2:
                view.findViewById(R.id.ib2).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("Shopping");
                view.findViewById(R.id.ib2).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib3:
                view.findViewById(R.id.ib3).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("House bills");
                view.findViewById(R.id.ib3).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib4:
                view.findViewById(R.id.ib4).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("Phone bill");
                view.findViewById(R.id.ib4).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib5:
                view.findViewById(R.id.ib5).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("Petrol");
                view.findViewById(R.id.ib5).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib6:
                view.findViewById(R.id.ib6).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("Public transport");
                view.findViewById(R.id.ib6).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib7:
                view.findViewById(R.id.ib7).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("Breakfast");
                view.findViewById(R.id.ib7).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib8:
                view.findViewById(R.id.ib8).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("Lunch & Dinner");
                view.findViewById(R.id.ib8).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib9:
                view.findViewById(R.id.ib9).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("Night out");
                view.findViewById(R.id.ib9).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib10:
                view.findViewById(R.id.ib10).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("Travel");
                view.findViewById(R.id.ib10).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib11:
                view.findViewById(R.id.ib11).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("ATM Withdraw");
                view.findViewById(R.id.ib11).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

            case R.id.ib12:
                view.findViewById(R.id.ib12).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons_click));
                showAlertWithTextInputLayout("Other");
                view.findViewById(R.id.ib12).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.round_style_buttons));
                break;

        }
    }

    private void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrameLayoutContainer, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void showAlertWithTextInputLayout(final String desc) {
        TextInputLayout textInputLayout = new TextInputLayout(this.getContext());
        textInputLayout.setPadding(getResources().getDimensionPixelOffset(R.dimen.dp_19), // if you look at android alert_dialog.xml, you will see the message textview have margin 14dp and padding 5dp. This is the reason why I use 19 here
                0,
                getResources().getDimensionPixelOffset(R.dimen.dp_19),
                0);
        textInputLayout.setBoxBackgroundColor(R.drawable.round_corners_style_container);
        final EditText input = new EditText(this.getContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        textInputLayout.addView(input);

        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext())
                .setTitle(desc)
                .setView(textInputLayout)
                .setMessage("Please enter the amount");

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Snackbar.make(BudgetOutcomeFragment.super.getView(), input.getText().toString(), Snackbar.LENGTH_SHORT).show();
                if (input.getText().toString().isEmpty()) {
                    Snackbar.make(BudgetOutcomeFragment.super.getView(), "Please enter an amount.", Snackbar.LENGTH_SHORT).show();
                } else {
                    database = new DatabaseHelper(BudgetOutcomeFragment.super.getContext());
                    database.insertTa("outcome", desc, Double.parseDouble(input.getText().toString()), date, user.getId());
                    Snackbar.make(BudgetOutcomeFragment.super.getView(), "New outcome added.", Snackbar.LENGTH_SHORT).show();
                    database.close();
                    replaceFragment(new BalanceFragment());
                }


                //BudgetOutcomeFragment.super.getView().findViewById(R.id.ib1).setBackgroundColor(Color.WHITE);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }
}
