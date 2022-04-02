package me.upp.dali.service;

import net.royalmind.minecraft.plugin.minigamecluster.mysqlapi.MySQL;
import spark.Spark;

public class Service {

    public static void main(final String[] args) {
        final MySQL mySQL = new MySQL();
        Spark.port(6969);
        Spark.get("/test", (request, response) -> "test request!");
    }
}
