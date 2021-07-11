package sg.edu.np.madassignment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CompareItemViewHolder extends RecyclerView.ViewHolder {
    TextView itemBrand;
    TextView itemPricePerAmt;
    //TextView comment;

    public CompareItemViewHolder(View itemView){
        super(itemView);
        itemBrand = itemView.findViewById
                (R.id.compare_layoutBrand);
        itemPricePerAmt = itemView.findViewById(
                R.id.compare_layoutPricePerAmount);

    }
}
