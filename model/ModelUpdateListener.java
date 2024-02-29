package model;
import model.Vehicle;

import java.util.ArrayList;

public interface ModelUpdateListener {
    void actOnModelUpdate(ArrayList<Drawable> drawables);
}
