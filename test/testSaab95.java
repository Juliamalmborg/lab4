import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class testSaab95 {

    @Test
    public void testNrDoors(){
        Vehicle car = new Saab95();
        assertEquals(2,car.getNrDoors());
    }

    @Test
    public void testenginepwr(){
        Vehicle car = new Saab95();
        assertEquals(125,car.getEnginePower(),0.0001);
    }
    @Test
    public void setcolor(){
        Vehicle car = new Saab95();
        car.setColor(Color.CYAN);
        assertEquals(Color.CYAN,car.getColor());
    }

    @Test
    public void turboSaabOn(){
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        assertEquals(1.625,saab.speedFactor(),0);
    }

    @Test
    public void turboSaabOff(){
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        assertEquals(1.25,saab.speedFactor(),0);
    }

    @Test
    public void testgas(){
        Vehicle car = new Saab95();
        car.startEngine();
        car.gas(1);
        assertEquals(1.35,car.getCurrentSpeed(),0);
    }

    @Test
    public void testbrake(){
        Vehicle car = new Saab95();
        car.startEngine();
        car.gas(1);
        car.brake(0.5);
        assertEquals(0.725,car.getCurrentSpeed(),0.001);
    }

    //Test för att fånga felmeddelande
    @Test
    public void testgaswrongamount(){
        Vehicle car = new Saab95();
        car.startEngine();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            car.gas(5);
        });
        assertEquals("The number is not valid. Please choose a value between 0 and 1", e.getMessage());
    }

    //Test för att fånga felmeddelande
    @Test
    public void testbrakewrongamount(){
        Vehicle car = new Saab95();
        car.startEngine();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            car.brake(5);
        });
        assertEquals("The number is not valid. Please choose a value between 0 and 1", e.getMessage());
    }

    @Test
    public void testmove(){
        Vehicle car = new Saab95();
        car.startEngine();
        car.move();
        assertEquals(0,car.getXpos(),0.0001);
        assertEquals(1.1,car.getYpos(),0.0001);
    }

    @Test
    public void testLeft(){
        Vehicle car = new Saab95();
        car.turnLeft();
        assertEquals(180,car.getDirection(),0.0001);
    }

    @Test
    public void testRight(){
        Vehicle car = new Saab95();
        car.turnRight();
        assertEquals(0,car.getDirection(),0.0001);
    }
}
