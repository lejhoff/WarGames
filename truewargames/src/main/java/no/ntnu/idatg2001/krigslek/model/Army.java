package no.ntnu.idatg2001.krigslek.model;


import no.ntnu.idatg2001.krigslek.model.Units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * The type Army.
 */
public class Army {
    private String name;
    private List<Unit> units;
    private final Random rand;

    /**
     * Instantiates a new Army from a name.
     *
     * @param name the name of the army
     */
    public Army(String name) {
        this.name = name;
        this.units = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Instantiates a new Army from a name and a list of units.
     *
     * @param name  the name of the army
     * @param units the list of units the army contains
     */
    public Army(String name, List<Unit> units) {
        this.name = name;
        this.units = units;
        rand = new Random();
    }

    /**
     * Gets name of the army.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds unit to the army.
     *
     * @param unit the unit that is added to the army
     */
    public void add(Unit unit) {
        units.add(unit);
    }

    /**
     * Add all units from inputList to army.
     *
     * @param inputList the input list containing units
     */
    public void addAll(List<Unit> inputList) {
        units.addAll(inputList);
    }

    /**
     * Remove unit from army.
     *
     * @param unit the unit that is removed
     */
    public void remove(Unit unit) {
        units.remove(unit);
    }

    /**
     * Checks if the army has units.
     *
     * @return the boolean representing if the list of units is empty or not.
     */
    public boolean hasUnits() {
        return !units.isEmpty();
    }

    /**
     * returns a List of all the units contained within the army.
     *
     * @return the all units
     */
    public List<Unit> getAllUnits() {
        return units;
    }

    /**
     * Gets random unit from the army.
     *
     * @return the random unit
     */
    public Unit getRandom() {
        if (units.isEmpty()) {
            return null;
        } else {
            return units.get(rand.nextInt(units.size()));
        }
    }

    /**
     * Gets infantry units contained within the army.
     *
     * @return the infantry unit as a list
     */
    public List<Unit> getInfantryUnit() {
        return units.stream().filter(unit -> unit.getClass() == InfantryUnit.class).collect(Collectors.toList());
        //return units.stream().filter(unit -> unit.getClass() == InfantryUnit.class).toList();
    }

    /**
     * Gets all ranged units contained within an army.
     *
     * @return all the ranged units as a list
     */
    public List<Unit> getRangedUnit() {
        return units.stream().filter(unit -> unit.getClass() == RangedUnit.class).collect(Collectors.toList());
    }

    /**
     * Gets all the cavalry units contained within the army.
     *
     * @return all the cavalry units as a list
     */
    public List<Unit> getCavalryUnit() {
        return units.stream().filter(unit -> unit.getClass() == CavalryUnit.class).collect(Collectors.toList());
    }

    /**
     * Gets all the commander unit contained within the army.
     *
     * @return the commander units as a list
     */
    public List<Unit> getCommanderUnit() {
        return units.stream().filter(unit -> unit.getClass() == CommanderUnit.class).collect(Collectors.toList());
    }

    /**
     * Gets the number of units contained within the army.
     *
     * @return the number of units as an int
     */
    public int size() {
        return units.size();
    }

    @Override
    public String toString() {
        return "Army{"
                + "name='" + name + '\''
                + ", units=" + units
                +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }

}
