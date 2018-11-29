package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
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

public class OwnerComponentTests {

    Owner owner = new Owner();
    List<Owner> owners = new ArrayList<Owner>(Collections.nCopies(42,new Owner()));
    OwnerComponent ownerComponentimpl;

    @Mock
    DataSource dataSource;

    @Mock
    JdbcOwnerDao jdbcOwnerDao;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerComponentimpl = new OwnerComponentImpl(jdbcOwnerDao,dataSource);
    }

    @Test
    public void test_create_mock(){
        assertNotNull(dataSource);
        assertNotNull(jdbcOwnerDao);
        assertNotNull(ownerComponentimpl);
    }

    @Test
    public void test_findById_equal() {
        when(jdbcOwnerDao.findById(1)).thenReturn(owner);
        assertEquals(owner, ownerComponentimpl.getOwners(1));
    }

    @Test
    public void test_findById_different() {
        Owner o = new Owner();
        when(jdbcOwnerDao.findById(1)).thenReturn(owner);
        assertNotEquals(o, ownerComponentimpl.getOwners(1));
    }

    @Test
    public void test_findAll_equal() {
        when(jdbcOwnerDao.findAll()).thenReturn(owners);
        assertEquals(42, ownerComponentimpl.getOwners().size());
    }

    @Test
    public void test_findAll_different() {
        when(jdbcOwnerDao.findAll()).thenReturn(owners);
        assertNotEquals(10, ownerComponentimpl.getOwners().size());
    }
}