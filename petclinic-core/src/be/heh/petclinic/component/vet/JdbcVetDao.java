package be.heh.petclinic.component.vet;

import be.heh.petclinic.domain.Vet;

import javax.sql.DataSource;

public interface JdbcVetDao {
    Vet[] getVets();

    void setDatasource(DataSource datasource);
}
