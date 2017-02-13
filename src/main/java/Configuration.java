package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heena.h on 13/02/17.
 */
public class Configuration {
    static List<String> commands = new ArrayList<>();

    public static void initializeCommands() {
        commands.add("create_parking_lot");
        commands.add("park");
        commands.add("leave");
        commands.add("status");
        commands.add("registration_numbers_for_cars_with_colour");
        commands.add("slot_numbers_for_cars_with_colour");
        commands.add("slot_number_for_registration_number");
    }

    public static boolean isAValidCommand(String command) {
        for(String validCommand : commands){
            if (command.contains(validCommand)){
                return true;
            }
        }
        return false;
    }

    public static String getCommand(String userCommand) {
        for(String validCommand : commands){
            if (userCommand.contains(validCommand)){
                return validCommand;
            }
        }
        return "not_found";
    }
}
