package controllers.single;

import exceptions.AlreadyOccupiedPointException;
import models.Field;
import models.Ship;

public abstract class AbstractShipSetController {

    final private Field field;

    public AbstractShipSetController(Field field) {
        this.field = field;
    }

    public void setShip(Ship ship) {
        while (true) {
            try {
                field.setShip(ship);
                return;
            } catch (AlreadyOccupiedPointException e) {
                e.printStackTrace();
            }
        }
    }

}
