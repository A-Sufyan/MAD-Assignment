package sg.edu.np.worthornot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompareItemAdapter extends RecyclerView.Adapter
<CompareItemViewHolder>{
// ------------------- Initialize a CompareItem Array list --------------------
    ArrayList<CompareItem> compareData;

// ------------------- Initialize a RecyclerViewClickListener --------------------


// ------------------- Parse in list and listener to adapter --------------------
    public CompareItemAdapter(ArrayList<CompareItem> input){
        compareData = input;
    }

// ----------------------------- Implementation of CompareItemViewHolder ----------------------





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
        holder.itemPricePerAmt.setText(String.valueOf(list_items.CalculateValue()));

    }
// ------------------- Method getItemCount  -------------------------------------------------

    public int getItemCount() { return compareData.size(); }

}
