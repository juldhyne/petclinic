package be.heh.petclinic.domain;

public class BaseOwner {

    private int id;
    private String lastname;
    private String firstname;

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
}
