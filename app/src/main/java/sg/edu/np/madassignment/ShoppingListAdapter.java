package sg.edu.np.madassignment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URI;
import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListViewHolder> {
    ArrayList<ShoppingList> shoppingData;
    Context context;
    Drawable foodDrawable;
    Drawable drinkDrawable;
    Drawable householdDrawable;
    Drawable petDrawable;

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
        if (shoppingItem.getItemCategory().equals("F")) {
            holder.itemName.setText(shoppingItem.getItemName());
            holder.itemAmount.setText('$' + String.valueOf(String.format("%.2f", shoppingItem.getItemAmount())));
            holder.itemPrice.setText(String.valueOf(shoppingItem.getItemPrice()) + " (g)");
            holder.itemImage.setImageResource(R.drawable.ic_food);
        }
        else if (shoppingItem.getItemCategory().equals("D")) {
            holder.itemName.setText(shoppingItem.getItemName());
            holder.itemAmount.setText('$' + String.valueOf(String.format("%.2f", shoppingItem.getItemAmount())));
            holder.itemPrice.setText(String.valueOf(shoppingItem.getItemPrice()) + " (g)");
            holder.itemImage.setImageResource(R.drawable.ic_drinks);
        }
        else if (shoppingItem.getItemCategory().equals("H")) {
            holder.itemName.setText(shoppingItem.getItemName());
            holder.itemAmount.setText('$' + String.valueOf(String.format("%.2f", shoppingItem.getItemAmount())));
            holder.itemPrice.setText(String.valueOf(shoppingItem.getItemPrice()) + " (g)");
            holder.itemImage.setImageResource(R.drawable.ic_household_items);
        }
        else if (shoppingItem.getItemCategory().equals("P")) {
            holder.itemName.setText(shoppingItem.getItemName());
            holder.itemAmount.setText('$' + String.valueOf(String.format("%.2f", shoppingItem.getItemAmount())));
            holder.itemPrice.setText(String.valueOf(shoppingItem.getItemPrice()) + " (g)");
            holder.itemImage.setImageResource(R.drawable.ic_pet_items);
        }
        else {
            holder.itemName.setText("Item not found!");
        }
        //holder.foodImage.setImageURI(s); <-- TODO need to find solution to bind image for foodImage
    }

    public int getItemCount(){
        return shoppingData.size();
    }
}
