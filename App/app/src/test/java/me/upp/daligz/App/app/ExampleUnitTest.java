package me.upp.daligz.App.app;

import static org.junit.Assert.assertEquals;

import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import me.upp.daligz.App.app.commons.StaticData;
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
        final String url = String.format("http://%s:6969/images/%s/%s", StaticData.IP, 20, "animals");
        final JsonArrayRequest result = new ImageRequest().get(
                url,
                response -> {
                    if (response == null) return;
                    for (int i = 0; i < response.length(); i++) {
                        final JSONObject jsonObject;
                        try {
                            jsonObject = response.getJSONObject(i);
                            System.out.println(jsonObject);
                        } catch (JSONException exception) {
                            exception.printStackTrace();
                        }
                    }
                },
                error -> error.getCause().printStackTrace()
        );
    }
}