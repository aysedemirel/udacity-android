package com.udacityproject.android.book_inventoryapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookInventorDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "books.db";

    public BookInventorDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_BOOKS_TABLE = "CREATE TABLE " + BookInventoryContent.BooksDatabase.TABLE_NAME + " ("
                + BookInventoryContent.BooksDatabase._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BookInventoryContent.BooksDatabase.PRODUCT_NAME + " TEXT NOT NULL, "
                + BookInventoryContent.BooksDatabase.PRODUCT_PRICE + " INTEGER NOT NULL, "
                + BookInventoryContent.BooksDatabase.PRODUCT_QUANTITY + " INTEGER NOT NULL, "
                + BookInventoryContent.BooksDatabase.SUPPLIER_NAME + " TEXT NOT NULL, "
                + BookInventoryContent.BooksDatabase.SUPPLIER_PHONE_NUMBER + " TEXT NOT NULL );";
        sqLiteDatabase.execSQL(SQL_CREATE_BOOKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}