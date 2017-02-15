package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heena.h on 13/02/17.
 */
public class Configuration {
    static List<String> commands = new ArrayList<>();

    /**
     * Initialization of the list of valid commands
     */
    public static void initializeCommands() {
        commands.add("create_parking_lot");
        commands.add("park");
        commands.add("leave");
        commands.add("status");
        commands.add("registration_numbers_for_cars_with_colour");
        commands.add("slot_numbers_for_cars_with_colour");
        commands.add("slot_number_for_registration_number");
    }

    /**
     * Check whether the given command is valid or it is present in the valid command list
     * @param commandLine : User input
     * @return
     */
    public static boolean isAValidCommand(String commandLine) {
        for(String validCommand : commands){
            if (commandLine.contains(validCommand)){
                return true;
            }
        }
        return false;
    }

    /**
     * Give the command line from User it return the command without parameters
     * @param userCommand : user given command line
     * @return : valid command
     */
    public static String getCommand(String userCommand) {
        for(String validCommand : commands){
            if (userCommand.contains(validCommand)){
                return validCommand;
            }
        }
        return "not_found";
    }
}
