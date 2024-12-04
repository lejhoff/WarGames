package no.ntnu.idatg2001.krigslek.model;


import no.ntnu.idatg2001.krigslek.model.Units.Unit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Army file handler.
 */
public class ArmyFileHandler {
    UnitFactory unitFactory;
    private static final String CSV_SEPARATOR = ",";

    /**
     * Save army as a CSV file in a predetermined location.
     *
     * @param army the army to be saved
     * @return the path of the saved file as a String
     * @throws FileNotFoundException the file not found exception
     */
    public String saveArmy(Army army) throws FileNotFoundException {
        String armyName = army.getName();
        File saveDir = new File(System.getProperty("user.home"), ".warGames/savedArmies");
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }
        File csvFile = new File(saveDir.getPath() + "/" + armyName + ".csv");
        PrintWriter out = new PrintWriter(csvFile);
        List<Unit> units = army.getAllUnits();

        //prints the first line of the csv file
        out.println(armyName);

        //Writes all the units parameters in csv file
        for (Unit currentUnit : units) {
            out.println(currentUnit.getClass().toString().split("Units.")[1] + CSV_SEPARATOR +
                    currentUnit.getName() + CSV_SEPARATOR + currentUnit.getHealth());
        }
        out.close();
        return csvFile.getPath();
    }

    /**
     * Creates an army with name and units from a CSV file.
     *
     * @param file the file the army will be created from
     * @return the army that that was created form file
     */
    public Army loadArmy(File file) {
        unitFactory = Facade.getInstance().getUnitFactory();
        BufferedReader reader = null;
        Army loadedArmy = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String name = reader.readLine();
            List<Unit> unitsToAdd = new ArrayList<>();
            String lineOfText;
            while ((lineOfText = reader.readLine()) != null) {
                String[] words = lineOfText.split(CSV_SEPARATOR);
                switch (words[0]) {
                    case "InfantryUnit":
                        unitsToAdd.add(unitFactory.createOneUnit("Infantry",words[1].strip(),Integer.parseInt(words[2].strip())));
                        break;
                    case "RangedUnit":
                        unitsToAdd.add(unitFactory.createOneUnit("Ranged",words[1].strip(),Integer.parseInt(words[2].strip())));
                        break;
                    case "CavalryUnit":
                       // unitsToAdd.add(new CavalryUnit(words[1].strip(), Integer.parseInt(words[2].strip())));
                        unitsToAdd.add(unitFactory.createOneUnit("Cavalry",words[1].strip(),Integer.parseInt(words[2].strip())));
                        break;
                    case "CommanderUnit":
                        unitsToAdd.add(unitFactory.createOneUnit("Commander",words[1].strip(),Integer.parseInt(words[2].strip())));
                        break;
                }
            }
            loadedArmy = new Army(name, unitsToAdd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedArmy;
    }
}