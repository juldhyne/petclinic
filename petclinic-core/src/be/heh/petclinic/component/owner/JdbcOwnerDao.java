package be.heh.petclinic.component.owner;

<<<<<<< HEAD
=======
import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.component.pet.PetRowMapper;
>>>>>>> bc42d56ca4d8f73c49ea3cc06ccf8eaf39a239ac
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.component.pet.PetRowMapper;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;

public class JdbcOwnerDao {

    private DataSource dataSource;

    public JdbcOwnerDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Owner> findAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM owners", new OwnerRowMapper());
    }

    public Owner findById(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
<<<<<<< HEAD
=======
        return select.query("SELECT * FROM owners", new OwnerRowMapper());
    }

    public Owner getEvent(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
>>>>>>> bc42d56ca4d8f73c49ea3cc06ccf8eaf39a239ac
        return select.queryForObject("SELECT * FROM owners WHERE id=?", new Object[] {id},
                new OwnerRowMapper());
    }

<<<<<<< HEAD
    public List<Pet> findPets(int id) {
=======
    public List<Pet> getPets(int id) {
>>>>>>> bc42d56ca4d8f73c49ea3cc06ccf8eaf39a239ac
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM pets WHERE owner_id = ?", new Object[] {id},
                new PetRowMapper());
    }

<<<<<<< HEAD
    public int insertOwner(Owner owner) {
=======
    public int addEvent(Owner owner) {
>>>>>>> bc42d56ca4d8f73c49ea3cc06ccf8eaf39a239ac
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        String sql =
                "INSERT INTO owners (first_name, last_name, city, address, telephone) VALUES (?,?,?,?,?)";
        return insert.update(sql, owner.getFirstname(), owner.getLastname(), owner.getCity(),
                owner.getAddress(), owner.getTelephone());
    }
}
