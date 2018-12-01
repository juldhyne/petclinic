package be.heh.petclinic.component.pet;

import java.util.List;
import be.heh.petclinic.domain.Pet;

public interface PetComponent {

    Pet[] getPets();

    Pet getPets(int id);

    Pet[] getPets(String types);

    Pet[] getPetsByOwnerId(int id);


}
