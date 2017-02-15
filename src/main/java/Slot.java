package main.java;

/**
 * Created by heena.h on 13/02/17.
 */
public class Slot {
    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    int slotNumber;
    boolean isAvailable;
    public Ticket ticket = null;

    public Slot(int newNumber, boolean newAvailability){
        this.slotNumber = newNumber;
        this.isAvailable = newAvailability;
    }
}
