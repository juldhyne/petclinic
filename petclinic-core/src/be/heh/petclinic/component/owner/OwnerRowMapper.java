package be.heh.petclinic.component.owner;

import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;
import be.heh.petclinic.domain.Owner;

public class OwnerRowMapper implements RowMapper<Owner> {

    @Override
    public Owner mapRow(ResultSet rs, int i) throws SQLException {
        Owner owner = new Owner();
        owner.setLastname(rs.getString("last_name"));
        owner.setFirstname(rs.getString("first_name"));
        return owner;
    }


}
