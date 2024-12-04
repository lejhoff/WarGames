package no.ntnu.idatg2001.krigslek.model.Units;


/** The type Commander unit. */
public class CommanderUnit extends CavalryUnit {

    /**
     * Instantiates a new Commander unit.
     *
     * @param name the name of the unit
     * @param health the health of the unit
     * @param attack the attack of the unit
     * @param armor the armor of the unit
     */
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor, "Commander");
    }

    /**
     * Instantiates a new Commander unit.
     *
     * @param name the name of the unit
     * @param health the health of the unit
     */
    public CommanderUnit(String name, int health) {
        super(name, health, 25, 12, "Commander");

    }
}
