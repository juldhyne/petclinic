package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcPetDaoImpl implements JdbcPetDao {

    private DataSource dataSource;
    private String sql =
            "SELECT id,name,birthdate,type, (SELECT concat_ws(',',pets.owner_id,last_name,first_name) FROM owners where id = pets.owner_id ) AS owner FROM pets";

    public JdbcPetDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void setDatasource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Pet> findAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(sql, new PetRowMapper());
    }

    @Override
    public Pet findById(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForObject(String.join(" ", sql, "WHERE id = ?"), new Object[]{id},
                new PetRowMapper());
    }

    @Override
    public List<Pet> findByType(String type) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(String.join(" ", sql, "WHERE type = ?"), new Object[]{type},
                new PetRowMapper());
    }

    @Override
    public List<Pet> findByOwnerId(int ownerId) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(
                String.join(" ", sql, "WHERE owner_id IN (SELECT id FROM owners WHERE id = ?)"),
                new Object[]{ownerId}, new PetRowMapper());
    }

    @Override
    public void insertPet(Pet pet) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO pets (name, birthdate, type) VALUES (?, ?, ?)",
                new Object[]{pet.getName(), pet.getBirthdate(), pet.getType()});
    }
}

