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

   @Override
    public Owner[] getOwners(String lastname) {
        return jdbcOwnerDaoImpl.findByLastname(lastname);
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
