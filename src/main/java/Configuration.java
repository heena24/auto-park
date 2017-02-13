package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heena.h on 13/02/17.
 */
public class Configuration {
    public static List<String> commands = new ArrayList<>();
//    static Map<Integer,Boolean> slotMap = new HashMap<>();

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
        return false;
    }

    public static String getCommand(String userCommand) {
        return "not_found";
    }
}
