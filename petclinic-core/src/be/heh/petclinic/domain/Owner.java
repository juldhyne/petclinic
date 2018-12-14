package be.heh.petclinic.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Owner{

    private int id;
    private String lastname;
    private String firstname;
    private String city;
    private String address;
    private String telephone;
    @JsonProperty("pets_names")
    private String[] petsNames;


    // Setters
    public void setId(int id) {

        this.id = id;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPetsNames(String[] petsNames) {
        this.petsNames = petsNames;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getCity() {
        return this.city;
    }

    public String getAddress() {
        return this.address;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String[] getPetsNames() {
        return this.petsNames;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", petsNames=" + Arrays.toString(petsNames) +
                '}';
    }
}
