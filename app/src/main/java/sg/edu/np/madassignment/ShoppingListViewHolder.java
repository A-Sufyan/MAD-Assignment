package sg.edu.np.madassignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ShoppingListViewHolder extends RecyclerView.ViewHolder {
    TextView foodName;
    TextView foodCategory;
    ImageView foodImage;

    public ShoppingListViewHolder(View itemView){
        super(itemView);
        foodName = itemView.findViewById(R.id.textView_FoodName);
        foodCategory = itemView.findViewById(R.id.textView_FoodCategory);
        foodImage = itemView.findViewById(R.id.imageView_FoodImage);
    }
}
