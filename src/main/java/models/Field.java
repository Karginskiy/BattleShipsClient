package models;

import exceptions.AlreadyOccupiedPointException;

public class Field {

    private final ShipValue[][] field;
    public static int SIZE;

    public Field(int size) {
        Field.SIZE = size;
        this.field = new ShipValue[size][size];
    }

    public void setShip(Ship ship) throws AlreadyOccupiedPointException {

        for (Point point: ship.getShip()) {
            checkForEmpty(point);
            checkForNearEmpty(point);
        }

        for (Point point: ship.getShip()) {
            field[point.getX()][point.getY()] = ship.getValue();
        }

    }

    public ShipValue getPoint(Point point) {
        return field[point.getX()][point.getY()];
    }

    public void setPoint(Point point, ShipValue value) {
        field[point.getX()][point.getY()] = value;
    }

    private boolean checkForEmpty(Point point) throws AlreadyOccupiedPointException {

        if (getPoint(point) != null) {
            throw new AlreadyOccupiedPointException("The point has already occupied by the another ship");
        } else {
            return true;
        }

    }

    private boolean checkForNearEmpty(Point point) throws AlreadyOccupiedPointException {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    if (getPoint(point) == null) {
                        throw new AlreadyOccupiedPointException("Near is the ship!");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        return true;
    }
}
