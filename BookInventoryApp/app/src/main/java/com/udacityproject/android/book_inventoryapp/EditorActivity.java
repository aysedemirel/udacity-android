package com.udacityproject.android.book_inventoryapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.udacityproject.android.book_inventoryapp.data.BookInventorDbHelper;
import com.udacityproject.android.book_inventoryapp.data.BookInventoryContent;

public class EditorActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private final int MINIMUM_QUANTITY_VALUE = 0;

    private final int MAXIMUM_QUANTITY_VALUE = 999;

    private boolean bookHasChanged = false;

    private String supplierContact;

    private static final int EXISTING_BOOK_LOADER = 1;

    private Uri currentBookUri;

    private EditText productNameEditText;

    private EditText productPriceEditText;

    private EditText productQuantityEditText;

    private EditText supplierNameEditText;

    private EditText supplierContactEditText;

    public BookInventorDbHelper dbHelper;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editor_view);

        Intent intent = getIntent();
        currentBookUri = intent.getData();

        if (currentBookUri == null) {
            setTitle(getString(R.string.add_a_book));
            invalidateOptionsMenu();
        } else {
            setTitle(getString(R.string.edit_book));
            getLoaderManager().initLoader(EXISTING_BOOK_LOADER, null, this);
        }

        productNameEditText = findViewById(R.id.product_name);
        productPriceEditText = findViewById(R.id.product_price);
        productQuantityEditText = findViewById(R.id.product_quantity);
        supplierNameEditText = findViewById(R.id.supplier_name);
        supplierContactEditText = findViewById(R.id.suplier_phone_number);
        Button subtractQuantityButton = findViewById(R.id.quantity_dec);
        Button addQuantityButton = findViewById(R.id.quantity_inc);
        subtractQuantityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentQuantityString = productQuantityEditText.getText().toString();
                int currentQuantityInt;
                if (currentQuantityString.length() == 0) {
                    currentQuantityInt = 0;
                    productQuantityEditText.setText(String.valueOf(currentQuantityInt));
                } else {
                    currentQuantityInt = Integer.parseInt(currentQuantityString) - 1;
                    if (currentQuantityInt >= MINIMUM_QUANTITY_VALUE) {
                        productQuantityEditText.setText(String.valueOf(currentQuantityInt));
                    }
                }

            }
        });
        addQuantityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentQuantityString = productQuantityEditText.getText().toString();
                int currentQuantityInt;
                if (currentQuantityString.length() == 0) {
                    currentQuantityInt = 1;
                    productQuantityEditText.setText(String.valueOf(currentQuantityInt));
                } else {
                    currentQuantityInt = Integer.parseInt(currentQuantityString) + 1;
                    if (currentQuantityInt <= MAXIMUM_QUANTITY_VALUE) {
                        productQuantityEditText.setText(String.valueOf(currentQuantityInt));
                    }
                }

            }
        });

        dbHelper = new BookInventorDbHelper(this);

        productNameEditText.setOnTouchListener(mTouchListener);
        productPriceEditText.setOnTouchListener(mTouchListener);
        productQuantityEditText.setOnTouchListener(mTouchListener);
        subtractQuantityButton.setOnTouchListener(mTouchListener);
        addQuantityButton.setOnTouchListener(mTouchListener);
        supplierNameEditText.setOnTouchListener(mTouchListener);
        supplierContactEditText.setOnTouchListener(mTouchListener);

    }

    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            bookHasChanged = true;
            return false;
        }

    };

    @Override
    public void onBackPressed() {
        if (!bookHasChanged) {
            super.onBackPressed();
            return;
        }

        DialogInterface.OnClickListener discardButtonClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                };

        showUnsavedChangesDialog(discardButtonClickListener);
    }

    private void saveBook() {
        String productNameString = productNameEditText.getText().toString().trim();
        String productPriceString = productPriceEditText.getText().toString().trim();
        String productQuantityString = productQuantityEditText.getText().toString().trim();
        String supplierNameString = supplierNameEditText.getText().toString().trim();
        String supplierContactString = supplierContactEditText.getText().toString().trim();


        if (TextUtils.isEmpty(productNameString)) {
            productNameEditText.setError(getString(R.string.required));
            return;
        }

        if (TextUtils.isEmpty(productPriceString)) {
            productPriceEditText.setError(getString(R.string.required));
            return;
        }
        if (TextUtils.isEmpty(productQuantityString)) {
            productQuantityEditText.setError(getString(R.string.required));
            return;
        }

        if (TextUtils.isEmpty(supplierNameString)) {
            supplierNameEditText.setError(getString(R.string.required));
            return;
        }
        if (TextUtils.isEmpty(supplierContactString)) {
            supplierContactEditText.setError(getString(R.string.required));
            return;
        }

        int productPriceInt = Integer.parseInt(productPriceString);
        int productQuantityInt = Integer.parseInt(productQuantityString);

        if (productPriceInt < 0) {
            productPriceEditText.setError(getString(R.string.price_cannot_be_negative));
            return;
        }
        if (productQuantityInt < 0) {
            productQuantityEditText.setError(getString(R.string.quantity_cannot_be_negative));
            return;
        }
        ContentValues values = new ContentValues();
        values.put(BookInventoryContent.BooksDatabase.PRODUCT_NAME, productNameString);
        values.put(BookInventoryContent.BooksDatabase.PRODUCT_PRICE, productPriceInt);
        values.put(BookInventoryContent.BooksDatabase.PRODUCT_QUANTITY, productQuantityInt);
        values.put(BookInventoryContent.BooksDatabase.SUPPLIER_NAME, supplierNameString);
        values.put(BookInventoryContent.BooksDatabase.SUPPLIER_PHONE_NUMBER, supplierContactString);

        if (currentBookUri == null) {
            Uri newUri = getContentResolver().insert(BookInventoryContent.BooksDatabase.CONTENT_URI, values);

            if (newUri == null) {
                Toast.makeText(this, getString(R.string.editor_insert_book_failed), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_insert_book_successful), Toast.LENGTH_SHORT).show();
            }
        } else {
            int rowAffected = getContentResolver().update(currentBookUri, values, null, null);

            if (rowAffected == 0) {
                Toast.makeText(this, getString(R.string.editor_update_book_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_update_book_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
        finish();
    }

    private void deleteBook() {
        if (currentBookUri != null) {
            int rowsDeleted = getContentResolver().delete(
                    currentBookUri,   // the user dictionary content URI
                    null,                    // the column to select on
                    null                      // the value to compare to
            );

            if (rowsDeleted == 0) {
                Toast.makeText(this, getString(R.string.error_deleting_book),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.book_deleted),
                        Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    }

    private void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener) {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.discard_changes_and_quit_editing));
        builder.setPositiveButton(getString(R.string.discard), discardButtonClickListener);
        builder.setNegativeButton(getString(R.string.keep_editing), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Keep editing" button, so dismiss the dialog
                // and continue editing the book.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showDeleteConfirmationDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.delete_this_book));
        builder.setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the book.
                deleteBook();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Cancel" button, so dismiss the dialog
                // and continue editing the book.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void callSupplier() {
        Intent supplierNumberIntent = new Intent(Intent.ACTION_DIAL);
        supplierNumberIntent.setData(Uri.parse("tel:" + supplierContact));
        startActivity(supplierNumberIntent);
    }

    /**
     * This method is called after invalidateOptionsMenu(), so that the
     * menu can be updated (some menu items can be hidden or made visible).
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        // If this is a new book, hide the "Delete" menu item.
        if (currentBookUri == null) {
            MenuItem menuItem;
            menuItem = menu.findItem(R.id.action_delete);
            menuItem.setVisible(false);
            menuItem = menu.findItem(R.id.action_contact_supplier);
            menuItem.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save book to database
                saveBook();
                return true;
            // Respond to a click on the "Contact Supplier" menu option
            case R.id.action_contact_supplier:
                // Contact the supplier via intent
                callSupplier();
                break;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                //Allow user to confirm for deleting the entry
                showDeleteConfirmationDialog();
                break;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // If the book hasn't changed, continue with navigating up to parent activity
                // which is the {@link CatalogActivity}.
                if (!bookHasChanged) {
                    NavUtils.navigateUpFromSameTask(EditorActivity.this);
                    return true;
                }

                // Otherwise if there are unsaved changes, setup a dialog to warn the user.
                // Create a click listener to handle the user confirming that
                // changes should be discarded.
                DialogInterface.OnClickListener discardButtonClickListener =
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // User clicked "Discard" button, navigate to parent activity.
                                NavUtils.navigateUpFromSameTask(EditorActivity.this);
                            }
                        };

                // Show a dialog that notifies the user they have unsaved changes
                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Since the editor shows all books attributes, define a projection that contains
        // all columns from the books table
        String[] projection = {
                BookInventoryContent.BooksDatabase._ID,
                BookInventoryContent.BooksDatabase.PRODUCT_NAME,
                BookInventoryContent.BooksDatabase.PRODUCT_PRICE,
                BookInventoryContent.BooksDatabase.PRODUCT_QUANTITY,
                BookInventoryContent.BooksDatabase.SUPPLIER_NAME,
                BookInventoryContent.BooksDatabase.SUPPLIER_PHONE_NUMBER,
        };

        return new CursorLoader(this,
                currentBookUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {

            int productNameColumnIndex = cursor.getColumnIndex(BookInventoryContent.BooksDatabase.PRODUCT_NAME);
            int productPriceColumnIndex = cursor.getColumnIndex(BookInventoryContent.BooksDatabase.PRODUCT_PRICE);
            int productQuantityColumnIndex = cursor.getColumnIndex(BookInventoryContent.BooksDatabase.PRODUCT_QUANTITY);
            int supplierNameColumnIndex = cursor.getColumnIndex(BookInventoryContent.BooksDatabase.SUPPLIER_NAME);
            int supplierContactColumnIndex = cursor.getColumnIndex(BookInventoryContent.BooksDatabase.SUPPLIER_PHONE_NUMBER);

            String productName = cursor.getString(productNameColumnIndex);
            int productPrice = cursor.getInt(productPriceColumnIndex);
            int productQuantity = cursor.getInt(productQuantityColumnIndex);
            String supplierName = cursor.getString(supplierNameColumnIndex);
            supplierContact = cursor.getString(supplierContactColumnIndex);

            productNameEditText.setText(productName);
            productPriceEditText.setText(String.valueOf(productPrice));
            productQuantityEditText.setText(String.valueOf(productQuantity));
            supplierNameEditText.setText(String.valueOf(supplierName));
            supplierContactEditText.setText(String.valueOf(supplierContact));


        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        productNameEditText.setText("");
        productPriceEditText.setText("");
        productQuantityEditText.setText("");
        supplierNameEditText.setText("");
        supplierContactEditText.setText("");
    }
}