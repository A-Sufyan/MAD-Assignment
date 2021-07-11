package sg.edu.np.madassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CompareActivity extends AppCompatActivity {
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
        brandInput = findViewById(R.id.brandEditText);
        amountInput = findViewById(R.id.amountEditText);
        priceInput = findViewById(R.id.priceEditText);
        addtoCompareButton = findViewById(R.id.addtoCompare);

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