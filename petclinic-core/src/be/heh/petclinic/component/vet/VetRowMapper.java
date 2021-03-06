package be.heh.petclinic.component.vet;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import be.heh.petclinic.domain.Vet;

public class VetRowMapper implements RowMapper<Vet> {

    @Override
    public Vet mapRow(ResultSet rs, int i) throws SQLException {
        Vet vet = new Vet();
        vet.setLastname(rs.getString("last_name"));
        vet.setFirstname(rs.getString("first_name"));
        vet.setSpeciality(rs.getString("speciality"));
        return vet;
    }
}
