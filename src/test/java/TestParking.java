package test.java;

import main.java.Parking;
import main.java.Slot;
import main.java.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by heena.h on 13/02/17.
 */
public class TestParking {

    @Before
    public void resetParkingSlots() {
        Parking.resetSlotList();
    }

    @Test
    public void testInitializeParking(){
        int slotSize = Parking.getSlotListSize();
        assertEquals(slotSize,0);
        Parking.initializeParking(2);
        slotSize = Parking.getSlotListSize();
        assertEquals(slotSize,2);
    }

    @Test
    public void testFreeThisSlot() {
        Parking.initializeParking(2);

        Slot s1 = Parking.getSlot(0);
        assertTrue(s1.getAvailability());

        s1 = Parking.getSlot(1);
        assertTrue(s1.getAvailability());

        s1.setAvailability(false);
        assertFalse(s1.getAvailability());

        s1 = Parking.getSlot(0);
        s1.setAvailability(false);
        assertFalse(s1.getAvailability());

        Parking.freeThisSlot(1);
        s1 = Parking.getSlot(0);
        assertTrue(s1.getAvailability());
    }

    @Test
    public void testGetAvailableSlot() {
        Parking.initializeParking(2);

        Slot s1 = Parking.getSlot(0);
        s1.setAvailability(false);

        Slot s2 = Parking.getAvailableSlot();

        Slot availSlot = Parking.getAvailableSlot();
        assertEquals(availSlot.getSlotNumber(),s2.getSlotNumber());

        s2.setAvailability(false);
        availSlot = Parking.getAvailableSlot();
        assertEquals(availSlot,null);
    }

    @Test
    public void testGetCarRegistrationNumbersForTheGivenColour() {
        Parking.initializeParking(2);

        Slot s1 = Parking.getSlot(0);
        s1.setAvailability(false);
        s1.ticket = new Ticket("KA03EZ9639","Black");

        Slot s2 = Parking.getSlot(1);
        s2.setAvailability(false);
        s2.ticket = new Ticket("KA03EZ911","White");

        String output = Parking.getCarRegistrationNumbersForTheGivenColour("White");

        assertEquals(output,"KA03EZ911");

    }

    @Test
    public void testGetSlotNumbersForCarsWithColour() {
        Parking.initializeParking(2);

        Slot s1 = Parking.getSlot(0);
        s1.setAvailability(false);
        s1.ticket = new Ticket("KA03EZ9639","Black");

        Slot s2 = Parking.getSlot(1);
        s2.setAvailability(false);
        s2.ticket = new Ticket("KA03EZ911","White");

        String output = Parking.getSlotNumbersForCarsWithColour("Black");
        assertEquals(output,1);

        output = Parking.getSlotNumbersForCarsWithColour("Red");
        assertEquals(output,"");

    }

    @Test
    public void testGetSlotNumberForRegistrationNumber() {
        Parking.initializeParking(2);

        Slot s1 = Parking.getSlot(0);
        s1.setAvailability(false);
        s1.ticket = new Ticket("KA03EZ9639","Black");

        Slot s2 = Parking.getSlot(1);
        s2.setAvailability(false);
        s2.ticket = new Ticket("KA03EZ911","White");

        int output = Parking.getSlotNumberForRegistrationNumber("KA03EZ911");
        assertEquals(output,2);

        output = Parking.getSlotNumberForRegistrationNumber("KA03EZ000");
        assertEquals(output,-1);
    }
}
