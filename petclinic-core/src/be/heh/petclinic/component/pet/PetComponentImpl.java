package be.heh.petclinic.component.pet;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Collection;
import javax.sql.DataSource;
import be.heh.petclinic.domain.*;

class PetComponentImpl implements PetComponent {

    private JdbcPetDao petDao;

    public PetComponentImpl(DataSource dataSource) {
        petDao = new JdbcPetDao(dataSource);
    }

    @Override
    public Pet getPet(int id) {
        Pet pet = petDao.getEvent(id);
        return pet;
    }


}
