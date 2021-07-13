package sg.edu.np.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class adviceActivityHomepage extends AppCompatActivity {

    ArrayList<ShoppingList> myList = new ArrayList<>();
    private final static String TAG = "AdviceActivityHomepage";
    private adviceActivityAdapter.RecyclerViewClickListener listener;
    DBHandler dbHandler = new DBHandler(
            this,null,null,1
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "On create AdviceActivityHomepage");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice_homepage);
        myList = dbHandler.getListOfShoppingList();
        setOnClickListener();
        RecyclerView recyclerView = findViewById(R.id.adviceActivityRecyclerView);
        adviceActivityAdapter myAdapter = new adviceActivityAdapter(myList, listener);
        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);

    }
    private void setOnClickListener() {
        listener = new adviceActivityAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int pos) {
                Log.v(TAG, "Item in Rview Clicked!");
                ClickedButton(pos);
            }

        };
    }

    private void ClickedButton(int position) {
        Bundle extras = new Bundle();
        extras.putString("productname", myList.get(position).getItemName());
        extras.putString("productdesc", myList.get(position).getItemDescription());
        extras.putString("productcategory", myList.get(position).getItemCategory());

        Intent intent = new Intent(getApplicationContext(), adviceActivity.class);
        intent.putExtras(extras);
        startActivity(intent);
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