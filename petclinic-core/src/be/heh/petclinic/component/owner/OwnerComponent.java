package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import java.util.List;

public interface OwnerComponent {

    List<Owner> getOwners();

    Owner getOwners(int id);

<<<<<<< HEAD
    List<Owner> getOwners(String lastname);


    // List<Pet> getPets(int id);

    // int addOwner(Owner owner);

=======
>>>>>>> :white_check_mark: OwnerComponent and PetComoponent
}
