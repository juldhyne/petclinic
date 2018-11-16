package be.heh.petclinic.component.visit;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.domain.Visit;

public class JdbcVisitDao {

    private DataSource dataSource;

    public JdbcVisitDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Visit findById(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForObject("SELECT * FROM visits WHERE id = ?", new Object[] {id},
                new VisitRowMapper());
    }

    public List<Visit> findByPetId(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(
                "SELECT * FROM visits WHERE pet_id IN (SELECT id FROM pets WHERE id = ?)",
                new Object[] {id}, new VisitRowMapper());
    }

}

