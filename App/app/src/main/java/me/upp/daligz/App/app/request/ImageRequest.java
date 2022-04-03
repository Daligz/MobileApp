package me.upp.daligz.App.app.request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageRequest {
    public String get(final String urlRequest) {
        final StringBuilder stringBuilder = new StringBuilder();
        try {
            final URL url = new URL(urlRequest);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String get;
            while ((get = bufferedReader.readLine()) != null) stringBuilder.append(get);
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
        return "";
    }
}
