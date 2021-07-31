package sg.edu.np.worthornot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    /* TODO:
    *   - Add headers for shoppingList
        - Finish implementing Cloud Storage (MAYBE NOT)
        * WHEN SUBMITTING : REMOVE ALL LOG
     */
    private final static String TAG = "Main Activity";

 // ------------------- Section to Initialize variables --------------------------------
    private ImageView GoToCalculator;
    private ImageView GoToShoppingList;
    private ImageView GoToAdvice;
    private Intent intent;
    private NavigationBarView.OnItemSelectedListener selectedListener;
    private NavigationBarView.OnItemReselectedListener reselectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "On Create main Activity!");

// ------------------ Section for variable assignment --------------------------------------------------------
        GoToCalculator = findViewById(R.id.GoToCompare);
        GoToShoppingList = (ImageView) findViewById(R.id.GoToShoppingList);
        GoToAdvice = findViewById(R.id.GoToAdvice);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

// ------------------ Section for button to go to Compare Activity ---------------------------------------------
        GoToCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Going to Compare page");
                intent = new Intent(MainActivity.this, CompareActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

// ------------------ Section for button to go to Shopping list Activity ---------------------------------------------
        GoToShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Going to Shopping List page");
                intent = new Intent(MainActivity.this, ShoppingListActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

// ------------------ Section for button to go to Advice Activity ---------------------------------------------
        GoToAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Going to advice page");
                intent = new Intent(MainActivity.this, adviceActivityHomepage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

// ------------------ Section for bottom navigation bar ---------------------------------------------
        //Bottom Navigation Bar: Set Home Page selected
        bottomNavigationView.setSelectedItemId(R.id.homepage);

        //Bottom Navigation Bar: ItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homepage:
                        return true;
                    case R.id.comparerpage:
                        startActivity(new Intent(getApplicationContext(), CompareActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        return true;
                    case R.id.shoppinglistpage:
                        startActivity(new Intent(getApplicationContext(), ShoppingListActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
    protected void onStop(){
        super.onStop();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

}