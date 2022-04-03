package me.upp.dali.service.database;

import me.upp.dali.service.database.tables.TablePosts;
import net.royalmind.minecraft.plugin.minigamecluster.mysqlapi.MySQL;
import net.royalmind.minecraft.plugin.minigamecluster.mysqlapi.queries.CreateTableQuery;
import net.royalmind.minecraft.plugin.minigamecluster.mysqlapi.queries.Query;
import net.royalmind.minecraft.plugin.minigamecluster.mysqlapi.queries.SelectQuery;

import java.sql.ResultSet;

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
        new Query(this.mySQL, postsTableQuery).executeUpdateAsync();
    }

    public ResultSet getPosts(final String amount, final String category) {
        final String selectQuery = new SelectQuery(TablePosts.TABLE_NAME.getValue())
                .column("*")
                .where(TablePosts.CATEGORY.getValue() + " = " + category)
                .build();
        try {
            return new Query(this.mySQL, selectQuery).executeQuery();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void close() {
        this.mySQL.disconnect();
    }
}
