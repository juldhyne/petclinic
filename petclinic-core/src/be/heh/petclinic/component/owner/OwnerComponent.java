package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import java.util.List;

public interface OwnerComponent {

    List<Owner> getOwners();

    Owner getOwners(int id);

    List<Owner> getOwners(String lastname);

    void insertOwner(Owner owner);

    void updateOwner(Owner owner);
    // List<Pet> getPets(int id);

    // int addOwner(Owner owner);

}
