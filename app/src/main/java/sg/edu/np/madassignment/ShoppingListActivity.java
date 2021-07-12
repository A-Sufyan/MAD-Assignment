package sg.edu.np.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity{
    //Variable initialization
    TextView spinnerTextView;
    Dialog dialog;
    Context context;
    ArrayList<ShoppingList> shoppingList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppinglist);

        //Assigning of Variables
        spinnerTextView = findViewById(R.id.text_view);

        //Add items into ShoppingList
        addItemsIntoShoppingList(shoppingList);

        //Build RecyclerView
        buildRecyclerView();

        //Build Searchable Spinner
        buildSearchableSpinner();
    }

    public ArrayList<ShoppingList> addItemsIntoShoppingList(ArrayList<ShoppingList> sList) {
        /*for (int i = 1; i < 5; i++){
            ShoppingList item = new ShoppingList("ItemName" + String.valueOf(i), "Item", null ,100.0, 9.0);
            sList.add(item);
        }*/
        ShoppingList item1 = new ShoppingList("Food", "F", null, 100.0, 9.0);
        ShoppingList item2 = new ShoppingList("Drink", "D", null, 100.0, 9.0);
        ShoppingList item3 = new ShoppingList("Household Item", "H", null, 100.0, 9.0);
        ShoppingList item4 = new ShoppingList("Pet Item", "P", null, 100.0, 9.0);
        sList.add(item1);
        sList.add(item2);
        sList.add(item3);
        sList.add(item4);
        return sList;
    }

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

    public void buildSearchableSpinner() {
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

                ArrayAdapter<ShoppingList> adapter = new ArrayAdapter<>(ShoppingListActivity.this, android.R.layout.simple_list_item_1, shoppingList);
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
