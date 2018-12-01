package be.heh.petclinic.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pet {

    private int id;
    private String name;
    private String birthdate;
    private String type;
    @JsonProperty("owner_id")
    private int ownerId;

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

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

    public int getOwnerId() {
        return this.ownerId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", type='" + type + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }
}
