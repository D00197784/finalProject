/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author D00194667
 */
public class Address {

    private int addressID;
    private int userID;
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String city;
    private String country;

    public Address(int addressID, int userID, String addressLine1, String addressLine2, String town, String city, String country) {
        this.addressID = addressID;
        this.userID = userID;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.city = city;
        this.country = country;
    }

    public Address(int userID, String addressLine1, String addressLine2, String town, String city, String country) {
        this.addressID = -1;
        this.userID = userID;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.city = city;
        this.country = country;
    }

    public Address() {
        this.addressID = -1;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.addressID;
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
        final Address other = (Address) obj;
        if (this.addressID != other.addressID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "addressID=" + addressID + ", userID=" + userID + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", town=" + town + ", city=" + city + ", country=" + country + '}';
    }

}
