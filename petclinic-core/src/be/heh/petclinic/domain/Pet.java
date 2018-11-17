package be.heh.petclinic.domain;

import java.util.HashMap;

public class Pet {

    private int id;
    private String name;
    private String birthdate;
    private String type;
    private HashMap<String, String> owner; // Should be replace by a minimal version of Owner class?

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOwner(HashMap<String, String> owner) {
        this.owner = owner;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public String getType() {
        return this.type;
    }

    public HashMap<String, String> getOwner() {
        return this.owner;
    }
}
