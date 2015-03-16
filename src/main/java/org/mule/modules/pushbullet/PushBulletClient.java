package org.mule.modules.pushbullet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mule.modules.pushbullet.error.ErrorMessage;
import org.mule.modules.pushbullet.model.Contact;
import org.mule.modules.pushbullet.model.Pusheable;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by estebanwasinger on 2/6/15.
 */
public class PushBulletClient {

    private String accessToken;
    private Gson mapper;

    public PushBulletClient(String token) {
        accessToken = token;
        mapper = new Gson();
    }

    public void getUser(){
        WebResource webResource = new Client().resource("https://api.pushbullet.com/v2/pushes");
        WebResource.Builder authorizedWebResource = webResource.header("Authorization", "Bearer " + accessToken).header("Content-Type", "application/json");
        ClientResponse response = authorizedWebResource.accept("application/json").get(ClientResponse.class);
        if(response.getStatus() != 200){
            throw new PushBulletException(response.getStatusInfo().toString());
        }
        System.out.println(response.getEntity(String.class));
    }

    public void sendPush(Pusheable bullet) {
        WebResource webResource = new Client().resource("https://api.pushbullet.com/v2/pushes");
        WebResource.Builder authorizedWebResource = webResource.header("Authorization", "Bearer " + accessToken).header("Content-Type", "application/json");
        ClientResponse response = authorizedWebResource.accept("application/json").post(ClientResponse.class, bullet.toString());
        System.out.println(response.getEntity(String.class));
    }

    public List<Contact> getContactList(){
        WebResource webResource = new Client().resource("https://api.pushbullet.com/v2/contacts");
        WebResource.Builder authorizedWebResource = webResource.header("Authorization", "Bearer " + accessToken).header("Content-Type", "application/json");
        String response = authorizedWebResource.accept("application/json").get(String.class);
        JSONArray pushBulletResponse = (JSONArray) new JSONObject(response).get("contacts");
        Type listType = new TypeToken<ArrayList<Contact>>() {
        }.getType();
        return mapper.fromJson(pushBulletResponse.toString(), listType);
    }

    public Contact createContact(String name, String email){
        WebResource webResource = new Client().resource("https://api.pushbullet.com/v2/contacts");
        WebResource.Builder authorizedWebResource = webResource.header("Authorization", "Bearer " + accessToken).header("Content-Type", "application/x-www-form-urlencoded");
        ClientResponse response = authorizedWebResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept("application/json").post(ClientResponse.class, "name=" + name + "&email=" + email);
        String messageResponse = response.getEntity(String.class);
        handleError(response,messageResponse);
        return mapper.fromJson(messageResponse,Contact.class);
    }

    public void deleteContact(String iden){
        WebResource webResource = new Client().resource("https://api.pushbullet.com/v2/contacts/"+iden);
        WebResource.Builder authorizedWebResource = webResource.header("Authorization", "Bearer " + accessToken);
        ClientResponse response = authorizedWebResource.accept("application/json").delete(ClientResponse.class);
        handleError(response,response.getEntity(String.class));
    }

    public Contact updateContact(String name, String iden){
        WebResource webResource = new Client().resource("https://api.pushbullet.com/v2/contacts/"+iden);
        WebResource.Builder authorizedWebResource = webResource.header("Authorization", "Bearer " + accessToken).header("Content-Type", "application/x-www-form-urlencoded");
        ClientResponse response = authorizedWebResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept("application/json").post(ClientResponse.class, "name=" + name);
        String messageResponse = response.getEntity(String.class);
        handleError(response,messageResponse);
        return mapper.fromJson(messageResponse,Contact.class);
    }

    
    public void uploadFile(){//TODO
        WebResource webResource = new Client().resource("https://api.pushbullet.com/v2/upload-request");
        WebResource.Builder authorizedWebResource = webResource
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type","application/x-www-form-urlencoded");
        ClientResponse response = authorizedWebResource.accept("application/json").post(ClientResponse.class,"file_type=image%2Fpng&file_name=myImage.png");
        
        String output = response.getEntity(String.class);
        System.out.println(output);
        String fileUrl =  new JSONObject(output).get("file_url").toString();

        MultivaluedMap formData = new MultivaluedMapImpl();
        formData.add("file_url", fileUrl);
        formData.add("content-type", "image%2Fpng");
        formData.add("acl","public-read");
//        formData.add();
    }

    private void handleError(ClientResponse response, String message){
        if(response.getStatus() != 200){
            JSONObject errorObject = (JSONObject) new JSONObject(message).get("error");
            String errorMessage = mapper.fromJson(errorObject.toString(), ErrorMessage.class).getMessage();
            throw new PushBulletException(response.getStatus()+" - "+response.getStatusInfo()+" - "+errorMessage);
        }
    }
}