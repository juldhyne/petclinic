package be.heh.petclinic.component.pet;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.domain.Pet;

public class JdbcPetDao {

    private DataSource dataSource;
    private String sql =
            "SELECT id,name,birthdate,type, (SELECT concat_ws(',',pets.owner_id,last_name,first_name) FROM owners where id = pets.owner_id ) AS owner FROM pets";

    public JdbcPetDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Pet> findAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(sql, new PetRowMapper());
    }

    public Pet findById(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForObject(String.join(" ", sql, "WHERE id = ?"), new Object[] {id},
                new PetRowMapper());
    }

    public List<Pet> findByType(String type) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(String.join(" ", sql, "WHERE type = ?"), new Object[] {type},
                new PetRowMapper());
    }

    public void insertPet(Pet pet)
    {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO pets (name, birthdate, type) VALUES (?, ?, ?)",
        new Object[]{pet.getName(), pet.getBirthDate(), pet.getType()});
    }

    public List<Pet> findByOwnerId(int ownerId) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(
                String.join(" ", sql, "WHERE owner_id IN (SELECT id FROM owners WHERE id = ?)"),
                new Object[] {ownerId}, new PetRowMapper());
    }

}

