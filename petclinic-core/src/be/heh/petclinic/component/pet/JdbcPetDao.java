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

    public List<Pet> getEvents() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT name, birthdate, owner FROM pets", new PetRowMapper());
    }

}

