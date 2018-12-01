package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;

import javax.sql.DataSource;

public interface JdbcPetDao {
    Pet[] findAll();

    Pet findById(int id);

    Pet[] findByType(String type);

    Pet[] findByOwnerId(int ownerId);

    void setDatasource(DataSource datasource);
}
