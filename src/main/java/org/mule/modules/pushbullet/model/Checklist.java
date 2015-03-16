package org.mule.modules.pushbullet.model;

import org.mule.modules.pushbullet.PushBulletUtils;

import java.util.List;

/**
 * Created by estebanwasinger on 2/6/15.
 */
public class Checklist implements Pusheable {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    String title;
    List<String> items;


    public String toString() {
        return "{\"type\": \"list\", \"title\": \"" + title + "\", \"items\": " + PushBulletUtils.listToJSONList(items) + "}";
    }
}
