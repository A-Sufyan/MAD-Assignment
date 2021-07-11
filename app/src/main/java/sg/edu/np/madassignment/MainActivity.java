package sg.edu.np.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";

    private ImageView GoToCalculator;
    private ImageView GoToShoppingList;
    private ImageView GoToAdvice;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "On Create main Activity!");
        GoToCalculator = findViewById(R.id.GoToCompare);
        GoToShoppingList = findViewById(R.id.GoToShoppingList);
        GoToAdvice = findViewById(R.id.GoToAdvice);

        GoToCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Going to Compare page");
                intent = new Intent(MainActivity.this, CompareActivity.class);
                startActivity(intent);
            }
        });

        GoToShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Going to Shopping List page");
                intent = new Intent(MainActivity.this, ShoppingListActivity.class);
                startActivity(intent);
            }
        });

        GoToAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Going to advice page");
                // TODO implement advice activity
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