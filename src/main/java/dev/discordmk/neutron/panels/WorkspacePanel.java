package dev.discordmk.neutron.panels;

import dev.discordmk.neutron.api.JDragAndDropPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

public class WorkspacePanel extends JPanel {
    private final Image background;
    private int panelX;
    private int panelY;
    private int widthDragged = 0, heightDragged = 0;

    public WorkspacePanel() {
        setLayout(null);

        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/assets/other/background.png")));
        } catch (IOException e) {
            throw new RuntimeException("Error on get background image.");
        }

        panelX = 0;
        panelY = 0;

        JDragAndDropPanel dragAndDrop = new JDragAndDropPanel();
        dragAndDrop.setBackground(Color.BLUE);
        dragAndDrop.setBounds(100, 100, 40, 40);

        JDragAndDropPanel dragAndDrop2 = new JDragAndDropPanel();
        dragAndDrop2.setBackground(Color.RED);
        dragAndDrop2.setBounds(200, 400, 40, 40);


        JDragAndDropPanel dragAndDrop3 = new JDragAndDropPanel();
        dragAndDrop3.setBackground(Color.GREEN);
        dragAndDrop3.setBounds(300, 200, 40, 40);

        add(dragAndDrop);
        add(dragAndDrop2);
        add(dragAndDrop3);


        MouseAdapter mouseAdapter = new MouseAdapter() {
            private Point lastPoint;

            @Override
            public void mousePressed(MouseEvent event) {
                lastPoint = event.getPoint();
                event.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                event.getComponent().setCursor(Cursor.getDefaultCursor());
            }

            @Override
            public void mouseDragged(MouseEvent event) {
                int draggedX = lastPoint.x - event.getPoint().x;
                int draggedY = lastPoint.y - event.getPoint().y;

                widthDragged += draggedX;
                heightDragged += draggedY;
                
                panelX -= draggedX;
                panelY -= draggedY;

                for (Component component : getComponents()) {
                    int newComponentX = component.getX() - draggedX;
                    int newComponentY = component.getY() - draggedY;
                    component.setLocation(newComponentX, newComponentY);
                }

                lastPoint = event.getPoint();
                repaint();
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
        addMouseWheelListener(mouseAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        int cellSize = background.getHeight(null);

        int minWidth = -cellSize - widthDragged;
        int maxWidth = getWidth() + cellSize;
        int minHeight = -cellSize - heightDragged;
        int maxHeight = getHeight() + cellSize;

        int width = minWidth;
        int height = minHeight;

        if (widthDragged >= cellSize || widthDragged <= -cellSize) {
            widthDragged = 0;
        }

        if (heightDragged >= cellSize || heightDragged <= -cellSize) {
            heightDragged = 0;
        }

        while (width < maxWidth && height < maxHeight) {
            g2D.drawImage(background, width, height, cellSize, cellSize, null);

            width += cellSize;

            if (width >= maxWidth) {
                width = minWidth;
                height += cellSize;
            }
        }
    }
}
