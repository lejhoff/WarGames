package no.ntnu.idatg2001.krigslek.model.Units;


/**
 * The type Unit.
 */
public abstract class Unit {
    private final String name;
    private int health;
    private final int attack;
    private final int armor;
    private final String type;

    /**
     * Instantiates a new Unit.
     *
     * @param name   the name of the unit
     * @param health the health of the unit
     * @param attack the attack of the unit
     * @param armor  the armor of the unit
     * @param type   the type of the unit
     */
    protected Unit(String name, int health, int attack, int armor, String type) {
        if(!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("A unit has to have a name.");
        }
        this.health = health;
        if (attack > 0) {
            this.attack = attack;
        } else {
            throw new IllegalArgumentException("Attack must be more than 0.");
        }
        if (armor > 0) {
            this.armor = armor;
        } else {
            throw new IllegalArgumentException("Armor must be more than 0.");
        }
        this.type = type;
    }

    /**
     * Method to attack another unit.
     *
     * @param opponent the unit that is being attacked
     */
    public void attack(Unit opponent, int terrain) {
        try {
            opponent.setHealth(opponent.getHealth() - (this.attack + getAttackBonus(terrain))
                    + (opponent.getArmor() + opponent.getResistBonus(terrain)));
        } catch (IllegalArgumentException e) {
            setHealth(0);
        }
    }

    /**
     * Gets name of the unit.
     *
     * @return the name of the unit
     */
    public String getName() {
        return name;
    }

    /**
     * Gets health of the unit.
     *
     * @return the health of the unit
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets attack of the unit.
     *
     * @return the attack of the unit
     */

    public int getAttack() {
        return attack;
    }

    /**
     * Gets armor of the unit.
     *
     * @return the armor of the unit
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Gets type of unit.
     *
     * @return the type
     */
    public String getType() {return type;}

    /**
     * Sets health of the unit.
     *
     * @param health the health of the unit
     */
    public void setHealth(int health) {
        if (health >= 0) {
            this.health = health;
        } else {
            throw new IllegalArgumentException("health must be zero or greater");
        }
    }

    @Override
    public String toString() {
        return "Unit{"
                + "name='" + name + '\''
                + ", health=" + health
                + ", attack=" + attack
                + ", armor=" + armor
                + '}';
    }

    /**
     * Gets attack bonus of the unit.
     *
     * @return the attack bonus
     */
    public abstract int getAttackBonus(int terrain);

    /**
     * Gets resist bonus of the unit.
     *
     * @return the resist bonus
     */
    public abstract int getResistBonus(int terrain);
}


