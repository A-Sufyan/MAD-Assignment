package sg.edu.np.madassignment;

import android.media.Image;

public class ShoppingList {
    public String itemName;
    public String itemCategory;
    public Image itemImage;
    //public String foodDescription;
    public Double itemAmount;
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

    public Image getItemImage() {
        return itemImage;
    }

    public void setItemImage(Image itemImage) {
        this.itemImage = itemImage;
    }

    public Double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public ShoppingList(String itemName, String itemCategory, Image itemImage, Double itemAmount, Double itemPrice) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemImage = itemImage;
        this.itemAmount = itemAmount;
        this.itemPrice = itemPrice;
    }
}
