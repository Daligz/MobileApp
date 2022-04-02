package me.upp.dali.service.database.tables;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TablePosts {
    TABLE_NAME("Posts"),
    ID("postsId"),
    URL("url"),
    RATE("rate"),
    CATEGORY("category");
    private String value;
}
