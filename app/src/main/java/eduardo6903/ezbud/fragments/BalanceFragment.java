package eduardo6903.ezbud.fragments;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import eduardo6903.ezbud.database.DatabaseHelper;

import eduardo6903.ezbud.R;
import eduardo6903.ezbud.entities.Transactions;
import eduardo6903.ezbud.entities.User;
import eduardo6903.ezbud.recyclerview.TransactionsRecyclerViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class BalanceFragment extends Fragment {

    List<Transactions> transactionsList;
    Transactions transactions = new Transactions();
    User user;
    TransactionsRecyclerViewAdapter adapter;
    DatabaseHelper database;
    Cursor cursor;
    TextView txtName, txtGreet, txtBalance;
    String msg = " ", dateDef="";


    public BalanceFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dateDef = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        user = new User();

        final View view =  inflater.inflate(R.layout.fragment_balance, container, false);

        // Fill Good morning/afternoon/eve/night

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            msg = "Good morning,";
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            msg = "Good afternoon,";
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            msg = "Good evening,";
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            msg = "Good night,";
        }

        txtGreet = view.findViewById(R.id.txtgreet);
        txtGreet.setText(msg);

        //Load Data from the database
        database = new DatabaseHelper(this.getContext());
        cursor = database.getUser();
        cursor.moveToFirst();

        // check if the user has details
        if (cursor.getCount() <= 0) {
            showAlertWithTextInputLayout();

        } else {

            user.setName(cursor.getString(1));
            user.setBalance(Double.parseDouble(cursor.getString(2)));
            user.setIncome(Double.parseDouble((cursor.getString(3))));
            user.setDateIncome(cursor.getString(4));
            fillUser(view, user);
        }

        database.close();
        cursor.close();


        final RecyclerView transactionsRecyclerView = view.findViewById(R.id.taRecyclerViewBalFrag);
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

    public void fillUser(View view, User user) {
        txtName = view.findViewById(R.id.txtName);
        txtName.setText(user.getName());
        if (user.getIncome() != null) {
            DecimalFormat df = new DecimalFormat("0.00");
            txtBalance = view.findViewById(R.id.txtBalance);
            txtBalance.setText("$" + df.format(user.getBalance()));
        }
    }


    public void showAlertWithTextInputLayout() {
        TextInputLayout textInputLayout = new TextInputLayout(this.getContext());
        textInputLayout.setPadding( getResources().getDimensionPixelOffset(R.dimen.dp_19), // if you look at android alert_dialog.xml, you will see the message textview have margin 14dp and padding 5dp. This is the reason why I use 19 here
                0,
                getResources().getDimensionPixelOffset(R.dimen.dp_19),
                0);
        textInputLayout.setBoxBackgroundColor(R.drawable.round_corners_style_container);
        final EditText input =  new EditText(this.getContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        textInputLayout.addView(input);

        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext())
                .setTitle("Your name")
                .setView(textInputLayout)
                .setMessage("Please enter your name");

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(input.getText().toString().isEmpty()) {
                    database.insertUser(" ", 0.00, 0.00, "");
                    user.setName(" ");
                } else {
                    database.insertUser(input.getText().toString(), 0.00, 0.00, "");
                    user.setName(input.getText().toString());
                }

                fillUser(BalanceFragment.super.getView(), user);
                Snackbar.make(BalanceFragment.super.getView(), "User name saved", Snackbar.LENGTH_SHORT).show();
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
