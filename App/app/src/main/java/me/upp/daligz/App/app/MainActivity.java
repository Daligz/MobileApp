package me.upp.daligz.App.app;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import me.upp.daligz.App.app.animations.AnimatedBackground;
import me.upp.daligz.App.app.commons.PostData;
import me.upp.daligz.App.app.commons.StaticData;
import me.upp.daligz.App.app.downloader.ImageDownloader;
import me.upp.daligz.App.app.request.ImageRequest;

public class MainActivity extends AppCompatActivity {

    private static final String API_URL = "https://picsum.photos/200/300?random=1";
    private static final List<PostData> POST_DATA_LIST = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.runAnimations();
        this.loadImage(5, "animals");
    }

    private void runAnimations() {
        new AnimatedBackground(this).run();
    }

    private void appendImages() {
        for (final PostData postData : POST_DATA_LIST) ImageDownloader.download(postData.getUrl(), this);
    }

    private void loadImage(final int limit, final String category) {
        final String url = String.format("http://%s:6969/images/%s/%s", StaticData.IP, limit, category);
        final JsonArrayRequest result = new ImageRequest().get(
                url,
                this::execute,
                error -> Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
        );
        Volley.newRequestQueue(this).add(result);
    }

    private void execute(final JSONArray jsonArray) {
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                final JSONObject jsonObject = jsonArray.getJSONObject(i);
                POST_DATA_LIST.add(new PostData(
                        jsonObject.getInt("postsid"),
                        jsonObject.getInt("rate"),
                        jsonObject.getString("url"),
                        jsonObject.getString("category")
                ));
            }
        } catch (final JSONException exception) {
            exception.printStackTrace();
            Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show();
        }
        this.appendImages();
    }
}