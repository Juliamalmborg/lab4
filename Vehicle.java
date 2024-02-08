import java.awt.*;

public abstract class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xpos; // x-pos of car
    private double ypos; // y-pos of car
    private double direction; // direction of car
    private int size;
    private boolean movable;

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xpos = 0;
        this.ypos = 1;
        this.direction = 90;
        this.movable = true;
        stopEngine();

    }

    // ------- geters and setters ---------
    protected int getNrDoors() {
        return this.nrDoors;
    }
    protected double getEnginePower() {
        return this.enginePower;
    }

    protected double getCurrentSpeed() {
        return this.currentSpeed;
    }

    protected Color getColor() {
        return this.color;
    }

    protected void setColor(Color clr) {
        this.color = clr;
    }

    protected double getXpos(){return this.xpos;}
    protected double getYpos(){return this.ypos;}

    protected void setXpos(double x) {this.xpos = x;}

    protected void setYpos(double y) {this.ypos = y;}

    protected double getDirection(){return this.direction;}


    // ---- if the car can move ----

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    // ----- Protected methods ---
    protected void startEngine(){
        this.currentSpeed = 0.1;
    }

    protected void stopEngine(){
        this.currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    protected void invertDirection(){
        direction = (direction + 180)%360;
    }

    // ----- Public Methods -----
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
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

