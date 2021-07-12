package sg.edu.np.madassignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ShoppingListViewHolder extends RecyclerView.ViewHolder {
    TextView itemName;
    TextView itemAmount;
    TextView itemPrice;
    ImageView itemImage;

    public ShoppingListViewHolder(View itemView){
        super(itemView);
        itemName = itemView.findViewById(R.id.textView_ItemName);
        itemAmount = itemView.findViewById(R.id.textView_ItemAmount);
        itemPrice = itemView.findViewById(R.id.textView_ItemPrice);
        itemImage = (ImageView) itemView.findViewById(R.id.imageView_ItemImage);
    }
}
