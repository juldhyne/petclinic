package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;

import javax.sql.DataSource;

public interface JdbcOwnerDao {
    Owner[] findAll();

    Owner findById(int id);

    Owner[] findByLastname(String lastName);

    void insertOwner(Owner owner);

    void updateOwner(Owner owner);

    void setDatasource(DataSource datasource);
}
