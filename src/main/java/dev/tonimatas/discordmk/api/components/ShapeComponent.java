package dev.tonimatas.discordmk.api.components;

import dev.tonimatas.discordmk.api.NeutronPanel;

import java.awt.*;

public class ShapeComponent implements Component {
    protected Shape shape;
    protected Color color;
    
    public ShapeComponent(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }
    
    @Override
    public Shape generateShape(NeutronPanel panel) {
        return shape;
    }

    @Override
    public void onTouchingBounds(NeutronPanel panel, Graphics2D graphics2D) {

    }

    @Override
    public void onStopTouchingBounds(NeutronPanel panel, Graphics2D graphics2D) {

    }

    @Override
    public void update(NeutronPanel panel, Graphics2D graphics2D) {

    }

    @Override
    public void onClickInBounds(NeutronPanel panel) {

    }

    @Override
    public boolean isMouseOver() {
        return false;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
