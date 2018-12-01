package be.heh.petclinic.domain;

public class Vet {

    private String lastname;
    private String firstname;
    private String speciality;

    // Setters
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    // Getters
    public String getLastname() {
        return this.lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    @Override
    public String toString() {
        return "Vet{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
