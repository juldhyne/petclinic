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
<<<<<<< HEAD
    public Owner getOwners(int id) {
        Owner owner = ownerDao.findById(id);
=======
    public Owner getOwner(int id) {
        Owner owner = ownerDao.getEvent(id);
>>>>>>> bc42d56ca4d8f73c49ea3cc06ccf8eaf39a239ac
        return owner;
    }

    @Override
    public List<Pet> getPets(int id) {
<<<<<<< HEAD
        List<Pet> ownerPets = ownerDao.findPets(id);
=======
        List<Pet> ownerPets = ownerDao.getPets(id);
>>>>>>> bc42d56ca4d8f73c49ea3cc06ccf8eaf39a239ac
        return ownerPets;
    }

    @Override
    public int addOwner(Owner owner) {
<<<<<<< HEAD
        return ownerDao.insertOwner(owner);
=======
        return ownerDao.addEvent(owner);
>>>>>>> bc42d56ca4d8f73c49ea3cc06ccf8eaf39a239ac
    }

}
