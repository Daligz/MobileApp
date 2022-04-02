package me.upp.dali.service.database;

import me.upp.dali.service.database.tables.TablePosts;
import net.royalmind.minecraft.plugin.minigamecluster.mysqlapi.MySQL;
import net.royalmind.minecraft.plugin.minigamecluster.mysqlapi.queries.CreateTableQuery;
import net.royalmind.minecraft.plugin.minigamecluster.mysqlapi.queries.Query;

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
        final String postsTableQuery = new CreateTableQuery(TablePosts.TABLE_NAME.getValue())
                .ifNotExists()
                .column(TablePosts.ID.getValue(), "INT AUTO_INCREMENT")
                .column(TablePosts.URL.getValue(), "VARCHAR(100) NOT NULL")
                .column(TablePosts.RATE.getValue(), "INT NOT NULL")
                .column(TablePosts.CATEGORY.getValue(), "VARCHAR(100) NOT NULL")
                .primaryKey(TablePosts.ID.getValue())
                .build();
        System.out.println(postsTableQuery);
        new Query(this.mySQL, postsTableQuery).executeUpdateAsync();
    }

    public void close() {
        this.mySQL.disconnect();
    }
}
