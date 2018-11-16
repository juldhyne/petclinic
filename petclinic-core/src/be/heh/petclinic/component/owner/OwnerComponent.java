package be.heh.petclinic.component.owner;

import java.util.List;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;

public interface OwnerComponent {

    List<Owner> getOwners();

    Owner getOwners(int id);

    List<Pet> getPets(int id);

    int addOwner(Owner owner);

}
