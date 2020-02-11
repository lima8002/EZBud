package eduardo6903.ezbud.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eduardo6903.ezbud.R;
import eduardo6903.ezbud.entities.Transactions;

public class TransactionsRecyclerViewAdapter extends RecyclerView.Adapter<TransactionsViewHolder> {

    private List<Transactions> transactionsList;
    private Context context;

    /**
     * Constructor receiving the datasource of the recyclerView transactions list, and the context of the caller.
     * @param transactionsList      List of transactions to display in the recyclerView
     * @param context
     */
    public TransactionsRecyclerViewAdapter(List<Transactions> transactionsList, Context context) {
        this.transactionsList = transactionsList;
        this.context = context;
    }

    /**
     * Creates a view holder whenever the RecyclerView needs a new one, it creates a view holder(data in one element of the recyclerView).
     * This is the moment when the row layout is inflated (grab the recyclerview_item.xml and turning it into GUI component).
     * Creates a new view Holder(TransactionsViewHolder in this case) by passing the recently inflated view (recyclerview_item.xml in this case)
     *
     * @param parent        The ViewGroup into which the new View will be added after it is bound to
     *                      an adapter position.
     * @param viewType
     * @return      The TransactionsViewHolder ready to hold data of one Transaction
     */
    @NonNull
    @Override
    public TransactionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the custom layout
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);

        //Return a new holder instance.
        TransactionsViewHolder transactionsViewHolder = new TransactionsViewHolder(view);
        return transactionsViewHolder;
    }


    /**
     * Takes a ViewHolder object and sets the proper list data (from the list) on the view
     * @param holder    an object of MonsterViewHolder class, representing each item (CardView content)
     *                  in the recyclerView
     * @param position  the position of the monster in the monsters list
     */
    @Override
    public void onBindViewHolder(@NonNull TransactionsViewHolder holder, int position) {
        //get the data from the list, based on position
        Transactions ta = transactionsList.get(position);
        // call the method to set the values in the MonsterViewHolder
        holder.updateTransactions(ta);


    }

    /**
     * @return  returns the total number of the list size. The list values are passed by the constructor
     */
    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

    /**
     * Add a monster to the list of monsters shown by the Adapter ( monsters )
     * @param ta     Transaction to be added to the recyclerView
     */
    public void addItem(Transactions ta) {
        transactionsList.add(ta);
        notifyItemInserted(getItemCount());
    }
}
