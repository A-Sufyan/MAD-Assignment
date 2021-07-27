package sg.edu.np.worthornot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompareItemAdapter extends RecyclerView.Adapter
<CompareItemViewHolder>{

    ArrayList<CompareItem> compareData;

    public CompareItemAdapter(ArrayList<CompareItem> input){
        compareData = input;
    }
    public CompareItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.compare_layout, parent,false);
        return new CompareItemViewHolder(item);
    }
    public void onBindViewHolder(CompareItemViewHolder holder, int pos){
        CompareItem list_items = compareData.get(pos);
        holder.itemBrand.setText(list_items.getBrand());
        holder.itemPricePerAmt.setText(String.valueOf(list_items.CalculateValue()));

    }

    public int getItemCount() { return compareData.size(); }

}
