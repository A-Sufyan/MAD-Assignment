package sg.edu.np.worthornot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
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
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        manualAddToShoppingList = findViewById(R.id.manualAddToShoppingListButton);
        resetButton = findViewById(R.id.resetButton);

// ------------------ Section for user add to Shopping List ---------------------------------------------
        manualAddToShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddToShoppingListActivity.class);
                startActivity(intent);
            }
        });

// ------------------ Section for reset button ---------------------------------------------
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                shoppingList = new ArrayList<>();
                saveData();
                Intent intent = new Intent(getApplicationContext(), ShoppingListActivity.class);
                startActivity(intent);
            }
        });

        //Load items into shopping list
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
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
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
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.comparerpage:
                        startActivity(new Intent(getApplicationContext(), CompareActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.shoppinglistpage:
                        return true;
                    case R.id.advicepage:
                        startActivity(new Intent(getApplicationContext(), adviceActivityHomepage.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
// ------------------ Section for method to build Spinner ---------------------------------------------
    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            shoppingList.remove(viewHolder.getAdapterPosition());
            saveData();
            slAdapter.notifyDataSetChanged();
        }
    };

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
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
