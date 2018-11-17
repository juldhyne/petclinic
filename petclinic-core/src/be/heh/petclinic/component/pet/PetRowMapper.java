package be.heh.petclinic.component.pet;

import java.util.HashMap;
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
        pet.setOwner(subMap(rs.getString("owner")));

        return pet;
    }

    private HashMap<String, String> subMap(String s) {
        HashMap<String, String> owner = new HashMap<String, String>();
        String[] tmp = s.split(",");
        owner.put("id", tmp[0]);
        owner.put("lastName", tmp[1]);
        owner.put("firstName", tmp[2]);
        return owner;
    }
}
