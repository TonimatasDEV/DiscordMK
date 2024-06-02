package dev.tonimatas.discordmk.api.components.toolbar;

import dev.tonimatas.discordmk.api.NeutronPanel;
import dev.tonimatas.discordmk.api.components.AbstractComponent;
import dev.tonimatas.discordmk.api.components.Component;
import dev.tonimatas.discordmk.api.components.toolbar.section.AbstractSection;
import dev.tonimatas.discordmk.api.components.toolbar.section.ButtonListSection;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Toolbar extends AbstractComponent {
    protected int height;
    protected Component[] sections;
    
    public Toolbar(int x, int y, int height, int sections, Color color) {
        super(x, y, color);
        this.height = height;
        this.sections = new AbstractSection[sections];
    }
    
    @Override
    public Shape generateShape(NeutronPanel panel) {
        int x = this.x;
        
        for (Component section : sections) {
            x += (int) section.generateShape(panel).getBounds().getWidth();
        }
        
        return new Rectangle(x, y, panel.getWidth() - x, height);
    }

    @Override
    public void update(NeutronPanel panel, Graphics2D graphics2D) {
        //if (isMouseOver) {
        //    System.out.println("Mouse is touching this toolbar");
        //}
    }
    
    public void addSection(int id, int x, int y, int width, Color color, String label) {
        sections[id] = new ButtonListSection(x, y, width, height, color, label);
    }

    @Override
    public List<Component> getSubComponents() {
        return Arrays.stream(sections).toList();
    }

    private int mouseCount;
    @Override
    public void onClickInBounds(NeutronPanel panel) {
        Random random = new Random();
        mouseCount++;
        System.out.println(mouseCount);
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}
