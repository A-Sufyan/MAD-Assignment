package sg.edu.np.worthornot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adviceActivityAdapter extends
        RecyclerView.Adapter<adviceActivityAdapter.adviceActivityViewHolder>{

// ------------------- Initialize a ShoppingList Array list --------------------
    ArrayList<ShoppingList> list_products;

// ------------------- Initialize a RecyclerViewClickListener --------------------
    private RecyclerViewClickListener listener;

// ------------------- Parse in list and listener to adapter --------------------
    public adviceActivityAdapter(ArrayList<ShoppingList> input,
                                 RecyclerViewClickListener listener){
        this.list_products = input;
        this.listener = listener;
    }

// ----------------------------- Implementation of adviceActivityViewHolder ----------------------
    public class adviceActivityViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
        TextView productName;

        public adviceActivityViewHolder(View itemView){
            super(itemView);
            productName = itemView.findViewById(R.id.advice_layoutProductName);
            productName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            listener.onClick(v, getAdapterPosition());
        }
    }

// ------------------- Method onCreateViewHolder  ------------------------------ --------------------
    public adviceActivityViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_advice_layout, parent, false
        );
        return new adviceActivityViewHolder(item);
    }


// ------------------- Method onBindViewHolder  -------------------------------------------------
    public void onBindViewHolder(adviceActivityViewHolder holder, int pos){
        ShoppingList products_list = list_products.get(pos);
        holder.productName.setText(products_list.getItemName());
    }


    public interface RecyclerViewClickListener {
        void onClick(View v, int pos);
    }
// ------------------- Method getItemCount  -------------------------------------------------
    public int getItemCount() {
        return list_products.size();}
}
