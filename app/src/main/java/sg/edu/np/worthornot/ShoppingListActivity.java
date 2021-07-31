package sg.edu.np.worthornot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity{

// ------------------ Section for variable initialization  ---------------------------------------------
    TextView spinnerTextView;
    Dialog dialog;
    ArrayList<ShoppingList> shoppingList = new ArrayList<>();
    ArrayList<String> shoppingListItemName = new ArrayList<>();
    ShoppingList temporaryItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getIntent().getExtras() != null){
            Bundle recieveData = getIntent().getExtras();
            temporaryItem.setItemName(recieveData.getString("newName"));
            temporaryItem.setItemCategory(recieveData.getString("newCategory"));
            temporaryItem.setItemDescription(recieveData.getString("newDescription"));
            temporaryItem.setItemAmount(recieveData.getInt("newAmount"));
            temporaryItem.setItemPrice(recieveData.getDouble("newPrice"));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppinglist);

// ------------------ Section for variable assignment---------------------------------------------
        spinnerTextView = findViewById(R.id.text_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Add items into ShoppingList
        addItemsIntoShoppingList(shoppingList);

        // Call method to Build RecyclerView
        buildRecyclerView();

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

    // this code down here just for testing only right ?? (delete this comment)
    public ArrayList<ShoppingList> addItemsIntoShoppingList(ArrayList<ShoppingList> sList) {
        /*for (int i = 1; i < 5; i++){
            ShoppingList item = new ShoppingList("ItemName" + String.valueOf(i), "Item", null ,100.0, 9.0);
            sList.add(item);
        }*/
        ShoppingList item1 = new ShoppingList("Food", "F", 9, 100.0, "bread");
        ShoppingList item2 = new ShoppingList("Drink", "D", 9, 100.0, "pepsi");
        ShoppingList item3 = new ShoppingList("Household Item", "H", 9, 100.0, "tissues");
        ShoppingList item4 = new ShoppingList("Pet Item", "P", 9, 100.0, "pet food");
        sList.add(item1);
        sList.add(item2);
        sList.add(item3);
        sList.add(item4);
        return sList;
    }
// ------------------ Section for method to build recycler view ---------------------------------------------
    public void buildRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView_ShoppingList);
        ShoppingListAdapter slAdapter = new ShoppingListAdapter(shoppingList);
        LinearLayoutManager slLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(slLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(slAdapter);
    }
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
    protected void onStop(){
        super.onStop();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
