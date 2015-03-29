/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.bcis.chickenfarm;

import java.io.Serializable;

/**
 *
 * @author Taylor
 */
public class ItemData implements Serializable {

    public ItemData()
    {
        
    }
    
    private int xLoc;
    private int yLoc;
    private String itemType;
    private int ownerID;

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
    
    
}
