/*
*   USER OBJECT
*   STORES INFORMATION ABOUT A USER
*/
package model;

import java.util.ArrayList;
import java.util.*;

public class User{
    private String username;
    private String password;
    private String firstName;
    private String LastName;
    private String email;
    private Map<String,String[]> cart = null;
    
    public User(String username, String password){
        this.setUsername(username);
        this.setPassword(password);
        this.cart = new HashMap<>();
        System.out.println(cart);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        return this.getUsername();
    }

    public Map<String,String[]> getCart() {
        return cart;
    }

    public void setCart(Map<String,String[]> cart) {
        this.cart = cart;
    }

    
    
}
