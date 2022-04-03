package me.upp.daligz.App.app.request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

public class ImageRequest {
    public JsonArrayRequest get(final String urlRequest, final Response.Listener<JSONArray> jsonArrayListener, final Response.ErrorListener errorListener) {
        return new JsonArrayRequest(Request.Method.GET, urlRequest, null, jsonArrayListener, errorListener);
    }
}
