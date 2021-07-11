package sg.edu.np.madassignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.PluralRules;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // Products table - column names
    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "products.db";
    public static String TABLE_PRODUCTS = "Products";
    public static String COLUMN_NAME = "Name";
    public static String COLUMN_ID = "Id";
    public static String COLUMN_CATEGORY = "Category";
    public static String COLUMN_DESC = "Description";
    public static String COLUMN_AMT = "Amt";
    public static String COLUMN_PRICE = "Price";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        // Table Create Statement
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS +
                "(" + COLUMN_NAME + " TEXT,"
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_CATEGORY + " TEXT,"
                + COLUMN_DESC + " TEXT,"
                + COLUMN_AMT + " INTEGER,"
                + COLUMN_PRICE + " INTEGER" + ")";

        // Creating table
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // on upgrade drop older table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);

        //create new table
        onCreate(db);
    }

}
