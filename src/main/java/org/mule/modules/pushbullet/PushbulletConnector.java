/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.pushbullet;

import org.mule.api.annotations.ConnectionStrategy;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Configurable;

import org.mule.api.annotations.Processor;

import org.mule.api.annotations.param.Default;

import org.mule.modules.pushbullet.model.*;
import org.mule.modules.pushbullet.strategy.ConnectorConnectionStrategy;
import org.mule.modules.pushbullet.strategy.PushBulletStrategy;

import java.util.List;

/**
 * Anypoint Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="pushbullet", friendlyName="PushBullet")
public class PushbulletConnector
{
    /**
     * Configurable
     */
    @Configurable
    @Default("value")
    private String myProperty;

    @ConnectionStrategy
    PushBulletStrategy connectionStrategy;

    @Processor
    public void sendNote(Note note){
        client().sendPush(note);
    }
    @Processor
    public void sendLink(Link link){
        client().sendPush(link);
    }
    @Processor
    public void sendAddress(Address address){
        client().sendPush(address);
    }
    @Processor
    public void sendChecklist(Checklist checklist){
        client().sendPush(checklist);
    }
    @Processor
    public Contact createContact(String contactName, String email){
        return client().createContact(contactName,email);
    }
    @Processor
    public void deleteContact(String iden){
        client().deleteContact(iden);
    }
    @Processor
    public Contact updateContact(String newName, String iden){
       return client().updateContact(newName,iden);
    }
    @Processor
    public List<Contact> getContactList(){
        return client().getContactList();
    }


    /**
     * Set property
     *
     * @param myProperty My property
     */
    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

    /**
     * Get property
     */
    public String getMyProperty() {
        return this.myProperty;
    }

    public PushBulletStrategy getConnectionStrategy() {
        return connectionStrategy;
    }

    public void setConnectionStrategy(PushBulletStrategy connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
    }

    public PushBulletClient client(){
        return connectionStrategy.getPushBulletClient();
    }

}