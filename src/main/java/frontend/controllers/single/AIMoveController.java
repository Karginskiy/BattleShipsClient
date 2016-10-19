package frontend.controllers.single;

import frontend.exceptions.AlreadyShotPointException;
import frontend.models.Field;
import frontend.models.Point;
import frontend.models.ShipValue;

import java.util.Random;

public class AIMoveController extends AbstractMoveController {

    protected AIMoveController(Field field) {
        super(field);
    }

    public boolean shot() {

        Point point = randomMove();

        while (true) {
            try {
                checkForShot(point);
                if (field.getPoint(point).getDecks() >= 1) {
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
        if (field.getPoint(point) == ShipValue.Shot) {
            throw new AlreadyShotPointException();
        } else {
            return true;
        }
    }

}
