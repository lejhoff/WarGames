package no.idatg2001.krigslek.model;


import static org.junit.jupiter.api.Assertions.*;
import no.ntnu.idatg2001.krigslek.model.*;
import no.ntnu.idatg2001.krigslek.model.Units.InfantryUnit;
import no.ntnu.idatg2001.krigslek.model.Units.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArmyTest {
private UnitFactory unitFactory;
private Army units;

    @BeforeEach
    void setup() {
        unitFactory = new UnitFactory();
        units = new Army("armyOne");
    }

    @Test
    void testAddUnitAndHasUnits() {
        assertNotEquals(true, units.hasUnits());
        units.add(unitFactory.createOneUnit("Infantry", "Tor", 100));
        assertTrue(units.hasUnits());
    }

    @Test
    void testAddAll() {
        units.addAll(unitFactory.createManyUnits("Infantry", "Swordsman", 100, 3));

        assertEquals(3, units.size());
    }

    @Test
    void testRemove() {
        Unit infantryUnit = new InfantryUnit("InfantryUnit", 100);
        units.add(infantryUnit);
        assertEquals(1, units.size());
        units.remove(infantryUnit);
        assertEquals(0, units.size());
    }

    @Test
    void testGetRandom() {
        assertNull(units.getRandom());
        units.add(unitFactory.createOneUnit("Infantry", "Swordsman", 100));
        assertNotNull(units.getRandom());
    }

    @Test
    void testGetInfantryUnit() {
        units.addAll(unitFactory.createManyUnits("Infantry", "Swordsman", 100, 3));
        units.add(unitFactory.createOneUnit("Ranged", "Ranger", 100));

        assertEquals(3, units.getInfantryUnit().size());
    }

    @Test
    void testGetRangedUnit() {
        units.addAll(unitFactory.createManyUnits("Ranged", "Ranger", 100, 3));
        units.add(unitFactory.createOneUnit("Infantry", "Swordsman", 100));

        assertEquals(3, units.getRangedUnit().size());
    }

    @Test
    void testGetCavalryUnit() {
        units.addAll(unitFactory.createManyUnits("Cavalry", "Mounted lance", 100, 3));
        units.add(unitFactory.createOneUnit("Infantry", "Swordsman", 100));

        assertEquals(3, units.getCavalryUnit().size());
    }

    @Test
    void testGetCommanderUnit() {
        units.addAll(unitFactory.createManyUnits("Infantry", "Kings guard", 500, 3));
        units.add(unitFactory.createOneUnit("Commander", "Kong Harald", 10));

        assertEquals(1, units.getCommanderUnit().size());
    }
}