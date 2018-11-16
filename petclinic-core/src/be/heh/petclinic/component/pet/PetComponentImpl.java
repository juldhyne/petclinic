package be.heh.petclinic.component.pet;

import java.util.List;
import javax.sql.DataSource;
import be.heh.petclinic.domain.*;

class PetComponentImpl implements PetComponent {

    private JdbcPetDao petDao;

    public PetComponentImpl(DataSource dataSource) {
        petDao = new JdbcPetDao(dataSource);
    }

    @Override
    public List<Pet> getPets() {
        List<Pet> pets = petDao.findAll();
        return pets;
    }

    @Override
    public Pet getPets(int id) {
        Pet pet = petDao.findById(id);
        return pet;
    }

    @Override
    public List<Pet> getPets(String type) {
        List<Pet> pets = petDao.findByType(type);
        return pets;
    }


}
