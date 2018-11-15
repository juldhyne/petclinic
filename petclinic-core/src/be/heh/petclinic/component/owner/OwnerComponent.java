package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;
import java.util.List;
import java.util.Collection;

public interface OwnerComponent {

    Collection<Owner> getOwners();

    Owner getOwner(int id);

    List<Pet> getPets(int id);

    int addOwner(Owner owner);

}
