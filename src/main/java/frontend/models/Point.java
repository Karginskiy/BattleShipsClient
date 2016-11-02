package frontend.models;

public class Point {

    private final int x;
    private final int y;
    private ShipValue value;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.value = null;
    }

    public Point(int x, int y, ShipValue value) {
        this(x, y);
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ShipValue getValue() {
        return value;
    }

    public void setValue(ShipValue value) {
        this.value = value;
    }
}
