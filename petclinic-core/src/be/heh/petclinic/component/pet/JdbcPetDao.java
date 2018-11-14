package be.heh.petclinic.component.pet;

import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.domain.Pet;
import java.util.List;
import javax.sql.DataSource;

public class JdbcPetDao {

    private DataSource dataSource;

    public JdbcPetDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Pet getEvent(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForObject("SELECT name, birthdate, type FROM pets where id=?",
                new Object[] {id}, new PetRowMapper());
    }

}

