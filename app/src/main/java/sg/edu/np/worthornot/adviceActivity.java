package sg.edu.np.worthornot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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