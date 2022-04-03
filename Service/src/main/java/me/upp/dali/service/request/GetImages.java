package me.upp.dali.service.request;

import lombok.Data;
import me.upp.dali.service.database.Connector;
import me.upp.dali.service.utils.JsonUtils;

import java.sql.ResultSet;

@Data
public class GetImages implements Request {

    private final int amount;
    private final String category;
    private final Connector connector;

    @Override
    public String get() {
        final ResultSet posts = this.connector.getPosts(this.category);
        if (posts == null) return "";
        try {
            return JsonUtils.toJSON(posts).toString();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
