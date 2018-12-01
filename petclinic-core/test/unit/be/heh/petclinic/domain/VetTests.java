package be.heh.petclinic.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VetTests {

    @Test
    void test_object_vet(){
        be.heh.petclinic.domain.Vet vet = new be.heh.petclinic.domain.Vet();

        String firstname = "John";
        String lastname = "Doe";
        String specialty = "Dead";

        vet.setFirstname(firstname);
        vet.setLastname(lastname);
        vet.setSpeciality(specialty);

        assertEquals(firstname,vet.getFirstname());
        assertEquals(lastname,vet.getLastname());
        assertEquals(specialty,vet.getSpeciality());
    }

}