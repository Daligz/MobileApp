package me.upp.daligz.App.app.commons;

public class PostData {

    private final int id, rate;
    private final String url, category;

    public PostData(final int id, final int rate, final String url, final String category) {
        this.id = id;
        this.rate = rate;
        this.url = url;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }
}
