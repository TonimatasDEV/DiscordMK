package dev.tonimatas.discordmk.api.components;

import dev.tonimatas.discordmk.api.NeutronPanel;

import java.awt.*;

public abstract class BasicComponent implements Component {
    protected int x, y;
    protected Color color;
    protected boolean isMouseOver;
    
    public BasicComponent(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void onTouchingBounds(NeutronPanel panel, Graphics2D graphics2D) {
        if (!isMouseOver) isMouseOver = true;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void onStopTouchingBounds(NeutronPanel panel, Graphics2D graphics2D) {
        if (isMouseOver) isMouseOver = false;
    }

    @Override
    public boolean isMouseOver() {
        return isMouseOver;
    }
}
