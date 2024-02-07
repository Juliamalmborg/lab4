import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class testCarWorkshop {
    private CarWorkshop cw;

    @Before
    public void create_workshop() {cw = new CarWorkshop(2);}

    @Test
    public void testloadmaxworkshop(){
        Saab95 saab = new Saab95();
        cw.load(saab);
        cw.load(saab);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            cw.load(saab);
        });
        assertEquals("The storage is full",e.getMessage());
    }

}
