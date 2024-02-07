import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class testVolvo240 {

    @Test
    public void testNrDoors(){
        Vehicle car = new Volvo240();
        assertEquals(4,car.getNrDoors());
    }

    @Test
    public void testenginepwr(){
        Vehicle car = new Volvo240();
        assertEquals(100,car.getEnginePower(),0.0001);
    }
    @Test
    public void setcolor(){
        Vehicle volvo = new Volvo240();
        volvo.setColor(Color.CYAN);
        assertEquals(Color.CYAN,volvo.getColor());
    }
    @Test
    public void speedfactorVolvo(){
        Volvo240 volvo = new Volvo240();
        assertEquals( 1.25,volvo.speedFactor(),0);
    }

    @Test
    public void testgas(){
        Vehicle car = new Volvo240();
        car.startEngine();
        car.gas(1);
        assertEquals(1.35,car.getCurrentSpeed(),0);
    }

    @Test
    public void testbrake(){
        Vehicle car = new Volvo240();
        car.startEngine();
        car.gas(1);
        car.brake(0.5);
        assertEquals(0.725,car.getCurrentSpeed(),0.001);
    }

    //Test för att fånga felmeddelande
    @Test
    public void testgaswrongamount(){
        Vehicle car = new Volvo240();
        car.startEngine();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            car.gas(5);
        });
        assertEquals("The number is not valid. Please choose a value between 0 and 1", e.getMessage());
    }

    //Test för att fånga felmeddelande
    @Test
    public void testbrakewrongamount(){
        Vehicle car = new Volvo240();
        car.startEngine();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            car.brake(5);
        });
        assertEquals("The number is not valid. Please choose a value between 0 and 1", e.getMessage());
    }


    @Test
    public void testmove(){
        Vehicle car = new Volvo240();
        car.startEngine();
        car.move();
        assertEquals(0,car.getXpos(),0.0001);
        assertEquals(1.1,car.getYpos(),0.0001);
    }

    @Test
    public void testLeft(){
        Vehicle car = new Volvo240();
        car.turnLeft();
        assertEquals(180,car.getDirection(),0.0001);
    }

    @Test
    public void testRight(){
        Vehicle car = new Volvo240();
        car.turnRight();
        assertEquals(0,car.getDirection(),0.0001);
    }
}
