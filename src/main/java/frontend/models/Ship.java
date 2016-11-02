package frontend.models;

public class Ship {

    private Point[] ship;
    private final int size;
    private final ShipValue value;
    private final Orientation orientation;
    private final Point startPoint;

    public Ship(Point startPoint, Orientation orientation) {
        this.value = startPoint.getValue();
        this.ship = new Point[value.getDecks()];
        this.size = value.getDecks();
        this.orientation = orientation;
        this.startPoint = startPoint;
        initShip();
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

    private void initShip() {
        int x = startPoint.getX();
        int y = startPoint.getY();
        ship[0] = startPoint;
        switch (orientation) {
            case HORIZONTAL:
                for (int i = 1; i < size; i++) {
                    ship[i] = new Point(x + i, y, value);
                }
                break;
            case VERTICAL:
                for (int i = 0; i < size; i++) {
                    ship[i] = new Point(x, y + i, value);
                }
                break;
        }
    }

}
