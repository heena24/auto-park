package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heena.h on 13/02/17.
 */
public class Parking {
    public static List<Slot> slotList = new ArrayList<>();

    public static int getSlotListSize() {
        return slotList.size();
    }

    public static Slot getSlot(int index) {
        return slotList.get(index);
    }

    public static void resetSlotList() {
        Parking.slotList = new ArrayList<>();
    }

    /**
     * Method to initialize parking slot for the requested count
     * @param slotCount
     */
    public static void initializeParking(int slotCount) {
        for (int i=1; i<=slotCount; i++) {
            slotList.add(new Slot(i,true));
        }
        System.out.println("Created a parking lot with " + slotCount + " slots.");
    }

    /**
     * Method to free the slot
     * @param slotNumber
     */
    public static void freeThisSlot(int slotNumber){
        for(Slot slot : slotList) {
            if (slot.getSlotNumber() == slotNumber) {
                slot.setAvailability(true);
                slot.setTicket(null);
                System.out.println("Slot number " + slotNumber+ " is free");
                break;
            }
        }
    }

    /**
     * Method to fetch the next available slot
     * @return
     */
    public static Slot getAvailableSlot(){
        for(Slot slot : slotList) {
            if(slot.getAvailability()) {
                return slot;
            }
        }

        return null;
    }

    /**
     * Method to print the status of the initialized slots
     */
    public static void getCurrentStatus() {
        System.out.println("Slot No.            Registration No.             Colour");
        System.out.println("-------------------------------------------------------");
        for (Slot slot : slotList) {
            if(!slot.getAvailability()) {
                System.out.print(slot.getSlotNumber() + "                   " + slot.getTicket().carRegistrationNumber);
                System.out.println("                " + slot.getTicket().carColour);
            }
        }
    }

    /**
     * Method to query Car registration numbers for the given colour car
     * @param colour
     * @return
     */
    public static String getCarRegistrationNumbersForTheGivenColour(String colour) {
        String response = "";
        for(Slot slot : slotList) {
            if (slot.getTicket() != null && slot.getTicket().carColour.equalsIgnoreCase(colour)) {
                response += slot.getTicket().carRegistrationNumber + ",";
            }
        }
        return response;
    }

    /**
     * Method to query Slot numbers of the car for the given colour
     * @param colour
     * @return
     */
    public static String getSlotNumbersForCarsWithColour(String colour) {
        String response = "";
        for(Slot slot : slotList) {
            if (slot.getTicket() != null && slot.getTicket().carColour.equalsIgnoreCase(colour)) {
                response += slot.getSlotNumber() + ",";
            }
        }
        return response;
    }

    /**
     * Method to query Slot number of the car for the given registration number
     * @param registrationNumber
     * @return
     */
    public static int getSlotNumberForRegistrationNumber(String registrationNumber) {
        for(Slot slot : slotList) {
            if (slot.getTicket() != null && slot.getTicket().carRegistrationNumber.equalsIgnoreCase(registrationNumber)) {
                return slot.getSlotNumber();
            }
        }

        return -1;
    }
}
