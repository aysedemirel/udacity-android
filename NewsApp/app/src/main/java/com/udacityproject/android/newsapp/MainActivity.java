package com.udacityproject.android.newsapp;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<ItemInfo>>, AdapterView.OnItemClickListener {

    private ListView listView;
    private ItemAdapter adapter;
    private ArrayList<ItemInfo> newsItems;

    @Override
    protected void onResume() {
        getPreferences();
        super.onResume();
    }

    private void getPreferences() {
        String url;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String url_guardians = "https://content.guardianapis.com/search?&show-tags=contributor&api-key=dcd9ad5e-c852-4c47-bc8f-eab7f3411f07";

        if (preferences.getString(getString(R.string.key), getString(R.string.default_order_value)).equals(getString(R.string.default_order_value))) {
            url = url_guardians;
        } else {
            String order = "&order-by=oldest";
            url = url_guardians + order;
        }

        switch (preferences.getString("category_list", "")) {
            case "All":
                Utility.setURL(url);
                break;
            case "Politics":
                Utility.setURL(url + "&q=politics");
                break;
            case "Finance":
                Utility.setURL(url + "&q=finance");
                break;
            case "Education":
                Utility.setURL(url + "&q=education");
                break;
            case "Sports":
                Utility.setURL(url + "&q=sports");
                break;
            case "Economics":
                Utility.setURL(url + "&q=economics");
                break;
            default:
                Utility.setURL(url);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPreferences();

        listView = findViewById(R.id.list_item_activity);
        newsItems = new ArrayList<>();

        if (!isConnected()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.network_error_message)
                    .setTitle(R.string.network_error_title);
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(1, null, this);
            listView.setOnItemClickListener(this);
        }
    }

    @Override
    public Loader<List<ItemInfo>> onCreateLoader(int id, Bundle args) {
        Uri uri = Uri.parse(Utility.getURL());
        Uri.Builder uriBuilder = uri.buildUpon();
        return new ItemLoad(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<ItemInfo>> loader, List<ItemInfo> data) {
        newsItems = new ArrayList<>(data);
        View process_bar = findViewById(R.id.progress_bar);
        if (newsItems.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.json_error)
                    .setTitle(R.string.json_error_title);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        UpdateView(newsItems);
        process_bar.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(Loader<List<ItemInfo>> loader) {
        adapter.clear();
    }

    private void UpdateView(ArrayList<ItemInfo> newsItems) {
        adapter = new ItemAdapter(getApplicationContext(), newsItems);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in = new Intent(getApplicationContext(), ItemDetail.class);
        in.putExtra("URL", newsItems.get(position).getUrl());
        startActivity(in);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings) {
            Intent in = new Intent(this, Settings.class);
            startActivity(in);
            return true;
        } else if (id == R.id.choose_topic) {
            Intent in = new Intent(this, CategoryChooser.class);
            startActivity(in);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}