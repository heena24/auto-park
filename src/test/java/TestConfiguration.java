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

    @BeforeClass
    public static void beforeClass() {
        Configuration.initializeCommands();
    }

    @Test
    public void testIsAValidCommand() {
        String command = "create_parking_lot";
        Boolean result = Configuration.isAValidCommand(command);
        assertTrue(result);
        command = "bla_bla";
        result = Configuration.isAValidCommand(command);
        assertFalse(result);
    }

    @Test
    public void testGetCommand() {
        String userCommandLine = "create_parking_lot 6";
        String validCommand = Configuration.getCommand(userCommandLine);
        assertEquals("create_parking_lot", validCommand);
        userCommandLine = "bla_bla 6";
        validCommand = Configuration.getCommand(userCommandLine);
        assertEquals("not_found", validCommand);
    }
}
