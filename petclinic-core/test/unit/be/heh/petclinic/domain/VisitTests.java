package be.heh.petclinic.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitTests {
    @Test
    public void test_object_visit(){
        be.heh.petclinic.domain.Visit visit = new be.heh.petclinic.domain.Visit();

        int id = 66;
        String date = "2012-12-12";
        String description = "Fin du monde.";
        int petId = 6;

        visit.setId(id);
        visit.setDate(date);
        visit.setDescription(description);
        visit.setPetId(petId);

        assertEquals(id,visit.getId());
        assertEquals(date,visit.getDate());
        assertEquals(description,visit.getDescription());
        assertEquals(petId,visit.getPetId());
    }
}
