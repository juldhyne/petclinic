package be.heh.petclinic.component.vet;

import java.util.List;
import javax.sql.DataSource;

import be.heh.petclinic.component.pet.JdbcPetDao;
import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.domain.Vet;

public class JdbcVetDaoImpl implements JdbcVetDao {

    private DataSource dataSource;
    private String sql = "SELECT last_name, first_name, speciality FROM vets";

    public JdbcVetDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Vet[] getVets() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(sql,
                new VetRowMapper()).toArray(new Vet[]{});
    }

    @Override
    public void setDatasource(DataSource datasource) {
        this.dataSource = datasource;
    }
}

