package test.java;

import main.java.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by heena.h on 13/02/17.
 */
public class TestConfiguration {

//    @BeforeClass
//    public static void beforeClass() {
//        Configuration.initializeCommands();
//    }

    @Test
    public void testInitializeCommands() {
        assertTrue(Configuration.commands.size() == 0);
        Configuration.initializeCommands();
        assertTrue(Configuration.commands.size() > 0);
    }

    @Test
    public void testIsAValidCommand() {
        if (Configuration.commands.size() == 0) {
            Configuration.initializeCommands();
        }
        String command = "create_parking_lot";
        Boolean result = Configuration.isAValidCommand(command);
        assertTrue(result);
        command = "bla_bla";
        result = Configuration.isAValidCommand(command);
        assertFalse(result);
    }

    @Test
    public void testGetCommand() {
        if (Configuration.commands.size() == 0) {
            Configuration.initializeCommands();
        }
        String userCommandLine = "create_parking_lot 6";
        String validCommand = Configuration.getCommand(userCommandLine);
        assertEquals("create_parking_lot", validCommand);
    }
}
