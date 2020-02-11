package eduardo6903.ezbud.recyclerview;


import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import eduardo6903.ezbud.R;
import eduardo6903.ezbud.entities.Transactions;


/**
 * We create this view holder representing the recycler_item_view.xml
 * The idea of this class is to create a class that can manipulate the view
 */
public class TransactionsViewHolder extends RecyclerView.ViewHolder {

    //binding recyclerview_item.xml elements

    public final TextView taDescription;
    public final TextView taAmount;

    public TransactionsViewHolder(@NonNull View itemView) {
        super(itemView);

        taAmount = itemView.findViewById(R.id.taAmount);
        taDescription = itemView.findViewById(R.id.taDescription);

    }


    /**
     * Method used to update the data of the ViewHolder of a particular monster
     * @param ta       The Transactions object containing the data to populate the correspondent TransactionsViewHolder
     */
    public void updateTransactions(Transactions ta){

        //Tags are essentially an extra piece of information that can be associated with a view.
        //They are most often used as a convenience to store data related to views in the views
        //themselves rather than by putting them in a separate structure.
        this.taDescription.setText(ta.getDescription());
        this.taAmount.setText(ta.getAmount().toString());
    }


}
