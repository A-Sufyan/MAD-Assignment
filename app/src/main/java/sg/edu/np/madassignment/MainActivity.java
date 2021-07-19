package sg.edu.np.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    /* TODO:
        - Implement bottom navigation bar
    *   - Allow CompareActivity to be able to add directly into shopping list
        - Fix shopppingListActivity (align stuff properly)
        - Add headers for shoppingList
        - Align title to center in adviceActivity, enclose list in box, align
          items to the left, increase font size of "choose product..."
        - Implement Firebase to store items instead of local DB
        - Clean up the UI
        - Icon on top of description, enclose entire thing in rectangle (main layout),
          change home --> App Name (WorthOrNot)
        - Maybe do splash page
        - CompareActivity --> Compare items LR instead of UD
          flip input to bottom, compare table to the top
     */
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
        GoToShoppingList = (ImageView) findViewById(R.id.GoToShoppingList);
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
                intent = new Intent(MainActivity.this, adviceActivityHomepage.class);
                startActivity(intent);
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