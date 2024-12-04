package no.idatg2001.krigslek.model;


import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import no.ntnu.idatg2001.krigslek.model.*;
import no.ntnu.idatg2001.krigslek.model.Units.CommanderUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArmyFileHandlerTest {
    private Army army;
    private ArmyFileHandler fileHandler;

    @BeforeEach
    void setUp() {
        army = new Army("TheNorwegianInfantry");
        army.add(new CommanderUnit("Harald", 100));
        fileHandler = new ArmyFileHandler();
    }

    @Test
    void testSaveArmy() {
        try {
            String path = fileHandler.saveArmy(army);
            System.out.println("File written in " + path);
            return;
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    void testLoadArmy() {
        File saveDir = new File(System.getProperty("user.home"), ".warGames/savedArmies/TheNorwegianInfantry.csv");
        Army readArmy = fileHandler.loadArmy(saveDir);
        assertEquals(1, readArmy.getAllUnits().size());
    }
}