package dev.tonimatas.discordmk.api.components.toolbar.section;

import dev.tonimatas.discordmk.api.NeutronPanel;
import dev.tonimatas.discordmk.api.components.AbstractComponent;

import java.awt.*;

public abstract class AbstractSection extends AbstractComponent {
    public int width, height;
    protected String label;
    
    public AbstractSection(int x, int y, int width, int height, Color color, String label) {
        super(x, y, color);
        this.width = width;
        this.height = height;
        this.label = label;
    }

    @Override
    public Shape generateShape(NeutronPanel panel) {
        return new Rectangle(x, y, width, height);
    }
}
