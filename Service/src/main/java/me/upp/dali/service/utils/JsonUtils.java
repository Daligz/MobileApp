package me.upp.dali.service.utils;

import lombok.experimental.UtilityClass;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;

@UtilityClass
public class JsonUtils {
    public static JSONArray toJSON(final ResultSet resultSet) throws Exception {
        final JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            final int total_columns = resultSet.getMetaData().getColumnCount();
            final JSONObject obj = new JSONObject();
            for (int i = 0; i < total_columns; i++) obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
            jsonArray.put(obj);
        }
        return jsonArray;
    }
}
