package be.heh.petclinic.component.pet;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;

import javax.sql.DataSource;
import java.util.List;

public interface JdbcPetDao {
    List<Pet> findAll();

    Pet findById(int id);

    List<Pet> findByType(String type);

    List<Pet> findByOwnerId(int ownerId);

    void setDatasource(DataSource datasource);
}
