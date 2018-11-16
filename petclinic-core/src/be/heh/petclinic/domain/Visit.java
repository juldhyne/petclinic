package be.heh.petclinic.domain;

public class Visit {

    private int id;
    private String date;
    private String description;
    private int petId;

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPetId() {
        return this.petId;
    }

}
