package sg.edu.np.madassignment;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListViewHolder> {
    ArrayList<ShoppingList> shoppingData;

    public ShoppingListAdapter(ArrayList<ShoppingList> input){
        shoppingData = input;
    }

    public ShoppingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(
                android.R.layout.simple_list_item_1, parent, false);
        return new ShoppingListViewHolder(item);
    }

    public void onBindViewHolder(ShoppingListViewHolder holder, int position){
        ShoppingList s = shoppingData.get(position);
        holder.foodName.setText(String.valueOf(s));
        holder.foodCategory.setText(String.valueOf(s));
        //holder.foodImage.setImageURI(s); <-- need to find solution to bind image for foodImage
    }

    public int getItemCount(){
        return shoppingData.size();
    }
}
