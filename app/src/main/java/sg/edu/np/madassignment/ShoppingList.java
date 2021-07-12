package sg.edu.np.madassignment;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class ShoppingList {
    public String itemName;
    public String itemCategory;
    public String itemDescription;
    public Integer itemAmount;
    public Double itemPrice;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Integer getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Integer itemAmount) {
        this.itemAmount = itemAmount;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public ShoppingList(String itemName, String itemCategory, Integer itemAmount,
                        Double itemPrice, String itemDescription) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemAmount = itemAmount;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }
    public ShoppingList() {};
}
