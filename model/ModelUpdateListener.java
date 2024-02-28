package model;
import model.Vehicle;

public interface ModelUpdateListener {
    void actOnModelUpdate();
    void actOnVehicleAdded(Vehicle vehicle);

}
