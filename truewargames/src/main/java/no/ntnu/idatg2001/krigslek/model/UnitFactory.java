package no.ntnu.idatg2001.krigslek.model;


import no.ntnu.idatg2001.krigslek.model.Units.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Unit factory.
 */
public class UnitFactory {

    /**
     * Creates and returns one unit of selected unit type.
     *
     * @param type   the type of unit
     * @param name   the name of the unit
     * @param health the health of  the unit
     * @return the unit
     */
    public Unit createOneUnit(String type, String name, int health) {
        if (type == null || type.trim().isEmpty()) {
            return null;
        }
        return switch (type) {
            case "Infantry" -> new InfantryUnit(name, health);
            case "Ranged" -> new RangedUnit(name, health);
            case "Cavalry" -> new CavalryUnit(name, health);
            case "Commander" -> new CommanderUnit(name, health);
            default -> throw new IllegalArgumentException("Unknown unit type : " + type);
        };
    }

    /**
     * Creates a list containing many units of selected type.
     *
     * @param type          the type of unit
     * @param name          the name of the unit
     * @param health        the health of the unit
     * @param numberOfUnits the number of the units
     * @return the list
     */
    public List<Unit> createManyUnits(String type, String name, int health, int numberOfUnits) {
        int unitsAdded = 0;
        List<Unit> unitList = new ArrayList<>();

        if (type == null || type.trim().isEmpty() || numberOfUnits <= 0) {
            return Collections.emptyList();
        }
        switch (type) {
            case "Infantry" -> {
                while (unitsAdded < numberOfUnits) {
                    unitList.add(new InfantryUnit(name, health));
                    unitsAdded++;
                }
                return unitList;
            }
            case "Ranged" -> {
                while (unitsAdded < numberOfUnits) {
                    unitList.add(new RangedUnit(name, health));
                    unitsAdded++;
                }
                return unitList;
            }
            case "Cavalry" -> {
                while (unitsAdded < numberOfUnits) {
                    unitList.add(new CavalryUnit(name, health));
                    unitsAdded++;
                }
                return unitList;
            }
            case "Commander" -> {
                while (unitsAdded < numberOfUnits) {
                    unitList.add(new CommanderUnit(name, health));
                    unitsAdded++;
                }
                return unitList;
            }
            default -> throw new IllegalArgumentException("Unknown unit type : " + type);
        }
    }
}
