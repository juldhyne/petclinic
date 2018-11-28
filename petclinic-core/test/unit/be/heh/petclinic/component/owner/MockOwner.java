package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class MockOwner implements JdbcOwner{

    private DataSource dataSource;

    @Override
    public List<Owner> findAll() {
        List<Owner> os = new ArrayList<Owner>();
        Owner o1 = new Owner();
        Owner o2 = new Owner();
        Owner o3 = new Owner();
        Owner o4 = new Owner();
        Owner o5 = new Owner();
        return ;
    }

    @Override
    public Owner findById(int id) {
        return null;
    }

    @Override
    public void setDatasource(DataSource datasource) {
        this.dataSource=null;
    }
}
