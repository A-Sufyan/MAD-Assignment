package sg.edu.np.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class CompareActivity extends AppCompatActivity {

    //Initialize variables
    ArrayList<ShoppingList> shoppingList; //To add food items into shopping list after comparison/calculation
    ArrayList<CompareItem> compareList = new ArrayList<CompareItem>();
    EditText brandInput;
    EditText amountInput;
    EditText priceInput;
    Button addtoCompareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        //Assign variables
        brandInput = findViewById(R.id.brandEditText);
        amountInput = findViewById(R.id.amountEditText);
        priceInput = findViewById(R.id.priceEditText);
        addtoCompareButton = findViewById(R.id.addtoCompare);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        RecyclerView recyclerViewCompare = findViewById(R.id.compareRecyclerView);
        CompareItemAdapter compareAdapter = new CompareItemAdapter(compareList);
        LinearLayoutManager compareLayoutManager = new LinearLayoutManager(this);
        recyclerViewCompare.setLayoutManager(compareLayoutManager);
        recyclerViewCompare.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCompare.setAdapter(compareAdapter);

        addtoCompareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CompareItem temporaryItem = new CompareItem();
                temporaryItem.setPrice(Double.valueOf(priceInput.getText().toString()));
                temporaryItem.setAmount(Integer.valueOf(amountInput.getText().toString()));
                temporaryItem.setBrand(brandInput.getText().toString());
                compareList.add(temporaryItem);
                compareAdapter.notifyDataSetChanged();
            }
        });

        //Bottom Navigation Bar: Set Home Page selected
        bottomNavigationView.setSelectedItemId(R.id.comparerpage);

        //Bottom Navigation Bar: ItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homepage:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.comparerpage:
                        return true;
                    case R.id.shoppinglistpage:
                        startActivity(new Intent(getApplicationContext(), ShoppingListActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.advicepage:
                        startActivity(new Intent(getApplicationContext(), adviceActivityHomepage.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
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