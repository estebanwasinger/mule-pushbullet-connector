/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.pushbullet.strategy;

import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.ConnectionException;
import org.mule.modules.pushbullet.PushBulletClient;
import org.mule.modules.pushbullet.PushBulletException;

/**
 * Connection Management Strategy
 *
 * @author MuleSoft, Inc.
 */
@ConnectionManagement(configElementName = "config-type", friendlyName = "Connection Managament type strategy")
public class ConnectorConnectionStrategy implements PushBulletStrategy
{

    PushBulletClient client;

    /**
     * Connect
     *
     * @param accessToken A username
     * @throws ConnectionException
     */
    @Connect
    @TestConnectivity
    public void connect(@ConnectionKey String accessToken)
        throws ConnectionException {
        client = new PushBulletClient(accessToken);
        try{
            client.getUser();
        }catch (PushBulletException e){
            throw new ConnectionException(ConnectionExceptionCode.INCORRECT_CREDENTIALS,e.getMessage(),e.getMessage());
        }

    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
        /*
         * CODE FOR CLOSING A CONNECTION GOES IN HERE
         */
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        return client == null ? false : true;
    }

    /**
     * Are we connected
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }

    public PushBulletClient getPushBulletClient(){
        return client;
    }
}