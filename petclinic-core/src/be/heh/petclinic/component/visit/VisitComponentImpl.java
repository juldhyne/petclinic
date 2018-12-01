package be.heh.petclinic.component.visit;

import java.util.List;
import javax.sql.DataSource;
import be.heh.petclinic.domain.*;

class VisitComponentImpl implements VisitComponent {

    private JdbcVisitDao jdbcVisitDaoImpl;

    public VisitComponentImpl(JdbcVisitDao jdbcVisitDao,DataSource dataSource) {
        this.jdbcVisitDaoImpl = jdbcVisitDao;
        this.jdbcVisitDaoImpl.setDatasource(dataSource);
    }

    @Override
    public Visit getVisitById(int id) {
        return jdbcVisitDaoImpl.findById(id);
    }

    @Override
    public Visit[] getVisitsByPetId(int petId) {
        return jdbcVisitDaoImpl.findByPetId(petId);
    }
}
