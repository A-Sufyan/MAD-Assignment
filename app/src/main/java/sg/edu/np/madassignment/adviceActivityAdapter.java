package sg.edu.np.madassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adviceActivityAdapter extends
        RecyclerView.Adapter<adviceActivityAdapter.adviceActivityViewHolder>{
    ArrayList<ShoppingList> list_products;
    private RecyclerViewClickListener listener;

    public adviceActivityAdapter(ArrayList<ShoppingList> input,
                                 RecyclerViewClickListener listener){
        this.list_products = input;
        this.listener = listener;
    }

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

    public adviceActivityViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_advice_layout, parent, false
        );
        return new adviceActivityViewHolder(item);
    }
    public void onBindViewHolder(adviceActivityViewHolder holder, int pos){
        ShoppingList products_list = list_products.get(pos);
        holder.productName.setText(products_list.getItemName());
    }
    public int getItemCount() {return list_products.size();}
    public interface RecyclerViewClickListener {
        void onClick(View v, int pos);
    }
}
