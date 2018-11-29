package be.heh.petclinic.component.owner;

import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.domain.Owner;

import java.util.List;
import javax.sql.DataSource;

public class JdbcOwnerDaoImpl implements JdbcOwnerDao {

    private DataSource dataSource;
    private static String sql =
            "SELECT * , (SELECT ifnull(group_concat(name),'') FROM pets WHERE owner_id = owners.id) AS pets_names FROM owners";

    public JdbcOwnerDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Owner> findAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(sql, new OwnerRowMapper());
    }

    @Override
    public Owner findById(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForObject(String.join(" ", sql, "WHERE id=?"), new Object[] {id},
                new OwnerRowMapper());
    }

    @Override
    public void setDatasource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    // Useless function ?
    // public List<Pet> findPets(int id) {
    // JdbcTemplate select = new JdbcTemplate(dataSource);
    // return select.query("SELECT * FROM pets WHERE owner_id = ?", new Object[] {id},
    // new PetRowMapper());
    // }

    // Todo
    // public int insertOwner(Owner owner) {
    // JdbcTemplate insert = new JdbcTemplate(dataSource);
    // String sql =
    // "INSERT INTO owners (first_name, last_name, city, address, telephone) VALUES (?,?,?,?,?)";
    // return insert.update(sql, owner.getFirstname(), owner.getLastname(), owner.getCity(),
    // owner.getAddress(), owner.getTelephone());
    // }
}
