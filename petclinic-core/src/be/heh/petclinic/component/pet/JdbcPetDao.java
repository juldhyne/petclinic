package be.heh.petclinic.component.pet;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.domain.Pet;

public class JdbcPetDao {

    private DataSource dataSource;

    public JdbcPetDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Pet> findAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT id, name, birthdate, type FROM pets", new PetRowMapper());
    }

    public Pet findById(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        // return select.queryForObject("SELECT id, name, birthdate, type FROM pets WHERE id=?",
        return select.queryForObject("SELECT * FROM pets WHERE id = ?", new Object[] {id},
                new PetRowMapper());
    }

    public List<Pet> findByType(String type) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        // return select.query("SELECT id, name, birthdate, type FROM pets WHERE type=?",
        return select.query("SELECT * FROM pets WHERE type = ?", new Object[] {type},
                new PetRowMapper());
    }

}

