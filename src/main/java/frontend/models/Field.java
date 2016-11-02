package frontend.models;

import frontend.exceptions.AlreadyOccupiedPointException;

import java.util.Iterator;

public class Field implements Iterable<Point> {

    private final Point[][] field;
    public static int SIZE;

    public Field(int size) {
        Field.SIZE = size;
        this.field = new Point[size][size];
        initField();
    }

    public void setShip(Ship ship) throws AlreadyOccupiedPointException {

        for (Point point: ship.getShip()) {
            if (!checkForEmpty(point.getX(), point.getY())) return;
            if (!checkForNearEmpty(point.getX(), point.getY())) return;
        }

        for (Point point: ship.getShip()) {
            setPoint(point, ship.getValue());
        }

    }

    public Point getPoint(int x, int y) {
        return field[x][y];
    }

    public void setPoint(Point point, ShipValue value) {
        getPoint(point.getX(), point.getY()).setValue(value);
    }

    public Iterator<Point> iterator() {
        return new FieldIterator();
    }

    private boolean checkForEmpty(int x, int y) throws AlreadyOccupiedPointException {

        if (getPoint(x, y).getValue() != null) {
            return false;
        } else {
            return true;
        }

    }

    private boolean checkForNearEmpty(int x, int y) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    if (getPoint(x + i, y + j).getValue() != null) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        return true;
    }

    private class FieldIterator implements Iterator<Point> {

        private int current_i = 0;
        private int current_j = 0;

        public boolean hasNext() {
            return current_j < SIZE && current_i < SIZE;
        }

        public Point next() {
            if (current_j == SIZE - 1) {
                return field[current_i++][current_j -= 2];
            }
            return field[current_i][current_j++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void initField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = new Point(i, j);
            }
        }
    }
}
