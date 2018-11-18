package be.heh.petclinic.component.pet;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import be.heh.petclinic.domain.BaseOwner;
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

    private BaseOwner subMap(String s) {
        BaseOwner owner = new BaseOwner();
        String[] tmp = s.split(",");
        owner.setId(Integer.parseInt(tmp[0]));
        owner.setLastname(tmp[1]);
        owner.setFirstname(tmp[2]);
        return owner;
    }
}
