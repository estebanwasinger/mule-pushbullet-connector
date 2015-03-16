package org.mule.modules.pushbullet.model;

/**
 * Created by estebanwasinger on 2/7/15.
 */
public class BulletFile implements Pusheable{


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    String fileName;
    String fileType;
    String fileUrl;
    String body;


    public String toString() {
        return "{\"type\": \"file\", \"file_name\": \"" + fileName + "\", \"file_type\": \"" + fileType + "\", \"file_type\": \"" + fileUrl + "\"}";
    }
}
