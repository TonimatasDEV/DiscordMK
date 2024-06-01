package dev.tonimatas.discordmk.components;

import dev.tonimatas.discordmk.PanelMK;

import java.awt.*;

public class Toolbar implements Component {
    public Toolbar() {
        
    }
    
    public void draw(PanelMK panelMK, Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        Rectangle rectangle = new Rectangle(0, 0, panelMK.getWidth(), 25);
        graphics2D.fill(rectangle);
        
        panelMK.setDefaultDraw(graphics2D);
    }
}
