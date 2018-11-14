package be.heh.petclinic.domain;

import java.util.List;


public class Pet {

    private String name;
    private String birthdate;
    private String type;
    // private List<Visit> visits; // Todo

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Todo
    // public void setVisit(Visit visit) {
    // this.visit = visit
    // }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public String getType() {
        return this.type;
    }

    // Todo
    // public List<Visit> getVisits() {
    // return this.visits;
    // }

}
