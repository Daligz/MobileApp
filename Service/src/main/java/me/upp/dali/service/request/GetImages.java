package me.upp.dali.service.request;

import lombok.Data;
import me.upp.dali.service.database.Connector;

@Data
public class GetImages implements Request {

    private final int amount;
    private final String category;
    private final Connector connector;

    @Override
    public String get() {
        return "";
    }
}
