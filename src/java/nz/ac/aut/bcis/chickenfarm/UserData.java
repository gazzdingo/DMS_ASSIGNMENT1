/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.bcis.chickenfarm;

import java.io.Serializable;

/**
 *
 * @author guy
 */
public class UserData implements Serializable{

    public UserData() {
    }

   
    private String email;
    private int id;

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
    
    
    
}

