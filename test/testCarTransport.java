import org.junit.Test;
import java.awt.*;

import org.junit.Before;

import static org.junit.Assert.*;

public class testCarTransport {
    private CarTransport ct;

    @Before
    public void create_cartransport() {ct = new CarTransport(2, Color.black, 500, "Mercedes");}

    @Test
    public void testlowerRamp() {
        ct.lowerRamp();
        assertTrue(ct.getIsRampOn());
    }

    @Test
    public void testraiseRamp() {
        ct.lowerRamp();
        ct.raiseRamp();
        assertFalse(ct.getIsRampOn());
    }


    @Test
    public void testSamePosLoad(){
        Vehicle car = new Saab95();
        car.setXpos(ct.getXpos());
        car.setYpos(ct.getYpos());
        ct.lowerRamp();
        ct.load(car);
        ct.raiseRamp();
        assertEquals(ct.getXpos(), car.getXpos(), 0);
        assertEquals(ct.getYpos(), car.getYpos(), 0);
    }
    @Test
    public void testloadedcars(){
        Vehicle volvo = new Volvo240();
        ct.lowerRamp();
        ct.load(volvo);
        ct.load(volvo);
        ct.unload();
        assertEquals(1,ct.getnrCarsOnRamp(), 0);
    }

    @Test
    public void testErrorLowerRamp(){
        ct.startEngine();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            ct.lowerRamp();
        });
        assertEquals("cannot lower ramp while moving", e.getMessage());
    }

    @Test
    public void testErrorRaiseRamp(){
        ct.startEngine();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            ct.raiseRamp();
        });
        assertEquals("cannot raise ramp while moving", e.getMessage());
    }

}
