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

    //commond : create_parking_lot
    public static void initializeParking(int slotCount) {
        for (int i=1; i<=slotCount; i++) {
            slotList.add(new Slot(i,true));
        }
        System.out.println("Created a parking lot with " + slotCount + " slots.");
    }

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

    public static Slot getAvailableSlot(){
        for(Slot slot : slotList) {
            if(slot.getAvailability()) {
                return slot;
            }
        }

        return null;
    }

    public static void addUpdatedSlot(Slot newSlot) {
        for (Slot slot : slotList) {
            if(slot.getSlotNumber() == newSlot.slotNumber){
                slotList.remove(slot);
                slotList.add(newSlot);
                break;
            }
        }
    }

    public static void getCurrentStatus() {
        System.out.println("Slot No.            Registration No.             Colour");
        System.out.println("-------------------------------------------------------");
        for (Slot slot : slotList) {
            if(!slot.getAvailability()) {
                System.out.print(slot.slotNumber + "                   " + slot.ticket.carRegistrationNumber);
                System.out.println("                " + slot.ticket.carColour);
            }
        }
    }

    public static String getCarRegistrationNumbersForTheGivenColour(String colour) {
        String response = "";
        for(Slot slot : slotList) {
            if (slot.ticket != null && slot.ticket.carColour.equals(colour)) {
                response += slot.ticket.carRegistrationNumber + ",";
            }
        }
        return response;
    }

    public static String getSlotNumbersForCarsWithColour(String colour) {
        String response = "";
        for(Slot slot : slotList) {
            if (slot.ticket != null && slot.ticket.carColour.equals(colour)) {
                response += slot.getSlotNumber() + ",";
            }
        }
        return response;
    }

    public static int getSlotNumberForRegistrationNumber(String registrationNumber) {
        for(Slot slot : slotList) {
            if (slot.ticket != null && slot.ticket.carRegistrationNumber.equals(registrationNumber)) {
                return slot.getSlotNumber();
            }
        }

        return -1;
    }
}
