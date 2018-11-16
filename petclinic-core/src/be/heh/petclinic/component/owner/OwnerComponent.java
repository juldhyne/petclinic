package be.heh.petclinic.component.owner;

<<<<<<< HEAD
=======
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;
>>>>>>> bc42d56ca4d8f73c49ea3cc06ccf8eaf39a239ac
import java.util.List;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;

public interface OwnerComponent {

    List<Owner> getOwners();

    Owner getOwners(int id);

    List<Pet> getPets(int id);

    int addOwner(Owner owner);

    Owner getOwner(int id);

    List<Pet> getPets(int id);

    int addOwner(Owner owner);

}
