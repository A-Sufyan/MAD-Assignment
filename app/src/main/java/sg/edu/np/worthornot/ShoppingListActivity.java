package sg.edu.np.worthornot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

import static android.content.ContentValues.TAG;

public class ShoppingListActivity extends AppCompatActivity{

// ------------------ Section for variable initialization  ---------------------------------------------
    TextView spinnerTextView;
    Dialog dialog;
    ArrayList<ShoppingList> shoppingList = new ArrayList<>();
    ArrayList<String> shoppingListItemName = new ArrayList<>();
    ShoppingList temporaryItem = new ShoppingList();
    ImageView manualAddToShoppingList;
    RecyclerView recyclerView;
    ShoppingListAdapter slAdapter;
    LinearLayoutManager slLayoutManager;
    DividerItemDecoration dividerItemDecoration;
    BottomNavigationView bottomNavigationView;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppinglist);

// ------------------ Section for variable assignment---------------------------------------------
        spinnerTextView = findViewById(R.id.text_view);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        manualAddToShoppingList = findViewById(R.id.manualAddToShoppingListButton);
        resetButton = findViewById(R.id.resetButton);

        manualAddToShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddToShoppingListActivity.class);
                startActivity(intent);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                shoppingList = new ArrayList<>();
                saveData();
                Intent intent = new Intent(getApplicationContext(), ShoppingListActivity.class);
                startActivity(intent);
            }
        });

        //Add items into ShoppingList
        loadData();

        //Build RecyclerView
        recyclerView = findViewById(R.id.recyclerView_ShoppingList);
        slAdapter = new ShoppingListAdapter(shoppingList);
        slLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(slLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(slAdapter);

// ------------------ Section for receiving intent from addtoShoppingList activity ---------------------------------------------
        if (getIntent().getExtras() != null){
            Bundle recieveData = getIntent().getExtras();
            temporaryItem.setItemName(recieveData.getString("newName"));
            temporaryItem.setItemCategory(recieveData.getString("newCategory"));
            temporaryItem.setItemDescription(recieveData.getString("newDescription"));
            temporaryItem.setItemAmount(recieveData.getInt("newAmount"));
            temporaryItem.setItemPrice(recieveData.getDouble("newPrice"));
            shoppingList.add(temporaryItem);
            slAdapter.notifyDataSetChanged();
        }
// ------------------ Section for building the methods ---------------------------------------------
        // Save ShoppingList data
        saveData();

        // Call method to Build Searchable Spinner
        buildSearchableSpinner();

        //Build Bottom Navigation Bar
        //Set Home Page selected
        bottomNavigationView.setSelectedItemId(R.id.shoppinglistpage);

        //ItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homepage:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.comparerpage:
                        startActivity(new Intent(getApplicationContext(), CompareActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.shoppinglistpage:
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

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedpref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(shoppingList);
        editor.putString("shopping list", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedpref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("shopping list", null);
        Type type = new TypeToken<ArrayList<ShoppingList>>() {}.getType();
        shoppingList = gson.fromJson(json, type);

        if (shoppingList == null){
            shoppingList = new ArrayList<>();
        }
    }
    // this code down here just for testing only right ?? (delete this comment)
    /*public ArrayList<ShoppingList> addItemsIntoShoppingList(ArrayList<ShoppingList> sList, ShoppingList addedItem) {
        /*for (int i = 1; i < 5; i++){
            ShoppingList item = new ShoppingList("ItemName" + String.valueOf(i), "Item", null ,100.0, 9.0);
            sList.add(item);
        }
        ShoppingList item1 = new ShoppingList("Food", "F", 9, 100.0, "bread");
        ShoppingList item2 = new ShoppingList("Drink", "D", 9, 100.0, "pepsi");
        ShoppingList item3 = new ShoppingList("Household Item", "H", 9, 100.0, "tissues");
        ShoppingList item4 = new ShoppingList("Pet Item", "P", 9, 100.0, "pet food");
        sList.add(item1);
        sList.add(item2);
        sList.add(item3);
        sList.add(item4);
        if (addedItem != null) {
            sList.add(addedItem);
        }
        return sList;
    }*/
// ------------------ Section for method to build Spinner ---------------------------------------------
    public void buildSearchableSpinner() {
        for (int i = 0; i < shoppingList.size(); i++) {
            shoppingListItemName.add(shoppingList.get(i).itemName);
        }
        spinnerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dialog
                dialog = new Dialog(ShoppingListActivity.this);
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                dialog.getWindow().setLayout(650, 800);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(ShoppingListActivity.this, android.R.layout.simple_list_item_1, shoppingListItemName);
                listView.setAdapter(adapter);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        adapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        spinnerTextView.setText(String.valueOf(adapter.getItem(position)));
                        dialog.dismiss();
                    }
                });
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
    protected void onPause(){
        super.onPause();

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
