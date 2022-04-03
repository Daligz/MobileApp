package me.upp.daligz.App.app.request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ImageRequest {

    public JsonArrayRequest get(final String urlRequest, final Response.Listener<JSONArray> jsonArrayListener, final Response.ErrorListener errorListener) {
        return new JsonArrayRequest(Request.Method.GET, urlRequest, null, jsonArrayListener, errorListener);
    }

    public String geta(final String urlRequest) {
        try (final InputStream inputStream = new URL(urlRequest).openStream()) {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            return readAll(bufferedReader);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String readAll(final Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
