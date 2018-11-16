package be.heh.petclinic.component.visit;

import java.util.List;
import javax.sql.DataSource;
import be.heh.petclinic.domain.*;

class VisitComponentImpl implements VisitComponent {

    private JdbcVisitDao visitDao;

    public VisitComponentImpl(DataSource dataSource) {
        visitDao = new JdbcVisitDao(dataSource);
    }

    @Override
    public Visit getVisitById(int id) {
        Visit visit = visitDao.findById(id);
        return visit;
    }

    @Override
    public List<Visit> getVisitsByPetId(int petId) {
        List<Visit> visits = visitDao.findByPetId(petId);
        return visits;
    }
}
