package no.ntnu.idatg2001.krigslek.model.Units;


/** The type Cavalry unit. */
public class CavalryUnit extends Unit {
    int attackCounter;

    /**
     * Instantiates a new Cavalry unit.
     *
     * @param name the name of the unit
     * @param health the health of the unit
     * @param attack the attack of the unit
     * @param armour the armour of the unit
     * @param type the type of unit
     */
    public CavalryUnit(String name, int health, int attack, int armour, String type) {
        super(name, health, attack, armour, type);
        this.attackCounter = 0;
    }

    /**
     * Instantiates a new Cavalry unit.
     *
     * @param name the name of the unit
     * @param health the health of the unit
     */
    public CavalryUnit(String name, int health) {
        super(name, health, 20, 12, "Cavalry");
        this.attackCounter = 0;
    }

    @Override
    public int getAttackBonus(int terrain) {
        int attackBonus;
        if (attackCounter == 0) {
            attackBonus = 6;
        } else {
            attackBonus = 2;
        }
        if (terrain == 1) {
            attackBonus += 5;
        }
        attackCounter++;
        return attackBonus;
    }

    @Override
    public int getResistBonus(int terrain) {
        if (terrain == 2) {
            return 0;
        }
        return 1;
    }
}
