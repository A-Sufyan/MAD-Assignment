package sg.edu.np.worthornot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

// ------------------ Section for receiving Intent if adding from CompareActivity ---------------------------------------------
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("productBrand")){
            Bundle recieveData = getIntent().getExtras();
            receivedBrand = recieveData.getString("productBrand");
            receivedPrice = String.valueOf(recieveData.getDouble("productPrice"));

            Brand.setText(receivedBrand);
            Price.setText(receivedPrice);
            Quantity.setText(receivedQuantity);
        }

// ------------------ Section for sending variables of ShoppingList Object to ShoppingListActivity ---------------------------------------------
        addToShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Brand.getText().toString().equals("")){
                    Toast.makeText(AddToShoppingListActivity.this,
                            "Brand field is empty!", Toast.LENGTH_SHORT).show();
                }
                else if (Name.getText().toString().equals("")){
                    Toast.makeText(AddToShoppingListActivity.this,
                            "Name field is empty!", Toast.LENGTH_SHORT).show();
                }
                else if(Category.getText().toString().equals("")){
                    Toast.makeText(AddToShoppingListActivity.this,
                            "Category field is empty!", Toast.LENGTH_SHORT).show();
                }
                else if(Quantity.getText().toString().equals("")){
                    Toast.makeText(AddToShoppingListActivity.this,
                            "Quantity field is empty!", Toast.LENGTH_SHORT).show();
                }
                else if(Price.getText().toString().equals("")){
                    Toast.makeText(AddToShoppingListActivity.this,
                            "Price field is empty!", Toast.LENGTH_SHORT).show();
                }

                else{
                    if (Category.getText().toString().toUpperCase().equals("F") ){
                        newCategory = "F";
                        newDescription = "This is a Food product";
                    }
                    else if (Category.getText().toString().toUpperCase().equals("D")){
                        newCategory = "D";
                        newDescription = "This is a Drink product";
                    }
                    else if (Category.getText().toString().toUpperCase().equals("H")){
                        newCategory = "H";
                        newDescription = "This is a Household product";
                    }
                    else {
                        newCategory = "H"; // Defaults any other inputs to household
                        newDescription = "This is a Household product";
                    }
                    Bundle extras = new Bundle();
                    extras.putString("newName", Name.getText().toString());
                    extras.putString("newCategory", newCategory);
                    extras.putString("newDescription", newDescription);
                    extras.putInt("newAmount", Integer.valueOf(
                            Quantity.getText().toString()));
                    extras.putDouble("newPrice", Double.valueOf(
                            Price.getText().toString()
                    ));
                    Intent intent = new Intent(AddToShoppingListActivity.this,
                            ShoppingListActivity.class);
                    intent.putExtras(extras);
                    startActivity(intent);
                }

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