package be.heh.petclinic.component.owner;

import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.component.pet.PetRowMapper;
import java.util.List;
import javax.sql.DataSource;

public class JdbcOwnerDao {

    private DataSource dataSource;

    public JdbcOwnerDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Owner> getEvents() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM owners", new OwnerRowMapper());
    }

    public Owner getEvent(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForObject("SELECT * FROM owners WHERE id=?", new Object[] {id},
                new OwnerRowMapper());
    }

    public List<Pet> getPets(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM pets WHERE owner_id = ?", new Object[] {id},
                new PetRowMapper());
    }

    public int addEvent(Owner owner) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        String sql =
                "INSERT INTO owners (first_name, last_name, city, address, telephone) VALUES (?,?,?,?,?)";
        return insert.update(sql, owner.getFirstname(), owner.getLastname(), owner.getCity(),
                owner.getAddress(), owner.getTelephone());
    }
}
