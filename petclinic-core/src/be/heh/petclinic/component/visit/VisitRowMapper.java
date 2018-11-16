package be.heh.petclinic.component.visit;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import be.heh.petclinic.domain.Visit;

public class VisitRowMapper implements RowMapper<Visit> {

    @Override
    public Visit mapRow(ResultSet rs, int i) throws SQLException {
        Visit visit = new Visit();
        visit.setId(rs.getInt("id"));
        visit.setDate(rs.getString("date"));
        visit.setDescription(rs.getString("description"));
        visit.setPetId(rs.getInt("petId"));
        return visit;
    }


}
