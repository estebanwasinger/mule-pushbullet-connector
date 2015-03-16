package org.mule.modules.pushbullet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {

    @Expose
    private String iden;
    @Expose
    private String name;
    @Expose
    private Double created;
    @Expose
    private Double modified;
    @Expose
    private String email;
    @SerializedName("email_normalized")
    @Expose
    private String emailNormalized;
    @Expose
    private Boolean active;

    /**
     * @return The iden
     */
    public String getIden() {
        return iden;
    }

    /**
     * @param iden The iden
     */
    public void setIden(String iden) {
        this.iden = iden;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The created
     */
    public Double getCreated() {
        return created;
    }

    /**
     * @param created The created
     */
    public void setCreated(Double created) {
        this.created = created;
    }

    /**
     * @return The modified
     */
    public Double getModified() {
        return modified;
    }

    /**
     * @param modified The modified
     */
    public void setModified(Double modified) {
        this.modified = modified;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The emailNormalized
     */
    public String getEmailNormalized() {
        return emailNormalized;
    }

    /**
     * @param emailNormalized The email_normalized
     */
    public void setEmailNormalized(String emailNormalized) {
        this.emailNormalized = emailNormalized;
    }

    /**
     * @return The active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active The active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

}