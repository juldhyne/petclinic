package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

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
    public Owner[] findByLastname(String lastname) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(String.join(" ", sql, "WHERE last_name LIKE ?"),
                new Object[]{String.format("%s%%", lastname)}, new OwnerRowMapper()).toArray(new Owner[]{});

    }

    @Override
    public void insertOwner(Owner owner) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO owners (first_name, last_name, city, address,telephone) VALUES (?, ?, ?, ?, ?)",
                new Object[]{owner.getFirstname(), owner.getLastname(), owner.getCity(), owner.getAddress(), owner.getTelephone()});
    }

    @Override
    public void updateOwner(Owner owner) {
        JdbcTemplate update = new JdbcTemplate(dataSource);
        update.update("UPDATE owners SET first_name = ?, last_name = ?, city = ?, address = ?,telephone = ? WHERE id = ?",
                new Object[]{owner.getFirstname(), owner.getLastname(), owner.getCity(), owner.getAddress(), owner.getTelephone(), owner.getId()});
    }

    @Override
    public void setDatasource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
