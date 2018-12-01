package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;

public interface OwnerComponent {

    Owner[] getOwners();

    Owner getOwners(int id);

    Owner[] getOwners(String lastname);

    void insertOwner(Owner owner);

    void updateOwner(Owner owner);

}
