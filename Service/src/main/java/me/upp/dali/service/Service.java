package me.upp.dali.service;

import spark.Spark;

public class Service {

    public static void main(final String[] args) {
        Spark.port(6969);
        Spark.get("/test", (request, response) -> "test request!");
    }
}
