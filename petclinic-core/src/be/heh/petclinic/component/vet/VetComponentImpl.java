package be.heh.petclinic.component.vet;

import java.util.List;
import javax.sql.DataSource;
import be.heh.petclinic.domain.*;

class VetComponentImpl implements VetComponent {

    private JdbcVetDao vetDao;

    public VetComponentImpl(DataSource dataSource) {
        vetDao = new JdbcVetDao(dataSource);
    }

    @Override
    public List<Vet> getVets() {
        List<Vet> vets = vetDao.getEvents();
        return vets;
    }


}
