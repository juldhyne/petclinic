package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class JdbcPetDaoImpl implements JdbcPetDao {

    private DataSource dataSource;
    private String sql = "SELECT * FROM pets";

    public JdbcPetDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void setDatasource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Pet[] findAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(sql, new PetRowMapper()).toArray(new Pet[] {});
    }

    @Override
    public Pet findById(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForObject(String.join(" ", sql, "WHERE id = ?"), new Object[] {id},
                new PetRowMapper());
    }

    @Override
    public Pet[] findByType(String type) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(String.join(" ", sql, "WHERE type = ?"), new Object[] {type},
                new PetRowMapper()).toArray(new Pet[] {});
    }

    @Override
    public Pet[] findByOwnerId(int ownerId) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(
                String.join(" ", sql, "WHERE owner_id IN (SELECT id FROM owners WHERE id = ?)"),
                new Object[] {ownerId}, new PetRowMapper()).toArray(new Pet[] {});
    }

    @Override
    public void insertPet(Pet pet) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO pets (name, birthdate, type) VALUES (?, ?, ?)",
                new Object[] {pet.getName(), pet.getBirthdate(), pet.getType()});
    }

}

