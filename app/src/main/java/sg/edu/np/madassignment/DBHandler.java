package sg.edu.np.madassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.PluralRules;

import java.util.ArrayList;
import java.util.Random;

public class DBHandler extends SQLiteOpenHelper {

    // Products table - column names
    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "products.db";
    public static String TABLE_PRODUCTS = "Products";
    public static String COLUMN_NAME = "Name";
    public static String COLUMN_ID = "Id";
    public static String COLUMN_CATEGORY = "Category";
    public static String COLUMN_DESC = "Description";
    public static String COLUMN_AMTG = "Amt";
    public static String COLUMN_PRICE = "Price";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        // Table Create Statement
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS +
                "(" + COLUMN_NAME + " TEXT,"
                + COLUMN_ID + " INTEGER,"
                + COLUMN_CATEGORY + " TEXT,"
                + COLUMN_DESC + " TEXT,"
                + COLUMN_AMTG + " INTEGER,"
                + COLUMN_PRICE + " INTEGER,"
                + "PRIMARY KEY (" + COLUMN_ID + ", " + COLUMN_CATEGORY + ")"
                + ")";

        // Creating table
        db.execSQL(CREATE_PRODUCTS_TABLE);
        // Pre-populate table with data
        ContentValues values = new ContentValues();
        values.put("name", "Milk");
        values.put("id", 1);
        values.put("category", "d");
        values.put("description", "Milk is a nutrient-rich liquid food produced by the mammary glands of mammals. It is the primary source of nutrition for young mammals, including breastfed human infants before they are able to digest solid food.");
        values.put("amtg", 200);
        values.put("price", 2);
        db.insert(TABLE_PRODUCTS, null, values);

        ContentValues values1 = new ContentValues();
        values1.put("name", "Pocket Tissues");
        values1.put("id", 2);
        values1.put("category", "h");
        values1.put("description", "Pocket tissue packs are a travel-friendly solution that fit into backpacks, lockers or classroom desks while keeping noses (and hands) clean");
        values1.put("amtg", 200);
        values1.put("price", 2);
        db.insert(TABLE_PRODUCTS, null, values1);

        ContentValues values2 = new ContentValues();
        values2.put("name", "Milo Cereal");
        values2.put("id", 3);
        values2.put("category", "f");
        values2.put("description", "MILO cereal with whole grain, vitamin, minerals and Milo Choco Malt");
        values2.put("amtg", 200);
        values2.put("price", 2);
        db.insert(TABLE_PRODUCTS, null, values2);

        ContentValues values3 = new ContentValues();
        values3.put("name", "Eggs");
        values3.put("id", 4);
        values3.put("category", "f");
        values3.put("description", "Eggs are rich sources of selenium, vitamin D, B6, B12 and minerals such as zinc, iron and copper");
        values3.put("amtg", 350);
        values3.put("price", 2);
        db.insert(TABLE_PRODUCTS, null, values3);

        ContentValues values4 = new ContentValues();
        values4.put("name", "Broccoli");
        values4.put("id", 5);
        values4.put("category", "f");
        values4.put("description", "Broccoli is a cruciferous veggie that may help you lose weight, prevent cancer, improve digestion, and boost immunity.");
        values4.put("amtg", 200);
        values4.put("price", 3);
        db.insert(TABLE_PRODUCTS, null, values4);

        ContentValues values5 = new ContentValues();
        values5.put("name", "White Rice Bag");
        values5.put("id", 6);
        values5.put("category", "f");
        values5.put("description", "Rice is the seed of the grass species Oryza sativa or less commonly Oryza glaberrima. The name wild rice is usually used for species of the genera Zizania and Porteresia, both wild and domesticated, although the term may also be used for primitive or uncultivated varieties of Oryza. ");
        values5.put("amtg", 1000);
        values5.put("price", 5);
        db.insert(TABLE_PRODUCTS, null, values5);

        ContentValues values6 = new ContentValues();
        values6.put("name", "Laundry Detergent");
        values6.put("id", 7);
        values6.put("category", "h");
        values6.put("description", "A detergent is a surfactant or a mixture of surfactants with cleansing properties in dilute solutions.");
        values6.put("amtg", 600);
        values6.put("price", 7);
        db.insert(TABLE_PRODUCTS, null, values6);

        ContentValues values7 = new ContentValues();
        values7.put("name", "Kinder Bueno");
        values7.put("id", 8);
        values7.put("category", "f");
        values7.put("description", "Kinder Bueno is a chocolate bar made by Italian confectionery maker Ferrero. Kinder Bueno, part of the Kinder Chocolate brand line, is a hazelnut cream filled chocolate bar, that contains small amounts of wafer.");
        values7.put("amtg", 50);
        values7.put("price", 1.50);
        db.insert(TABLE_PRODUCTS, null, values7);

        ContentValues values8 = new ContentValues();
        values8.put("name", "Ruffles Potato Chips");
        values8.put("id", 9);
        values8.put("category", "f");
        values8.put("description", "Ruffles is an American brand of ruffled potato chips. The Frito Company acquired the rights to Ruffles brand potato chips in 1958 from its creator, Bernhardt Stahmer, who had adopted the trademark in or around 1948. and later merged with H.W. Lay & Co. in 1961.");
        values8.put("amtg", 100);
        values8.put("price", 4);
        db.insert(TABLE_PRODUCTS, null, values8);

        ContentValues values9 = new ContentValues();
        values9.put("name", "Ben & Jerry's Vanilla Ice Cream (Big)");
        values9.put("id", 10);
        values9.put("category", "f");
        values9.put("description", "Ben & Jerry's, is a Vermont-based company that manufactures ice cream, frozen yogurt, and sorbet. Founded in 1978 in Burlington, Vermont, it was sold in 2000 to British conglomerate Unilever.");
        values9.put("amtg", 400);
        values9.put("price", 14);
        db.insert(TABLE_PRODUCTS, null, values9);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // on upgrade drop older table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);

        //create new table
        onCreate(db);
    }

    /*public ShoppingList findItem(ShoppingList itemName){
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_NAME + " = \"" + itemName +"\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ShoppingList item = new ShoppingList(itemName.itemName, itemName.itemCategory, itemName.itemAmount, itemName.getItemPrice());
        if (cursor.moveToFirst()) {
            item.setItemCategory(cursor.getString(1));
            item.setItemAmount(cursor.getDouble(2));
            item.setItemPrice(cursor.getDouble(3));
        }
        else {
            item = null;
        }
        db.close();
        return item;
    }*/
}
