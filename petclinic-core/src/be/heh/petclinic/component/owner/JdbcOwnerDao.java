package be.heh.petclinic.component.owner;
import be.heh.petclinic.domain.Owner;
<<<<<<< HEAD
import java.util.List;
=======

>>>>>>> :white_check_mark: OwnerComponent and PetComoponent
import javax.sql.DataSource;
import java.util.List;

<<<<<<< HEAD
public class JdbcOwnerDao implements JdbcOwner {

    private DataSource dataSource;
    private static String sql =
            "SELECT * , (SELECT ifnull(group_concat(name),'') FROM pets WHERE owner_id = owners.id) AS pets_names FROM owners";

    public JdbcOwnerDao(DataSource dataSource) {
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

    public List<Owner> findByLastname(String lastname) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(String.join(" ", sql, "WHERE last_name LIKE ?"),
                new Object[] {String.format("%s%%", lastname)}, new OwnerRowMapper());
    }

    @Override
    public void setDatasource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
=======
public interface JdbcOwnerDao {
    List<Owner> findAll();
>>>>>>> :white_check_mark: OwnerComponent and PetComoponent

    Owner findById(int id);

    void setDatasource(DataSource datasource);
}
