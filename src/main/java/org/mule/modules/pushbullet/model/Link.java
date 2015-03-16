package org.mule.modules.pushbullet.model;

/**
 * Created by estebanwasinger on 2/6/15.
 */
public class Link implements Pusheable {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String title;
    String body;
    String url;


    public String toString() {
        return "{\"type\": \"link\", \"title\": \"" + title + "\", \"body\": \"" + body + "\",\"url\": \"" + url + "\"}";
    }
}
