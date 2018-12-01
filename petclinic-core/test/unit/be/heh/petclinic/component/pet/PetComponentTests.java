package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PetComponentTests {
    private static final int n = 42;

    private static final Pet[] pets = new Pet[n];

    private static final String[] types = new String[]{"cat", "dog", "bird"};

    private static final int[] ownerIds = new int[]{0, 1, 2, 3, 5, 6, 7, 8, 9};
    @Mock
    DataSource dataSource;
    @Mock
    JdbcPetDao jdbcPetDao;
    private PetComponent petComponentImpl;

    @BeforeAll
    static void setupClass() {
        for (int i = 0; i < n; i++) {
            Pet p = new Pet();
            p.setId(i);
            p.setType(types[new Random().nextInt(types.length)]);
            p.setOwnerId(ownerIds[new Random().nextInt(ownerIds.length)]);
            pets[i] = p;
        }
    }

    @BeforeEach
    void setupTest() {
        MockitoAnnotations.initMocks(this);
        petComponentImpl = new PetComponentImpl(jdbcPetDao, dataSource);
    }

    @Test
    @DisplayName("Mock initilization")
    void test_create_mock() {
        assertNotNull(dataSource);
        assertNotNull(jdbcPetDao);
        assertNotNull(petComponentImpl);
    }

    @Test
    @DisplayName("Test findAll method")
    void testFindAll() {
        when(jdbcPetDao.findAll()).thenReturn(pets);
        assertArrayEquals(pets, petComponentImpl.getPets());
    }

    @TestFactory
    @DisplayName("Test findById method")
    Stream<DynamicTest> testFindById() {
        return DynamicTest.stream(
                IntStream.range(0, n).iterator(),
                id -> String.format("Test - Pet #%s", id),
                id -> {
                    Pet p = Arrays.stream(pets).filter(pet -> pet.getId() == id).findAny().get();
                    when(jdbcPetDao.findById(id)).thenReturn(p);
                    assertEquals((int) id, petComponentImpl.getPets(id).getId());
                }
        );
    }

    @TestFactory
    @DisplayName("Test findByType method")
    Stream<DynamicTest> testFindByType() {
        return DynamicTest.stream(
                Arrays.stream(types).iterator(),
                type -> String.format("Test - Pet's type %s", type),
                type -> {
                    Pet[] filteredPets = Arrays.stream(pets).filter(pet -> pet.getType().equals(type)).toArray(Pet[]::new);
                    when(jdbcPetDao.findByType(type)).thenReturn(filteredPets);
                    assertSame(filteredPets, petComponentImpl.getPets(type));
                }
        );
    }

    @TestFactory
    @DisplayName("Test findByOwnerId method")
    Stream<DynamicTest> testFindByOwnerId() {
        return DynamicTest.stream(
                Arrays.stream(ownerIds).iterator(),
                oid -> String.format("Test - Pet's owner id #%s", oid),
                oid -> {
                    Pet[] filteredPets = Arrays.stream(pets).filter(pet -> pet.getOwnerId() == oid).toArray(Pet[]::new);
                    when(jdbcPetDao.findByOwnerId(oid)).thenReturn(filteredPets);
                    assertSame(filteredPets, petComponentImpl.getPetsByOwnerId(oid));
                }
        );
    }
}