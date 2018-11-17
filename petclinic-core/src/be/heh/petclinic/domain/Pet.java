package be.heh.petclinic.domain;

public class Pet {

    private int id;
    private String name;
    private String birthdate;
    private String type;
    private int ownerId;
    private String ownerName;

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

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public String getOwnerName() {
        return this.ownerName;
    }

}
