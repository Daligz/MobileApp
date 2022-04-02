package me.upp.dali.service;

import me.upp.dali.service.database.Connector;
import spark.Spark;

public class Service {

    public static void main(final String[] args) {
        final Connector connector = new Connector();
        Spark.port(6969);
        Spark.get("/test", (request, response) -> "test request!");
        connector.close();
    }
}
