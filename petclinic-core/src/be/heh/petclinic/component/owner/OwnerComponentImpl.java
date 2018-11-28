package be.heh.petclinic.component.owner;

import java.util.List;
import javax.sql.DataSource;
import be.heh.petclinic.domain.*;
import org.springframework.beans.factory.annotation.Autowired;

class OwnerComponentImpl implements OwnerComponent {

    private JdbcOwner ownerDaoImpl;

    public OwnerComponentImpl(DataSource dataSource,JdbcOwner ownerDao) {
        this.ownerDaoImpl = ownerDao;
        this.ownerDaoImpl.setDatasource(dataSource);
    }

    @Override
    public List<Owner> getOwners() {
        List<Owner> owners = ownerDaoImpl.findAll();
        return owners;
    }

    @Override
    public Owner getOwners(int id) {
        Owner owner = ownerDaoImpl.findById(id);
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
