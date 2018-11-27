package be.heh.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetTests {
    @Test
    public void test_object_pet(){
        be.heh.petclinic.domain.Pet pet = new be.heh.petclinic.domain.Pet();
        be.heh.petclinic.domain.BaseOwner owner = new  be.heh.petclinic.domain.BaseOwner();

        int id = 42;
        String name = "Jiminy";
        String date = "2012-12-12";
        String type = "criquet";

        owner.setFirstname("john");
        owner.setLastname("doe");
        owner.setId(22);

        pet.setId(id);
        pet.setName(name);
        pet.setBirthdate(date);
        pet.setType(type);
        pet.setOwner(owner);


        assertEquals(id,pet.getId());
        assertEquals(name,pet.getName());
        assertEquals(date,pet.getBirthdate());
        assertEquals(type,pet.getType());
        assertEquals(owner,pet.getOwner());
    }
}
