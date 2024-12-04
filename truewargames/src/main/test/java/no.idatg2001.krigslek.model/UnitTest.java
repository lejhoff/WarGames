package no.idatg2001.krigslek.model;


import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idatg2001.krigslek.model.Battle;
import no.ntnu.idatg2001.krigslek.model.Units.CavalryUnit;
import no.ntnu.idatg2001.krigslek.model.Units.CommanderUnit;
import no.ntnu.idatg2001.krigslek.model.Units.InfantryUnit;
import no.ntnu.idatg2001.krigslek.model.Units.RangedUnit;
import no.ntnu.idatg2001.krigslek.model.Units.Unit;
import org.junit.jupiter.api.Test;

class UnitTest {

    @Test
    void testAttack() {
        Unit unit = new InfantryUnit("Unit", 100);
        Unit opponent = new InfantryUnit("Unit", 100);

        unit.attack(opponent, 0);
        assertEquals(94, opponent.getHealth());
    }

    @Test
    void testResistBonusRanger() {
        Unit rangedUnit = new RangedUnit("RangedUnit", 100);
        Unit infantryUnit = new InfantryUnit("InfantryUnit", 100);

        infantryUnit.attack(rangedUnit, 0);
        assertEquals(97, rangedUnit.getHealth());
        infantryUnit.attack(rangedUnit, 0);
        assertEquals(92, rangedUnit.getHealth());
        infantryUnit.attack(rangedUnit, 0);
        assertEquals(85, rangedUnit.getHealth());
    }

    @Test
    void testAttackBonusCavalry() {
        Unit infantryUnit = new InfantryUnit("InfantryUnit", 100);
        Unit cavalryUnit = new CavalryUnit("CavalryUnit", 100);
        cavalryUnit.attack(infantryUnit, 0);
        assertEquals(85, infantryUnit.getHealth());
        cavalryUnit.attack(infantryUnit, 0);
        assertEquals(74, infantryUnit.getHealth());
    }

    @Test
    void testAttackBonusCommander() {
        Unit infantryUnit = new InfantryUnit("InfantryUnit", 100);
        Unit commanderUnit = new CommanderUnit("CommanderUnit", 100);
        commanderUnit.attack(infantryUnit, 0);
        assertEquals(80, infantryUnit.getHealth());
        commanderUnit.attack(infantryUnit, 0);
        assertEquals(64, infantryUnit.getHealth());
    }

    @Test
    void testNegativeHealth() {
        Unit infantryUnit = new InfantryUnit("InfantryUnit", 100);
        assertThrows(IllegalArgumentException.class, () -> infantryUnit.setHealth(-10));
    }

    @Test
    void testTerrainInfantry() {
        Unit unit1 = new InfantryUnit("Tor", 100);
        assertEquals(3,unit1.getAttackBonus(2));
        assertEquals(2, unit1.getResistBonus(2));
    }

    @Test
    void testTerrainRanged() {
        Unit unit1 = new RangedUnit("Tor", 100);
        assertEquals(1,unit1.getAttackBonus(3));
    }

    @Test
    void testTerrainCavalry() {
        Unit unit1 = new CavalryUnit("Tor", 100);
        assertEquals(11,unit1.getAttackBonus(1));
        assertEquals(0, unit1.getResistBonus(2));
    }
}
