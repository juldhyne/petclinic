package be.heh.petclinic.component.pet;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import be.heh.petclinic.domain.Pet;

public class PetRowMapper implements RowMapper<Pet> {

    @Override
    public Pet mapRow(ResultSet rs, int i) throws SQLException {
        Pet pet = new Pet();
        pet.setId(rs.getInt("id"));
        pet.setName(rs.getString("name"));
        pet.setBirthdate(rs.getString("birthdate"));
        pet.setType(rs.getString("type"));
        pet.setOwnerId(rs.getInt("owner_id"));
        pet.setOwnerName(rs.getString("owner_name"));
        return pet;
    }
}
