package sg.edu.np.madassignment;

import android.media.Image;

public class ShoppingList {
    private String foodName;
    private String foodCategory;
    private Image foodImage;
    //private String foodDescription
    //private Integer foodQuantity

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public Image getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(Image foodImage) {
        this.foodImage = foodImage;
    }

    public ShoppingList(String foodName, String foodCategory, Image foodImage) {
        this.foodName = foodName;
        this.foodCategory = foodCategory;
        this.foodImage = foodImage;
    }
}
