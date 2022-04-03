package me.upp.dali.service;

import me.upp.dali.service.database.Connector;
import me.upp.dali.service.request.GetImages;
import spark.Spark;

public class Service {

    public static void main(final String[] args) {
        final Connector connector = new Connector();
        Spark.port(6969);
        Spark.get("/images/:amount/:category", (request, response) -> {
            final GetImages getImages = new GetImages(Integer.parseInt(request.params(":amount")), request.params(":category"), connector);
            return getImages.get();
        });
    }
}
