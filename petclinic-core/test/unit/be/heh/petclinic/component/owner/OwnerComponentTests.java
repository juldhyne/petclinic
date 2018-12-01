package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OwnerComponentTests {

    private static final int n = 42;
    private static final Owner owner = new Owner();
    private static final Owner[] owners = new Owner[n];
    private static OwnerComponent ownerComponentimpl;

    @Mock
    DataSource dataSource;

    @Mock
    JdbcOwnerDao jdbcOwnerDao;


    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        ownerComponentimpl = new OwnerComponentImpl(jdbcOwnerDao, dataSource);
    }

    @Test
    void test_create_mock() {
        assertNotNull(dataSource);
        assertNotNull(jdbcOwnerDao);
        assertNotNull(ownerComponentimpl);
    }

    @Test
    void test_findById_equal() {
        when(jdbcOwnerDao.findById(1)).thenReturn(owner);
        assertEquals(owner, ownerComponentimpl.getOwners(1));
    }

    @Test
    void test_findById_different() {
        Owner o = new Owner();
        when(jdbcOwnerDao.findById(1)).thenReturn(owner);
        assertNotEquals(o, ownerComponentimpl.getOwners(1));
    }

    @Test
    void test_findAll_equal() {
        when(jdbcOwnerDao.findAll()).thenReturn(owners);
        assertEquals(n, ownerComponentimpl.getOwners().length);
    }

    @Test
    void test_findAll_different() {
        when(jdbcOwnerDao.findAll()).thenReturn(owners);
        assertNotEquals(10, ownerComponentimpl.getOwners().length);
    }
}