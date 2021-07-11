package sg.edu.np.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity{
    //Variable initialization
    private ArrayList<ShoppingList> shoppingList;
    Spinner spinner;
    TextView spinnerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppinglist);

        //Variable assignation
        spinner = findViewById(R.id.spinner);
        spinnerTextView = findViewById(R.id.text_view);
        ArrayList<String> searchList = new ArrayList<>();

        //Spinner
        addItemsToSpinner(searchList);
        spinner.setAdapter(new ArrayAdapter<>(ShoppingListActivity.this, android.R.layout.simple_spinner_dropdown_item, searchList));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(getApplicationContext(), "Please select item", Toast.LENGTH_SHORT).show();
                    spinnerTextView.setText("");
                }
                else{
                    String selectItem = parent.getItemAtPosition(position).toString();
                    spinnerTextView.setText(selectItem);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //RecyclerView
        buildRecyclerView(shoppingList);
    }
    public void buildRecyclerView(ArrayList<ShoppingList> inputList) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView_ShoppingList);
        ShoppingListAdapter slAdapter = new ShoppingListAdapter(inputList);
        LinearLayoutManager slLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(slLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(slAdapter);
    }
    public ArrayList<String> addItemsToSpinner(ArrayList<String> sList){
        sList.add("Add items");
        for (int i = 1; i < 5; i++){
            sList.add("test" + String.valueOf(i));
        }
        return sList;
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
