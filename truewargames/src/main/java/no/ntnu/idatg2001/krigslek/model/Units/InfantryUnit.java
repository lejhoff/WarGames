package no.ntnu.idatg2001.krigslek.model.Units;


/** The type Infantry unit. */
public class InfantryUnit extends Unit {

    /**
     * Instantiates a new Infantry unit.
     *
     * @param name the name of the unit
     * @param health the health of the unit
     * @param attack the attack of the unit
     * @param armor the armor of the unit
     * @param type the type of unit
     */
    public InfantryUnit(String name, int health, int attack, int armor, int type) {
        super(name, health, attack, armor, "Infantry");
    }

    /**
     * Instantiates a new Infantry unit.
     *
     * @param name the name of the unit
     * @param health the health of the unit
     */
    public InfantryUnit(String name, int health) {
        super(name, health, 15 , 10, "Infantry");

    }

    @Override
    public int getAttackBonus(int terrain) {
        if (terrain == 2) {
            return 3;
        }
        return 2;
    }

    @Override
    public int getResistBonus(int terrain) {
        if (terrain == 2) {
            return 2;
        }
        return 1;
    }
}

