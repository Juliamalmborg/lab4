import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;

public class testScania {
    private Scania scania;

    @Before
    public void create_cars() {
        scania = new Scania();
    }


    @Test
    public void testLowerRamp() {
        scania.stopEngine();
        scania.lowerRamp(20);
        assertEquals(20, scania.getRampAngle(), 0);
    }

    @Test
    public void testRaiseRamp() {
        scania.stopEngine();
        scania.lowerRamp(20);
        scania.raiseRamp(10);
        assertEquals(10, scania.getRampAngle(), 0);
    }

    @Test
    public void lowerRampMoving(){
        scania.startEngine();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            scania.lowerRamp(20);
        });
        assertEquals("cannot lower ramp while moving", e.getMessage());
    }


}
