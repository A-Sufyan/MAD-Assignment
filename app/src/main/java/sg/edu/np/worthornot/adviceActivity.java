package sg.edu.np.worthornot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class adviceActivity extends AppCompatActivity {
    private final static String TAG = "Advice Activity";

// ------------------ Section for onCreate()  ---------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "On Create Advice Activity");
        setContentView(R.layout.activity_advice);

// ------------------ Section for variable Assignment & Initialization ---------------------------------------------
        TextView productName = findViewById(R.id.adviceActivityitemTitle);
        TextView productDesc = findViewById(R.id.adviceActivityDescription);
        ImageView productIcon = findViewById(R.id.adviceActivityProductIcon);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

// ------------------ Section for receiving Intent from adviceActivityHomepage ---------------------------------------------
        Bundle recieveData = getIntent().getExtras();
        String recievedName = recieveData.getString("productname");
        String recievedDesc = recieveData.getString("productdesc");
        String recievedCategory = recieveData.getString("productcategory");

        if(recieveData.getString("productcategory").equals("f")){
            productIcon.setImageResource(R.drawable.ic_food);
        }
        else if (recieveData.getString("productcategory").equals("d")){
            productIcon.setImageResource(R.drawable.ic_drinks);

        }
        else if (recieveData.getString("productcategory").equals("h")){
            productIcon.setImageResource(R.drawable.ic_household_items);
        }
        productName.setText(recievedName);
        productDesc.setText(recievedDesc);

        //Bottom Navigation Bar: Set Home Page selected
        bottomNavigationView.setSelectedItemId(R.id.advicepage);

        //Bottom Navigation Bar: ItemSelectedListener
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
                        startActivity(new Intent(getApplicationContext(), ShoppingListActivity.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        return true;
                    case R.id.advicepage:
                        startActivity(new Intent(getApplicationContext(), adviceActivityHomepage.class));
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
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