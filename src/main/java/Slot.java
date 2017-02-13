package main.java;

/**
 * Created by heena.h on 13/02/17.
 */
public class Slot {
    int slotNumber;
    boolean availability;
    Ticket ticket = null;

    public Slot(int newNumber, boolean newAvailability){
        this.slotNumber = newNumber;
        this.availability = newAvailability;
    }
}
