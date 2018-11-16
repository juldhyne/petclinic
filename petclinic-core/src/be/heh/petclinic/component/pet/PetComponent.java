package be.heh.petclinic.component.pet;

import java.util.List;
import be.heh.petclinic.domain.Pet;

public interface PetComponent {

    List<Pet> getPets();

    Pet getPets(int id);

    List<Pet> getPets(String types);

}
