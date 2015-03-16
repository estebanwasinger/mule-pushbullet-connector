package org.mule.modules.pushbullet.model;

/**
 * Created by estebanwasinger on 2/6/15.
 */
public class Note implements Pusheable {
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

    String title;
    String body;


    public String toString() {
        return "{\"type\": \"note\", \"title\": \"" + title + "\", \"body\": \"" + body + "\"}";
    }
}
