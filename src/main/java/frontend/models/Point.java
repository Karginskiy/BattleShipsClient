package frontend.models;

public class Point {

    private final int x;
    private final int y;
    private ShipValue value;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
