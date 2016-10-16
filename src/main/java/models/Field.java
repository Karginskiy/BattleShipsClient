package models;

import exceptions.AlreadyOccupiedPointException;

public class Field {

    final private ShipValue[][] field;
    final private int size;

    public Field(int size) {
        this.size = size;
        this.field = new ShipValue[size][size];
    }

    public int getSize() {
        return this.size;
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

    private ShipValue getPoint(Point point) {
        return field[point.getX()][point.getY()];
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
