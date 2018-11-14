package be.heh.petclinic.component.pet;

import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;
import be.heh.petclinic.domain.Pet;

public class PetRowMapper implements RowMapper<Pet> {

    @Override
    public Pet mapRow(ResultSet rs, int i) throws SQLException {
        Pet pet = new Pet();
        pet.setName(rs.getString("name"));
        pet.setBirthdate(rs.getString("birthdate"));
        return pet;
    }


}
