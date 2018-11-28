package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OwnerComponentTests {

    @Mock
    JdbcOwner jdbcOwner;


    OwnerComponentImpl ownerComponentImpl;


    @BeforeEach
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_creation_mock(){
        assertNotNull(jdbcOwner);
//        assertNotNull(ownerComponentImpl);
    }

//    @Test
//    public void test_findById() {
//        Owner owner = new Owner();
//
//        owner.setId(1);
//        owner.setFirstname("Franklin");
//        owner.setLastname("George");
//        owner.setCity("110 W. Liberty St.");
//        owner.setAddress("Madison");
//        owner.setTelephone("6085551023");
//        owner.setPetsNames(new String[]{"Leo","Samantha","Max","Sly"});
//
//
//        when(jdbcOwner.findById(1)).thenReturn(owner);
//        assertEquals(owner, ownerComponentImpl.getOwners(1));
//    }


}