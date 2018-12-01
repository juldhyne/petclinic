package be.heh.petclinic.component.vet;

import java.util.List;
import javax.sql.DataSource;
import be.heh.petclinic.domain.*;

class VetComponentImpl implements VetComponent {

    private JdbcVetDao jdbcVetDaoImpl;

    public VetComponentImpl(JdbcVetDao jdbcVetDao ,DataSource dataSource) {
        this.jdbcVetDaoImpl = jdbcVetDao;
        this.jdbcVetDaoImpl.setDatasource(dataSource);
    }

    @Override
    public Vet[] getVets() {
        return jdbcVetDaoImpl.getVets();
    }


}
