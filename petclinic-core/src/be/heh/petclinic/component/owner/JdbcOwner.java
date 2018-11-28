package be.heh.petclinic.component.owner;
import be.heh.petclinic.domain.Owner;

import javax.sql.DataSource;
import java.util.List;

public interface JdbcOwner {
    public List<Owner> findAll();

    public Owner findById(int id);

    public void setDatasource(DataSource datasource);
}
