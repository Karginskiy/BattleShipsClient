package frontend.controllers.single;

import frontend.exceptions.AlreadyOccupiedPointException;
import frontend.exceptions.AlreadyShotPointException;
import frontend.models.*;

import java.util.ArrayList;
import java.util.Random;

public class AIMoveController extends AbstractMoveController {

    public AIMoveController(Field field) {
        super(field);
        setShips();
    }

    public boolean shot() {

        Point point = randomMove();

        while (true) {
            try {
                checkForShot(point);
                if (field.getPoint(point.getX(), point.getY())
                         .getValue().getDecks() >= 1) {
                    field.setPoint(point, ShipValue.Shot);
                    return true;
                } else {
                    field.setPoint(point, ShipValue.Shot);
                    return false;
                }
            } catch (AlreadyShotPointException ignored) {}
        }

    }

    private Point randomMove() {
        Random random = new Random();
        return new Point(random.nextInt(Field.SIZE), random.nextInt(Field.SIZE));
    }

    private boolean checkForShot(Point point) throws AlreadyShotPointException {
        if (field.getPoint(point.getX(), point.getY()).getValue() == ShipValue.Shot) {
            throw new AlreadyShotPointException();
        } else {
            return true;
        }
    }

    private void setShips() {

        Random rd = new Random();
        while (true) {
            try {

                field.setShip(new Ship(new Point(rd.nextInt(8), rd.nextInt(8), ShipValue.DoubleDecked), Orientation.VERTICAL));
                field.setShip(new Ship(new Point(rd.nextInt(8), rd.nextInt(8), ShipValue.DoubleDecked), Orientation.HORIZONTAL));
                field.setShip(new Ship(new Point(rd.nextInt(8), rd.nextInt(8), ShipValue.FourDecked), Orientation.HORIZONTAL));
                break;

            } catch (Exception ignored) {
            }
        }
    }

}
