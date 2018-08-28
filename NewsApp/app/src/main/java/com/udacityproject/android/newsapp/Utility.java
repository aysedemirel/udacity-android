package com.udacityproject.android.newsapp;

import android.graphics.drawable.Drawable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    private static final int RESPONSE_CODE_OK = 200;
    private static final int CONNECTION_TIMEOUT = 15000;
    private static final int READ_TIMEOUT = 10000;
    private static String uRl;

    public static String getURL() {
        return uRl;
    }

    public static void setURL(String uRL) {
        Utility.uRl = uRL;
    }

    private Utility() {
    }

    public static List<ItemInfo> getItems(String requestUrl) throws JSONException {

        URL url = createUrl(requestUrl);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException ignored) {
        }

        return parseJSON(jsonResponse);
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException ignored) {
        }
        return url;
    }

    // Makes HTTP Request
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(READ_TIMEOUT /* milliseconds */);
            urlConnection.setConnectTimeout(CONNECTION_TIMEOUT /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == RESPONSE_CODE_OK) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }
        } catch (IOException ignored) {
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static List<ItemInfo> parseJSON(String response) throws JSONException {
        String section, pubDate, title, url, author;
        List<ItemInfo> newsItems = new ArrayList<>();
        JSONObject root = new JSONObject(response);
        JSONObject res = root.getJSONObject("response");
        JSONArray resultsArray = res.getJSONArray("results");
        for (int i = 0; i < resultsArray.length(); i++) {
            JSONObject result = resultsArray.getJSONObject(i);
            section = result.getString("sectionName");
            pubDate = result.getString("webPublicationDate");
            title = result.getString("webTitle");
            url = result.getString("webUrl");
            try {
                JSONArray tagsArray = result.getJSONArray("tags");
                JSONObject firstTag = tagsArray.getJSONObject(0);
                author = firstTag.getString("webTitle");
            } catch (Exception e) {
                author = "None";
            }

            pubDate = pubDate.replaceAll("[a-zA-Z]", " ");

            newsItems.add(new ItemInfo(title, pubDate, section, url, author));
        }
        return newsItems;
    }
}
