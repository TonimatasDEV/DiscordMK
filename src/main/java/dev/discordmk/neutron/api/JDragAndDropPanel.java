package dev.discordmk.neutron.api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JDragAndDropPanel extends JPanel {
    private Cursor movingCursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);

    public JDragAndDropPanel() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            private Point initialClick;

            @Override
            public void mousePressed(MouseEvent event) {
                initialClick = event.getPoint();
                event.getComponent().setCursor(movingCursor);
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                event.getComponent().setCursor(Cursor.getDefaultCursor());
            }

            @Override
            public void mouseDragged(MouseEvent event) {
                int x = getLocation().x + (event.getX() - initialClick.x);
                int y = getLocation().y + (event.getY() - initialClick.y);
                setLocation(x, y);
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    public void setMouseCursor(Cursor cursor) {
        this.movingCursor = cursor;
    }

    public Cursor getMovingCursor() {
        return movingCursor;
    }
}
