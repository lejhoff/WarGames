package no.idatg2001.krigslek.model;


import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import no.ntnu.idatg2001.krigslek.model.Units.Unit;
import no.ntnu.idatg2001.krigslek.model.UnitFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitFactoryTest {
    private UnitFactory unitFactory;

    @BeforeEach
    void setUp() {
        unitFactory = new UnitFactory();
    }

    @Test
    void testCreateOneUnitNegative() {
        assertThrows(IllegalArgumentException.class, () -> unitFactory.createOneUnit("Gobbledygook", "Swordsman", 100));
    }

    @Test
    void testCreateOneUnit() {
        Unit unit = unitFactory.createOneUnit("Infantry", "Swordsman", 100);
        assertNotNull(unit);
    }

    @Test
    void testCreateManyUnits() {
        List<Unit> list = unitFactory.createManyUnits("Ranged", "Ranger", 100, 10);
        assertNotNull(list);
    }

    @Test
    void testSizeCreateManyUnits() {
        List<Unit> list = unitFactory.createManyUnits("Cavalry", "Mounted lance", 100, 10);
        assertEquals(10,list.size());
    }

    @Test
    void testCreateNegativeNumberOfUnits() {
        List<Unit> list = unitFactory.createManyUnits("Commander", "King", 100, -10);
        assertEquals(0,list.size());
    }
}