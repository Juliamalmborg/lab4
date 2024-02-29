package model;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Vehicle implements Movable, Drawable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xpos; // x-pos of car
    private double ypos; // y-pos of car
    private double direction; // direction of car

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xpos = xpos;
        this.ypos = ypos;
        this.direction = 90;
        stopEngine();

    }

    // ------- geters and setters ---------
    public int getNrDoors() {
        return this.nrDoors;
    }
    public double getEnginePower() {
        return this.enginePower;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }
    @Override
    public double getXpos(){return this.xpos;}
    @Override
    public double getYpos(){return this.ypos;}

    @Override
    public abstract BufferedImage getImage();

    public void setXpos(double x) {this.xpos = x;}

    public void setYpos(double y) {this.ypos = y;}

    public double getDirection(){return this.direction;}


    // ----- Protected methods ---
    public void startEngine(){
        this.currentSpeed = 0.1;
    }

    public void stopEngine(){
        this.currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void invertDirection(){
        direction = (direction + 180)%360;
    }

    // ----- Public Methods -----
    public void gas(double amount) { //ska inte kunna gasa om inte startengine är kallad
        if (amount >= 0 && amount <= 1 && currentSpeed >= 0.1) {
            incrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("The number is not valid. Please choose a value between 0 and 1");
        }
    }
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("The number is not valid. Please choose a value between 0 and 1");}
    }


    @Override
    public void move() {
        xpos += Math.cos(Math.toRadians(direction)) * currentSpeed;
        ypos += Math.sin(Math.toRadians(direction)) * currentSpeed;
    }
    @Override
    public void turnLeft() {
        direction = (direction+90)%360;
    }

    @Override
    public void turnRight() {
        direction = (direction-90)%360;
    }

}

