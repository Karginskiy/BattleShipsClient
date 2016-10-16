package models;

class Ship {

    private final Point[] ship;
    private final int size;
    private final ShipValue value;

    public Ship(int size, ShipValue value) {
        this.size = size;
        this.value = value;
        this.ship = new Point[size];
    }

    Point[] getShip() {
        return this.ship;
    }

    public int getSize() {
        return size;
    }

    public ShipValue getValue() {
        return value;
    }
}
