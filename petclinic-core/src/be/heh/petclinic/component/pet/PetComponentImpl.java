package be.heh.petclinic.component.pet;

import java.util.List;
import javax.sql.DataSource;
import be.heh.petclinic.domain.*;

class PetComponentImpl implements PetComponent {

    private JdbcPetDao jdbcPetDaoImpl;

    public PetComponentImpl(JdbcPetDao jdbcPetDao,DataSource dataSource) {
        this.jdbcPetDaoImpl = jdbcPetDao;
        this.jdbcPetDaoImpl.setDatasource(dataSource);
    }

    @Override
    public Pet[] getPets() {
        return jdbcPetDaoImpl.findAll();
    }

    @Override
    public Pet getPets(int id) {
        return jdbcPetDaoImpl.findById(id);
    }

    @Override
    public Pet[] getPets(String type) {
        return jdbcPetDaoImpl.findByType(type);
    }

    @Override
    public Pet[] getPetsByOwnerId(int id) {
        return jdbcPetDaoImpl.findByOwnerId(id);
    }

    @Override
    public void insertPet(Pet pet) {
        jdbcPetDaoImpl.insertPet(pet);
    }

    @Override
    public void updatePet(Pet pet) {
        jdbcPetDaoImpl.updatePet(pet);
    }

}
