package com.udacityproject.android.book_inventoryapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.udacityproject.android.book_inventoryapp.data.BookInventoryContent;

public class BookInventoryCursorAdapter extends CursorAdapter {

    BookInventoryCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.book_item_view, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {

        TextView productNameTextView = view.findViewById(R.id.product_name_item);
        TextView productPriceTextView = view.findViewById(R.id.product_price_item);
        TextView productQuantityTextView = view.findViewById(R.id.product_quantity_item);

        int productNameColumnIndex = cursor.getColumnIndex(BookInventoryContent.BooksDatabase.PRODUCT_NAME);
        int productPriceColumnIndex = cursor.getColumnIndex(BookInventoryContent.BooksDatabase.PRODUCT_PRICE);
        int productQuantityColumnIndex = cursor.getColumnIndex(BookInventoryContent.BooksDatabase.PRODUCT_QUANTITY);

        String productName = cursor.getString(productNameColumnIndex);
        int productPrice = cursor.getInt(productPriceColumnIndex);
        int productQuantity = cursor.getInt(productQuantityColumnIndex);

        productNameTextView.setText(productName);
        productPriceTextView.setText(String.valueOf(productPrice));
        productQuantityTextView.setText(String.valueOf(productQuantity));

        int productIdColumIndex = cursor.getColumnIndex(BookInventoryContent.BooksDatabase._ID);

        final long productIdVal = Integer.parseInt(cursor.getString(productIdColumIndex));
        final int currentProductQuantityVal = cursor.getInt(productQuantityColumnIndex);

        Button saleButton = view.findViewById(R.id.sale_button);
        saleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri currentUri = ContentUris.withAppendedId(BookInventoryContent.BooksDatabase.CONTENT_URI, productIdVal);

                String updatedQuantity = String.valueOf(currentProductQuantityVal - 1);

                if (Integer.parseInt(updatedQuantity) >= 0) {
                    ContentValues values = new ContentValues();
                    values.put(BookInventoryContent.BooksDatabase.PRODUCT_QUANTITY, updatedQuantity);
                    context.getContentResolver().update(currentUri, values, null, null);
                }
            }
        });
    }
}
