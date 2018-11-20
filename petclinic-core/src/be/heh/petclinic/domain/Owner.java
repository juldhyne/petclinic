package be.heh.petclinic.domain;

public class Owner extends BaseOwner {

    private String city;
    private String address;
    private String telephone;
    private String[] petsNames;

    // Setters
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

}
