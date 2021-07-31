package sg.edu.np.worthornot;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class CompareItemAdapter extends
        RecyclerView.Adapter<CompareItemAdapter.CompareItemViewHolder>{
// ------------------- Initialize a CompareItem Array list --------------------
    ArrayList<CompareItem> compareData;

// ------------------- Initialize a RecyclerViewClickListener --------------------
    private RecyclerViewClickListener listener;

// ------------------- Parse in list and listener to adapter --------------------
    public CompareItemAdapter(ArrayList<CompareItem> input,
                              RecyclerViewClickListener listener){
        this.compareData = input;
        this.listener = listener;
    }

// ----------------------------- Implementation of CompareItemViewHolder ----------------------
    public class CompareItemViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener {
        TextView itemBrand;
        TextView itemPricePerAmt;
        Button AddToShoppingListButton;

        public CompareItemViewHolder(View itemView){
            super(itemView);
            itemBrand = itemView.findViewById
                    (R.id.compare_layoutBrand);
            itemPricePerAmt = itemView.findViewById(
                    R.id.compare_layoutPricePerAmount);
            AddToShoppingListButton = itemView.findViewById(R.id.addtoShoppingList);
            AddToShoppingListButton.setOnClickListener(this);
        }

        @Override
        public void onClick (View v){
            listener.onClick(v, getAdapterPosition());
        }
    }

// ------------------- Method onCreateViewHolder  -----------------------------------------
    public CompareItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.compare_layout, parent,false);
        return new CompareItemViewHolder(item);
    }

// ------------------- Method onBindViewHolder  -------------------------------------------------
    public void onBindViewHolder(CompareItemViewHolder holder, int pos){
        CompareItem list_items = compareData.get(pos);
        holder.itemBrand.setText(list_items.getBrand());
        holder.itemPricePerAmt.setText(String.format("%.3f", list_items.CalculateValue()));
    }

// ------------------- Interface for RecyclerViewClickListener  -------------------------------------------------
    public interface RecyclerViewClickListener {
        void onClick(View v, int pos);
    }

// ------------------- Method getItemCount  -------------------------------------------------
    public int getItemCount() { return compareData.size(); }

}
