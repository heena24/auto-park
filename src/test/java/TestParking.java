package test.java;

import main.java.Parking;
import main.java.Slot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by heena.h on 13/02/17.
 */
public class TestParking {

    @Test
    public void testInitializeParking(){
        Parking.resetSlotList();
        int slotSize = Parking.getSlotListSize();
        assertEquals(slotSize,0);
        Parking.initializeParking(2);
        slotSize = Parking.getSlotListSize();
        assertEquals(slotSize,2);
    }

    @Test
    public void testFreeThisSlot() {
        Parking.resetSlotList();
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
        Parking.resetSlotList();
        Parking.initializeParking(2);

        Slot s1 = Parking.getSlot(0);
        s1.setAvailability(false);

        Slot s2 = Parking.getAvailableSlot();
        assertEquals(s2.getSlotNumber(),2);
        assertTrue(s2.getAvailability());
    }

    @Test
    public void testGetCarRegistrationNumbersForTheGivenColour() {

    }
}
