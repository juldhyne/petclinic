package be.heh.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerTests {
    @Test
    public void test_object_owner(){
        be.heh.petclinic.domain.Owner owner = new be.heh.petclinic.domain.Owner();

        int id = 26;
        String firstname = "John";
        String lastname = "Doe";
        String city = "Mons";
        String address = "avenue de du génrale de gaulle 46";
        String telephone = "065656565";
        String[] petsName = {"pikachu","evoli"};

        owner.setId(id);
        owner.setFirstname(firstname);
        owner.setLastname(lastname);
        owner.setCity(city);
        owner.setAddress(address);
        owner.setTelephone(telephone);
        owner.setPetsNames(petsName);

        assertEquals(id,owner.getId());
        assertEquals(firstname,owner.getFirstname());
        assertEquals(lastname,owner.getLastname());
        assertEquals(city,owner.getCity());
        assertEquals(address,owner.getAddress());
        assertEquals(telephone,owner.getTelephone());
        assertEquals(petsName,owner.getPetsNames());
    }
}
