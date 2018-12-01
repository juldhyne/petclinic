package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import javax.sql.DataSource;
import java.util.List;

public interface JdbcOwnerDao {
    Owner[] findAll();

    Owner findById(int id);

    Owner[] findByLastname(String lastName);

    void setDatasource(DataSource datasource);
}
