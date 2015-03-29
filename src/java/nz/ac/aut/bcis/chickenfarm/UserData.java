/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.bcis.chickenfarm;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author guy
 */
public class UserData implements Serializable{

    public UserData() {
    }

   
    private String email;
    private int id;
    private ArrayList<ItemData> items = new ArrayList();
    private int currentIndex;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
    
    public void addItem(ItemData item)
    {
        items.add(item);
    }
    
    public ArrayList<ItemData> getItems()
    {
        return items;
    }
    
    public ItemData getNextItem()
    {
        return items.get(currentIndex);
    }
    
    public void incrementIndex()
    {
        currentIndex++;
        System.out.println(currentIndex);
    }
    
    public boolean hasNext()
    {
        if( items.size() > currentIndex)
        {
            System.out.println(currentIndex);
            return true;
        }
        else
            return false;
    }
    
    public int getItemsCount()
    {
        return items.size();
    }
    
    public int getIndex()
    {
        return currentIndex;
    }
    
    public ArrayList getArrayOfTypes()
    {
        ArrayList types = new ArrayList();
        
        for(ItemData id : items)
        {
            types.add("\"" + id.getItemType() + "\"");
        }

        return types;
    }
    
    public ArrayList getArrayOfXLocs()
    {
        ArrayList xLocs = new ArrayList();
        
        for(ItemData id : items)
        {
            xLocs.add(id.getxLoc());
        }
        
        return xLocs;
    }
    
    public ArrayList getArrayOfYLocs()
    {
        ArrayList yLocs = new ArrayList();
        
        for(ItemData id : items)
        {
            yLocs.add(id.getyLoc());
        }
        
        return yLocs;
    }
    
}

