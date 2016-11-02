package frontend.views;

import frontend.models.*;
import frontend.models.Point;

import java.awt.*;

public class AIPlayerFieldView extends AbstractFieldView {

    private final Field field;

    public AIPlayerFieldView(Field field) {
        this.field = field;
        setSize(450, 450);
        setVisible(true);
    }

    public void paintField(Graphics g) {

        Point point = null;
        for (int x = 0; x < Field.SIZE; x++) {
            for (int y = 0; y < Field.SIZE; y++) {
                point = field.getPoint(x, y);
                paintPointValue(g, point);
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintField(g);
    }

    private void paintPointValue(Graphics g, Point point) {

        int x = point.getX();
        int y = point.getY();
        Color color = Color.lightGray;

        if (point.getValue() == ShipValue.Shot) {
            color = Color.RED;
        } else if (point.getValue() != null) {
            color = Color.BLACK;
            g.fillRect(x * 50, y * 50, 50, 50);
            return;
        }

        g.setColor(color);
        g.drawRect(x * 50, y * 50, 50, 50);

    }
}
