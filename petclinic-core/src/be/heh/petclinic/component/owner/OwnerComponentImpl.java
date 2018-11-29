package be.heh.petclinic.component.owner;

import java.util.List;
import javax.sql.DataSource;
import be.heh.petclinic.domain.*;

class OwnerComponentImpl implements OwnerComponent {

    private JdbcOwnerDao jdbcOwnerDaoImpl;

    public OwnerComponentImpl(JdbcOwnerDao jdbcOwnerDao, DataSource dataSource) {
        this.jdbcOwnerDaoImpl = jdbcOwnerDao;
        this.jdbcOwnerDaoImpl.setDatasource(dataSource);
    }

    @Override
    public List<Owner> getOwners() {
        List<Owner> owners = jdbcOwnerDaoImpl.findAll();
        return owners;
    }

    @Override
    public Owner getOwners(int id) {
        Owner owner = jdbcOwnerDaoImpl.findById(id);
        return owner;
    }

<<<<<<< HEAD
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

    @Override
    public void insertOwner(Owner owner) {
     ownerDao.insertOwner(owner);
    }

    @Override
    public void updateOwner(Owner owner) {
     ownerDao.updateOwner(owner);
    }

=======
>>>>>>> :white_check_mark: OwnerComponent and PetComoponent
}
