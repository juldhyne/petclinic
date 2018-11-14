package be.heh.petclinic.component.owner;

import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.domain.Owner;
import java.util.List;
import javax.sql.DataSource;

public class JdbcOwnerDao {

    private DataSource dataSource;

    public JdbcOwnerDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Owner> getEvents() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT last_name, first_name FROM owners", new OwnerRowMapper());
    }

}

