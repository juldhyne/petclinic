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
    public List<Pet> getPets() {
        List<Pet> pets = jdbcPetDaoImpl.findAll();
        return pets;
    }

    @Override
    public Pet getPets(int id) {
        Pet pet = jdbcPetDaoImpl.findById(id);
        return pet;
    }

    @Override
    public List<Pet> getPets(String type) {
        List<Pet> pets = jdbcPetDaoImpl.findByType(type);
        return pets;
    }

    @Override
    public List<Pet> getPetsByOwnerId(int id) {
        List<Pet> pets = jdbcPetDaoImpl.findByOwnerId(id);
        return pets;
    }

    @Override
    public void insertPet(Pet pet) {
     petDao.insertPet(pet);
    }

}
