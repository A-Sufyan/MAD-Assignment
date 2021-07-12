package sg.edu.np.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class adviceActivity extends AppCompatActivity {
    private final static String TAG = "Advice Activty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "On Create Advice Activity");

        setContentView(R.layout.activity_advice);
        // ShoppingList newProduct = new ShoppingList();
        Bundle recieveData = getIntent().getExtras();

        TextView productName = findViewById(R.id.adviceActivityitemTitle);
        TextView productDesc = findViewById(R.id.adviceActivityDescription);
        ImageView productIcon = findViewById(R.id.adviceActivityProductIcon);

        String recievedName = recieveData.getString("productname");
        String recievedDesc = recieveData.getString("productdesc");
        String recievedCategory = recieveData.getString("productcategory");

        /*if(recieveData.getString("productcategory") == "f"){
            productIcon.setImageResource(R.drawable.);
        }
        else if (recieveData.getString("productcategory") == "d"){
            productIcon.setImageResource();

        }
        else if (recieveData.getString("productcategory") == "h"){
            productIcon.setImageResource();

        }*/


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