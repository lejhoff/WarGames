package no.ntnu.idatg2001.krigslek.model;


import no.ntnu.idatg2001.krigslek.model.Units.Unit;

import java.util.ArrayList;
import java.util.Random;

/** The type Battle. */
public class Battle {
    private Army armyOne;
    private Army armyTwo;
    private Random random;
    /*
    * the terrain the simulation is run in.
    * 0 is no terrain
    * 1 is plains
    * 2 is forrest
    * 3 is hills
    */
    private int terrain;

    /**
     * Instantiates a new Battle.
     *
     * @param armyOne the army one
     * @param armyTwo the army two
     */
    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
        this.random = new Random();
        this.terrain = 0;
    }

    public void setTerrain(int selectedTerrain) {
        this.terrain = selectedTerrain;
    }

    /**
     * Simulate battle between two armies.
     *
     * @return the winning army
     */
    public Army simulate() {
        ArrayList<Army> armies = new ArrayList<>();
        armies.add(armyOne);
        armies.add(armyTwo);
        int randomIndex = random.nextInt(2);

        Army localArmyOne = armies.get(randomIndex);
        armies.remove(randomIndex);

        Army localArmyTwo = armies.get(0);

        Unit unitOne = localArmyOne.getRandom();
        Unit unitTwo = localArmyTwo.getRandom();

        while (unitOne != null && unitTwo != null) {
            unitOne.attack(unitTwo, terrain);

            if (unitTwo.getHealth() == 0) {
                localArmyTwo.remove(unitTwo);
                unitTwo = localArmyTwo.getRandom();
            }

            if (unitTwo != null) {
                unitTwo.attack(unitOne, terrain);
            }
            if (unitOne.getHealth() == 0) {
                localArmyOne.remove(unitOne);
                unitOne = localArmyOne.getRandom();
            }
        }
        if (unitOne == null) {
            return localArmyTwo;
        } else {
            return localArmyOne;
        }
    }

    @Override
    public String toString() {
        return "Battle{"
                + "armyOne=" + armyOne
                + ", armyTwo=" + armyTwo
                + '}';
    }
}

