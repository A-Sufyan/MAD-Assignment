package sg.edu.np.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class adviceActivityHomepage extends AppCompatActivity {

    ArrayList<ShoppingList> myList = new ArrayList<>();
    private final static String TAG = "Advice activity Homepage";
    private adviceActivityAdapter.RecyclerViewClickListener listener;
    DBHandler dbHandler = new DBHandler(
            this,null,null,1
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice_homepage);

        ShoppingList temporaryProduct = new ShoppingList();
        myList = dbHandler.get
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