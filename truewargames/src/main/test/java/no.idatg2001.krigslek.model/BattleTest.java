package no.idatg2001.krigslek.model;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

import no.ntnu.idatg2001.krigslek.model.*;
import no.ntnu.idatg2001.krigslek.model.Units.InfantryUnit;
import no.ntnu.idatg2001.krigslek.model.Units.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleTest {
    Army armyOne;
    Army armyTwo;
    Army armyOne1;
    Army armyTwo2;
    Unit unit1;
    Unit unit2;
    UnitFactory unitFactory;

    /*
     *  Change the parameters of the createArmy method to see
     *  the results of the testFairness method change.
     *  This may change the validity of the simulateTest method.
     */
    @BeforeEach
    void createArmy() {
        unitFactory = new UnitFactory();
        armyOne = new Army("The Norwegian Army");
        armyOne.add(unitFactory.createOneUnit("Commander", "Harald", 200));
        armyOne.addAll(unitFactory.createManyUnits("Infantry", "Swordsman", 100, 200));


        armyTwo = new Army("The Swedish Army");
        armyTwo.add(unitFactory.createOneUnit("Commander", "Knugen", 200));
        armyTwo.addAll(unitFactory.createManyUnits("Infantry", "Swordsman", 100, 500));

    }

    @Test
    void simulateTest() {
        Battle battle = new Battle(armyOne, armyTwo);

        Army winner = battle.simulate();

        assertEquals(armyTwo, winner);
    }

    @Test
    void testFairness() {
        int index = 0;

        ArrayList<Army> statsOne = new ArrayList<>();
        ArrayList<Army> statTwo = new ArrayList<>();

        while(index < 1000) {
            createArmy();
            Battle battle = new Battle(armyOne, armyTwo);
            battle.simulate();
            if(battle.simulate() == armyOne) {
                statsOne.add(armyOne);
            } else {
                statTwo.add(armyTwo);
            }

            index++;

        }
        System.out.println("ArmyOne wins: " + statsOne.size());
        System.out.println("ArmyTwo wins: " + statTwo.size());

    }
}