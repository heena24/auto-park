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
            System.out.println("File mode");
            // file mode
            // get file from local
            try {
                BufferedReader reader = new BufferedReader(new FileReader(args[0]));
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
                System.err.format("Exception occurred trying to read '%s'.", args[0]);
            }

        } else {
            // interactive mode
            System.out.println("Interactive mode");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();
            while (Configuration.isAValidCommand(command)){
                // execute command
                System.out.println(command);
                String commondNew = Configuration.getCommand(command);
                if (command.contains(" ")) {
                    executeCommand(commondNew.trim(), command.substring(command.indexOf(" ")+1));
                } else {
                    executeCommand(commondNew, "");
                }
                // Read next instruction
                command = scanner.next();
            }
            System.out.println("Incorrect command : " + command);
        }

    }

    public static void executeCommand(String commmand, String params){
        if(!commmand.equals("park") && !commmand.equals("status")) {
            if (commmand.equals("create_parking_lot")) {
                Parking.initializeParking(Integer.parseInt(params.trim()));
            } else if (commmand.equals("leave")){
                Parking.freeThisSlot(Integer.parseInt(params.trim()));
            } else if (commmand.equals("registration_numbers_for_cars_with_colour")) {
                String responseStr = Parking.getCarRegistrationNumbersForTheGivenColour(params.trim());
                if (responseStr.equals("")) {
                    System.out.println("Not found.");
                } else {
                    System.out.println(responseStr);
                }
            } else if (commmand.equals("slot_numbers_for_cars_with_colour")) {
                String responseStr = Parking.getSlotNumbersForCarsWithColour(params.trim());
                if (responseStr.equals("")) {
                    System.out.println("Not found.");
                } else {
                    System.out.println(responseStr);
                }
            } else if (commmand.equals("slot_number_for_registration_number")) {
                int response = Parking.getSlotNumberForRegistrationNumber(params.trim());
                if (response != -1) {
                    System.out.println(response);
                } else {
                    System.out.println("Not found.");
                }
            }
        } else if (commmand.equals("park")){
            String carNumber = params.substring(0,params.indexOf(" "));
            String carColour = params.substring(params.indexOf(" "));
            // check availability of slot
            Slot slot = Parking.getAvailableSlot();
            if (slot != null) {
                slot.setAvailability(false);
                // create ticket for that slot
                slot.ticket = new Ticket(carNumber.trim(),carColour.trim());
                // Update parking with the updated slot
                Parking.addUpdatedSlot(slot);
                System.out.println("Allocated slot number: : " + slot.slotNumber);
            } else {
                System.out.println("Sorry, parking lot is full.");
            }

        } else if (commmand.equals("status")) {
            Parking.getCurrentStatus();
        }
    }


}
