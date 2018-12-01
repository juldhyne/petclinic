package be.heh.petclinic.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetTests {
    @Test
    void test_object_pet(){
        be.heh.petclinic.domain.Pet pet = new be.heh.petclinic.domain.Pet();
        int id = 42;
        String name = "Jiminy";
        String date = "2012-12-12";
        String type = "criquet";
        int ownerId = 666;

        pet.setId(id);
        pet.setName(name);
        pet.setBirthdate(date);
        pet.setType(type);
        pet.setOwnerId(ownerId);

        assertEquals(id,pet.getId());
        assertEquals(name,pet.getName());
        assertEquals(date,pet.getBirthdate());
        assertEquals(type,pet.getType());
        assertEquals(ownerId,pet.getOwnerId());
    }
}
