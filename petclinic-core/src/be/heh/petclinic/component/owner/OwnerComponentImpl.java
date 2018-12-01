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
    public Owner[] getOwners() {
        return jdbcOwnerDaoImpl.findAll();
    }

    @Override
    public Owner getOwners(int id) {
        return jdbcOwnerDaoImpl.findById(id);
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

    // @Override
    // public int addOwner(Owner owner) {
    // return ownerDao.insertOwner(owner);
    // }

=======
>>>>>>> :white_check_mark: OwnerComponent and PetComoponent
}
