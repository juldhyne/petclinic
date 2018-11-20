package be.heh.petclinic.component.owner;

import java.util.List;
import javax.sql.DataSource;
import be.heh.petclinic.domain.*;

class OwnerComponentImpl implements OwnerComponent {

    private JdbcOwnerDao ownerDao;

    public OwnerComponentImpl(DataSource dataSource) {
        ownerDao = new JdbcOwnerDao(dataSource);
    }

    @Override
    public List<Owner> getOwners() {
        List<Owner> owners = ownerDao.findAll();
        return owners;
    }

    @Override
    public Owner getOwners(int id) {
        Owner owner = ownerDao.findById(id);
        return owner;
    }

    @Override
    public List<Owner> getOwners(String lastname) {
        List<Owner> owners = ownerDao.findByLastname(lastname);
        return owners;
    }

    // @Override
    // public List<Pet> getPets(int id) {
    // List<Pet> ownerPets = ownerDao.findPets(id);
    // return ownerPets;
    // }

    // @Override
    // public int addOwner(Owner owner) {
    // return ownerDao.insertOwner(owner);
    // }

}
