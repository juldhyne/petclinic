package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

public class JdbcOwnerDaoImpl implements JdbcOwnerDao {

    private static String sql =
            "SELECT * , (SELECT ifnull(group_concat(name),'') FROM pets WHERE owner_id = owners.id) AS pets_names FROM owners";
    private DataSource dataSource;

    public JdbcOwnerDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Owner[] findAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(sql, new OwnerRowMapper()).toArray(new Owner[]{});
    }

    @Override
    public Owner findById(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForObject(String.join(" ", sql, "WHERE id=?"), new Object[]{id},
                new OwnerRowMapper());
    }

    @Override
    public void setDatasource(DataSource dataSource) {
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
