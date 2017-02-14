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

    }

    public static void freeThisSlot(int slotNumber){

    }

    public static Slot getAvailableSlot(){
        return null;
    }

    public static void addUpdatedSlot(Slot newSlot) {
    }

    public static void getCurrentStatus() {
        System.out.println("Slot No.            Registration No.             Colour");
    }

    public static String getCarRegistrationNumbersForTheGivenColour(String colour) {
        return "";
    }

    public static int getSlotNumbersForCarsWithColour(String colour) {
        return -1;
    }

    public static int getSlotNumberForRegistrationNumber(String registrationNumber) {
        return -1;
    }
}
