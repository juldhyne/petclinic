package be.heh.petclinic.component.visit;

import be.heh.petclinic.domain.Visit;

import javax.sql.DataSource;

public interface JdbcVisitDao {
    Visit findById(int id);

    Visit[] findByPetId(int id);

    void setDatasource(DataSource datasource);

    void insertVisit(Visit visit);
}
