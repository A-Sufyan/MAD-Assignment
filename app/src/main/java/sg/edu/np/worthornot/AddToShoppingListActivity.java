package sg.edu.np.worthornot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddToShoppingListActivity extends AppCompatActivity {
    private final String TAG = "AddToShoppingListActivity";
    public ShoppingList temporaryItem;

//------------------   Section for onCreate()  -----------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_shopping_list);

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