package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class PetComponentTests {

    Pet pet = new Pet();
    List<Pet> owners = new ArrayList<Pet>(Collections.nCopies(42,new Pet()));

    PetComponent petComponentImpl;

    @Mock
    DataSource dataSource;

    @Mock
    JdbcPetDao jdbcPetDao;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petComponentImpl = new PetComponentImpl(jdbcPetDao,dataSource);
    }

    @Test
    public void test_create_mock(){
        assertNotNull(dataSource);
        assertNotNull(jdbcPetDao);
        assertNotNull(petComponentImpl);
    }

    @Test
    public void test_findById_equal() {
        when(jdbcPetDao.findById(1)).thenReturn(pet);
        assertEquals(pet, petComponentImpl.getPets(1));
    }

    @Test
    public void test_findById_different() {
        Pet p = new Pet();
        when(jdbcPetDao.findById(1)).thenReturn(pet);
        assertNotEquals(p, petComponentImpl.getPets(1));
    }

}