package me.upp.daligz.App.app;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import me.upp.daligz.App.app.request.ImageRequest;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void loadImage() {
        final String result = new ImageRequest().get("http://localhost:6969/images/20/tecnology");
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(result);
        } catch (final JSONException exception) {
            exception.printStackTrace();
        }
        if (jsonArray == null) return;
        for (int i = 0; i < jsonArray.length(); i++) {
            final JSONObject jsonObject;
            try {
                jsonObject = jsonArray.getJSONObject(i);
                System.out.println(jsonObject);
            } catch (JSONException exception) {
                exception.printStackTrace();
            }
        }
    }
}