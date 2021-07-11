package sg.edu.np.madassignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ShoppingListViewHolder extends RecyclerView.ViewHolder {
    TextView foodName;
    TextView foodAmount;
    TextView foodPrice;
    ImageView foodImage;

    public ShoppingListViewHolder(View itemView){
        super(itemView);
        foodName = itemView.findViewById(R.id.textView_FoodName);
        foodAmount = itemView.findViewById(R.id.textView_FoodAmount);
        foodPrice = itemView.findViewById(R.id.textView_FoodPrice);
        foodImage = itemView.findViewById(R.id.imageView_FoodImage);
    }
}
