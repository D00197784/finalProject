/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Richard
 */
public class User {

    private String username;
    private String password;
    private int userID;
    private String email;
    private int role;
    private int active;
    private ArrayList<Address> address;

    public User() {
        this.userID = -1;
    }
    
public User(int id, String username, String password) {
        this.userID = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email, int role, int active, ArrayList<Address> addr) {
        this.username = username;
        this.password = password;
        this.userID = -1;
        this.email = email;
        this.role = role;
        this.active = active;
        address = addr;
    }

    public User(int userID,String username, String password, String email, int role, int active, ArrayList<Address> addr) {
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.email = email;
        this.role = role;
        this.active = active;
        address = addr;
    }
    
     public User(int userID,String username, String password, String email, int role, int active) {
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.email = email;
        this.role = role;
        this.active = active;
      
    }

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public int getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getActive() {
        return active;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.userID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", userID=" + userID + ", email=" + email + ", role=" + role + ", active=" + active + ", address=" + address + '}';
    }

    
}
