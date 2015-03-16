package org.mule.modules.pushbullet.model;

/**
 * Created by estebanwasinger on 2/7/15.
 */
public class Address implements Pusheable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String name;
    String address;


    public String toString() {
        return "{\"type\": \"address\", \"name\": \"" + name + "\", \"address\": \"" + address + "\"}";
    }
}
