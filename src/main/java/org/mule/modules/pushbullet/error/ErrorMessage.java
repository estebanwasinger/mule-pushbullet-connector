package org.mule.modules.pushbullet.error;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class ErrorMessage {

    @Expose
    private String type;
    @Expose
    private String message;
    @Expose
    private String param;
    @Expose
    private String cat;

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The param
     */
    public String getParam() {
        return param;
    }

    /**
     *
     * @param param
     * The param
     */
    public void setParam(String param) {
        this.param = param;
    }

    /**
     *
     * @return
     * The cat
     */
    public String getCat() {
        return cat;
    }

    /**
     *
     * @param cat
     * The cat
     */
    public void setCat(String cat) {
        this.cat = cat;
    }

}