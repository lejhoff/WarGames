package no.ntnu.idatg2001.krigslek.model;


import no.ntnu.idatg2001.krigslek.model.Units.Unit;

import java.util.List;

/**
 * A class holding all the components used within the program.
 */
public class Facade {
    private static Facade instance;
    private static Army army;
    private String tempArmyName;
    private ArmyFileHandler fileHandler;
    private UnitFactory unitFactory;
    private Army armyOne;
    private Army armyTwo;
    private Battle battle;
    private int selectedTerrain;
    private Facade() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Facade getInstance() {
        if(instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    /**
     * Create army.
     *
     * @param name      the name of the army
     * @param inputList the list containing the units in the army
     */
    public void createArmy(String name, List<Unit> inputList) {
        army = new Army(name, inputList);
    }

    /**
     * Sets a temporary army name.
     *
     * @param tempArmyName the temporary army name
     */
    public void setTempArmyName(String tempArmyName) {this.tempArmyName = tempArmyName;}

    /**
     * Gets temporary army name.
     *
     * @return the temp army name
     */
    public String getTempArmyName () {
        return tempArmyName;
    }

    /**
     * Gets army.
     *
     * @return the army
     */
    public Army getArmy() {return army;}

    /**
     * Creates a file handler if one does not exist and returns it.
     *
     * @return the file handler
     */
    public ArmyFileHandler getFileHandler() {
        if (fileHandler == null) {
            fileHandler = new ArmyFileHandler();
        }
        return fileHandler;
    }

    /**
     * Creates a unit factory if one does not exist and returns it.
     *
     * @return the unit factory
     */
    public UnitFactory getUnitFactory() {
        if (unitFactory == null) {
            unitFactory = new UnitFactory();
        }
        return unitFactory;
    }

    /**
     * Resets the army that has been created.
     */
    public static void resetArmy() {
        army = null;
    }

    /**
     * Sets armyOne to be the same as the received army and returns true.
     *
     * @param army the army
     * @return the boolean
     */
    public boolean armyOneExists(Army army) {
        this.armyOne = army;
        return true;
    }

    /**
     * Gets the Army armyOne.
     *
     * @return armyOne
     */
    public Army getArmyOne() {
        return armyOne;
    }

    /**
     * Sets armyTwo to be the same as the received army and returns true.
     *
     * @param army the army
     * @return the boolean
     */
    public boolean armyTwoExists(Army army) {
        this.armyTwo = army;
        return true;
    }

    /**
     * Gets the Army armyTwo.
     *
     * @return armyTwo
     */
    public Army getArmyTwo() {
        return armyTwo;
    }

    /**
     * Run the battle simulation between two armies.
     *
     * @return the string containing the name of the winning army
     */
    public String runSimulation(int selectedTerrain) {
        battle = new Battle(armyOne, armyTwo);
        battle.setTerrain(selectedTerrain);
        String winner = battle.simulate().getName();
        battle = null;
        return winner;
    }
}
