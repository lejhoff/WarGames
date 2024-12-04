package no.ntnu.idatg2001.krigslek.model.Units;


/**
 * The type Ranged unit.
 */
public class RangedUnit extends Unit {
    int attackedCounter;

    /**
     * Instantiates a new Ranged unit.
     *
     * @param name the name of the unit
     * @param health the health of the unit
     * @param attack the attack of the unit
     * @param armor the armor of the unit
     */
    RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor, "Ranged");
        this.attackedCounter = 0;
    }

    /**
     * Instantiates a new Ranged unit.
     *
     * @param name the name of the unit
     * @param health the health of the unit
     */
    public RangedUnit(String name, int health) {
        super(name, health, 15, 8, "Ranged");
        this.attackedCounter = 0;
    }

    @Override
    public int getAttackBonus(int terrain) {
        if(terrain == 3) {
            return 5;
        } else if (terrain == 2) {
            return 1;
        }
        return 3;
    }

    @Override
    public int getResistBonus(int terrain) {
        int resistBonus;
        if (attackedCounter == 0) {
            resistBonus = 6;
        } else if (attackedCounter == 1) {
            resistBonus = 4;
        } else {
            resistBonus = 2;
        }
        attackedCounter++;
        return resistBonus;
    }
}
