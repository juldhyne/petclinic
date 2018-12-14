package be.heh.petclinic.component.visit;

import be.heh.petclinic.domain.Visit;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcVisitDaoImpl implements JdbcVisitDao {

    private DataSource dataSource;
    private String sql = "SELECT * FROM visits";

    public JdbcVisitDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Visit findById(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForObject(String.join(" ", sql, "WHERE id = ?"), new Object[]{id},
                new VisitRowMapper());
    }

    @Override
    public Visit[] findByPetId(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(
                String.join(" ", sql, "WHERE pet_id IN (SELECT id FROM pets WHERE id = ?)"),
                new Object[]{id}, new VisitRowMapper()).toArray(new Visit[]{});
    }

    @Override
    public void setDatasource(DataSource datasource) {
        this.dataSource = datasource;
    }

    @Override
    public void insertVisit(Visit visit) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO visits (date,description, pet_id) VALUES (?, ?, ?)",
               new Object[]{visit.getDate(), visit.getDescription(), visit.getPetId()});
    }

}

