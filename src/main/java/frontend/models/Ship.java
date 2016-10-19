package frontend.models;

public class Ship {

    private final Point[] ship;
    private final int size;
    private final ShipValue value;

    public Ship(int size, ShipValue value) {
        this.size = size;
        this.value = value;
        this.ship = new Point[size];
    }

    public int getSize() {
        return size;
    }

    Point[] getShip() {
        return this.ship;
    }

    ShipValue getValue() {
        return value;
    }

}
