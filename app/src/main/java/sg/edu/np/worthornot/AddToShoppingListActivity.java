package sg.edu.np.worthornot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddToShoppingListActivity extends AppCompatActivity {
// ------------------ Section for variable Assignment ------------------------------------------
    private final String TAG = "ATShoppingListActivity";
    EditText Brand;
    EditText Name;
    EditText Category;
    EditText Quantity;
    EditText Price;
    String receivedBrand;
    String receivedPrice;
    String receivedQuantity;
    Button addToShoppingList;
    String newCategory; // Used for input validation
    String newDescription;

//------------------   Section for onCreate()  -----------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "On Create ATShoppingList!");
        setContentView(R.layout.activity_add_to_shopping_list);

// ------------------ Section for variable Initialization ---------------------------------------------
        Brand = findViewById(R.id.addToShoppingList_BrandInput);
        Name = findViewById(R.id.addToShoppingList_NameInput);
        Category = findViewById(R.id.addToShoppingList_CategoryInput);
        Quantity = findViewById(R.id.addToShoppingList_QuantityInput);
        Price = findViewById(R.id.addToShoppingList_PriceInput);
        addToShoppingList = findViewById(R.id.addtoShoppingList_Button);

// ------------------ Section for receiving Intent from CompareActivity ---------------------------------------------
        Bundle recieveData = getIntent().getExtras();
        receivedBrand = recieveData.getString("productBrand");
        receivedPrice = String.valueOf(recieveData.getDouble("productPrice"));
        receivedQuantity = String.valueOf(recieveData.getInt("productQuantity"));

// ------------------ Section for setting received values into EditTexts ---------------------------------------------
        Brand.setText(receivedBrand);
        Price.setText(receivedPrice);
        Quantity.setText(receivedQuantity);

// ------------------ Section for setting category and description ---------------------------------------------
        if (Category.getText().toString().toUpperCase() == "F"){
            newCategory = "F";
            newDescription = "This is a Food product";
        }
        else if (Category.getText().toString().toUpperCase() == "D"){
            newCategory = "D";
            newDescription = "This is a Drink product";
        }
        else if (Category.getText().toString().toUpperCase() == "H"){
            newCategory = "H";
            newDescription = "This is a Household product";
        }
        else {
            newCategory = "H"; // Defaults any other inputs to household
            newDescription = "This is a Household product";
        }

// ------------------ Section for sending variables of ShoppingList Object to ShoppingListActivity ---------------------------------------------
        addToShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "ATShoppingList button Clicked");
                Bundle extras = new Bundle();
                extras.putString("newName", Name.getText().toString());
                extras.putString("newCategory", newCategory);
                extras.putString("newDescription", newDescription);
                extras.putInt("newAmount", Integer.valueOf(
                        Quantity.getText().toString()));
                extras.putDouble("newPrice", Double.valueOf(
                        Price.getText().toString()
                ));
                Intent intent = new Intent(getApplicationContext(),
                        ShoppingListActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });


    }



    @Override
    protected void onStart(){
        super.onStart();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    protected void onStop(){
        super.onStop();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}