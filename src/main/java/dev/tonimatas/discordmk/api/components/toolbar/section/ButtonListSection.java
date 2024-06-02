package dev.tonimatas.discordmk.api.components.toolbar.section;

import dev.tonimatas.discordmk.api.NeutronPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ButtonListSection extends AbstractSection {
    protected Color color;
    
    public ButtonListSection(int x, int y, int width, int height, Color color, String label) {
        super(x, y, width, height, color, label);
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Shape generateShape(NeutronPanel panel) {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void update(NeutronPanel panel, Graphics2D graphics2D) {
        Rectangle2D rectangle = graphics2D.getFont().getStringBounds(label, graphics2D.getFontRenderContext());
        
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();
        
        int x = (int) generateShape(panel).getBounds().getCenterX() - width / 2;
        int y = height;
        
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 16));
        graphics2D.drawString(label, x, y);
    }

    @Override
    public void onClickInBounds(NeutronPanel panel) {

    }
}
