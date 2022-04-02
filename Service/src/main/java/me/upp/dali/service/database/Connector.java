package me.upp.dali.service.database;

import net.royalmind.minecraft.plugin.minigamecluster.mysqlapi.MySQL;

public class Connector {

    private final MySQL mySQL = new MySQL();

    public Connector() {
        this.mySQL.connect(
                "localhost",
                "3306",
                "root",
                "",
                "web-service"
        );
        this.createTables();
    }

    private void createTables() {

    }

    public void close() {
        this.mySQL.disconnect();
    }
}
