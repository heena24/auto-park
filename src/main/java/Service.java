package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by heena.h on 13/02/17.
 */
public class Service {
    public static void main(String[] args) throws IOException {
        Configuration.initializeCommands();
        if (args != null && args.length > 0) {
            System.out.println("File mode : ");
            // file mode  : full path of the file needs to be provided
           fileMode(args[0]);
        } else {
            // interactive mode
            interactiveMode();
        }

    }

    /**
     * Method to filter command based on the parameter list
     * @param command : command provided by User
     * @param params : params separated from command line provide by user
     */
    public static void executeCommand(String command, String params){
        if(!command.equals("park") && !command.equals("status")) {
            uniiParam(command,params);
        } else if (command.equals("park")){
            multiParam(params);
        } else if (command.equals("status")) {
            Parking.getCurrentStatus();
        } else {
            System.out.println("Incorrect command line : " + command + " " + params);
        }
    }

    /**
     * Method to execute command with multi param
     * @param params
     */
    public static void multiParam(String params) {
        String carNumber = params.substring(0,params.indexOf(" "));
        String carColour = params.substring(params.indexOf(" "));
        // check availability of slot
        Slot slot = Parking.getAvailableSlot();
        if (slot != null) {
            slot.setAvailability(false);
            // create ticket for that slot
            slot.ticket = new Ticket(carNumber.trim(),carColour.trim());
            System.out.println("Allocated slot number: : " + slot.slotNumber);
        } else {
            System.out.println("Sorry, parking lot is full.");
        }
    }

    /**
     * Method to execute command with one param
     * @param command
     * @param param
     */
    public static void uniiParam(String command, String param) {
        if (command.equals("create_parking_lot")) {
            Parking.initializeParking(Integer.parseInt(param.trim()));
        } else if (command.equals("leave")){
            Parking.freeThisSlot(Integer.parseInt(param.trim()));
        } else if (command.equals("registration_numbers_for_cars_with_colour")) {
            printResponse(Parking.getCarRegistrationNumbersForTheGivenColour(param.trim()));
        } else if (command.equals("slot_numbers_for_cars_with_colour")) {
            printResponse(Parking.getSlotNumbersForCarsWithColour(param.trim()));
        } else if (command.equals("slot_number_for_registration_number")) {
            printResponse(Parking.getSlotNumberForRegistrationNumber(param.trim()));
        }
    }

    public static void printResponse(String response) {
        if (response.equals("")) {
            System.out.println("Not found.");
        } else {
            System.out.println(response);
        }
    }

    public static void printResponse(int response) {
        if (response != -1) {
            System.out.println(response);
        } else {
            System.out.println("Not found.");
        }
    }

    /**
     * Method to perform interactive mode exexcution
     */
    public static void interactiveMode() {
        System.out.println("Interactive mode, please enter your command : ");
        Scanner scanner = new Scanner(System.in);
        String commandLine = scanner.nextLine();
        while (Configuration.isAValidCommand(commandLine)){
            String command = Configuration.getCommand(commandLine);
            if (commandLine.contains(" ")) {
                executeCommand(command.trim(), commandLine.substring(commandLine.indexOf(" ")+1));
            } else {
                executeCommand(command, "");
            }
            // Read next instruction
            commandLine = scanner.nextLine();
        }
        System.out.println("Exiting, incorrect command : " + commandLine);
    }

    /**
     * Method to perform file mode execution for the given file path
     * @param arg : commands file path
     */
    public static void fileMode(String arg) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arg));
            String line;
            while ((line = reader.readLine()) != null)
            {
                if(Configuration.isAValidCommand(line)){
                    System.out.println(line);
                    String command = Configuration.getCommand(line);
                    if (line.contains(" ")) {
                        executeCommand(command.trim(), line.substring(line.indexOf(" ")+1));
                    } else {
                        executeCommand(command.trim(), "");
                    }
                } else {
                    System.out.println("Incorrect command : " + line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.format("Exception occurred while trying to read file '%s'.", arg);
        }
    }

}
