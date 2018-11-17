package be.heh.petclinic.domain;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Owner {

    private int id;
    private String lastname;
    private String firstname;
    private String city;
    private String address;
    private String telephone;
    private List<String> petsNames;

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
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

    public void setPetsNames(String petsNames) {
        // Mutable list from an array
        // this.petsNames = Arrays.stream(petsNames.split(",")).collect(Collectors.toList());

        // Not mutable list
        this.petsNames = Arrays.asList(petsNames.split(","));
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

    public List<String> getPetsNames() {
        return this.petsNames;
    }

}
