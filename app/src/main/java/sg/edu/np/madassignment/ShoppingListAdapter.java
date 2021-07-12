package sg.edu.np.madassignment;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListViewHolder> {
    ArrayList<ShoppingList> shoppingData;

    public ShoppingListAdapter(ArrayList<ShoppingList> input){
        this.shoppingData = input;
    }

    public ShoppingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recyclerview_shoppinglist, parent, false);
        return new ShoppingListViewHolder(item);
    }

    public void onBindViewHolder(ShoppingListViewHolder holder, int position){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = 100;
        ShoppingList shoppingItem = shoppingData.get(position);
        holder.itemName.setText(shoppingItem.getItemName());
        holder.itemAmount.setText('$' + String.valueOf(String.format("%.2f", shoppingItem.getItemAmount())));
        holder.itemPrice.setText(String.valueOf(shoppingItem.getItemPrice()) + " (g)");
        //holder.foodImage.setImageURI(s); <-- TODO need to find solution to bind image for foodImage
    }

    public int getItemCount(){
        return shoppingData.size();
    }
}
