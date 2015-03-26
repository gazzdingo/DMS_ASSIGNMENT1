/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.bcis.chickenfarm;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Taylor
 */
public class InfoMessage implements Serializable {
    
    private String messageType;
    private String message;
    
    public InfoMessage() {
        messageType = "DEFAULT";
        message = "";
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
