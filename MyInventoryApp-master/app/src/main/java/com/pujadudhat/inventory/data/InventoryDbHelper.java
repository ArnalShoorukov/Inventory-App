package com.pujadudhat.inventory.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class InventoryDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "warehouse.db";

    private static final String SQL_CREATE_PRODUCT_TABLE =
            "CREATE TABLE " + InventoryContract.ProductEntry.TABLE_NAME + " (" +
                    InventoryContract.ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    InventoryContract.ProductEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, " +
                    InventoryContract.ProductEntry.COLUMN_PRODUCT_PRICE + " FLOAT NOT NULL DEFAULT 0, " +
                    InventoryContract.ProductEntry.COLUMN_PRODUCT_QUANTITY + " INYEGER NOT NULL, " +
                    InventoryContract.ProductEntry.COLUMN_PRODUCT_SALES + " INTEGER NOT NULL DEFAULT 0, " +
                    InventoryContract.ProductEntry.COLUMN_PRODUCT_PHOTO + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + InventoryContract.ProductEntry.TABLE_NAME;

    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PRODUCT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
