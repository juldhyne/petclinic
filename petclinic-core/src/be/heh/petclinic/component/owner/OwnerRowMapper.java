package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerRowMapper implements RowMapper<Owner> {

    @Override
    public Owner mapRow(ResultSet rs, int i) throws SQLException {
        Owner owner = new Owner();
        owner.setId(rs.getInt("id"));
        owner.setLastname(rs.getString("last_name"));
        owner.setFirstname(rs.getString("first_name"));
        owner.setCity(rs.getString("city"));
        owner.setAddress(rs.getString("address"));
        owner.setTelephone(rs.getString("telephone"));
        if (!rs.getString("pets_names").isEmpty()) {
            owner.setPetsNames(rs.getString("pets_names").split(","));
        }
        return owner;
    }
}
