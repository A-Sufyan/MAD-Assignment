package sg.edu.np.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity{
    private ArrayList<ShoppingList> shoppingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppinglist);
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
