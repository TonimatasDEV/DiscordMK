package dev.tonimatas.discordmk.api.components;

import dev.tonimatas.discordmk.api.NeutronPanel;

import java.awt.*;
import java.util.Random;

public class Toolbar extends BasicComponent {
    protected int height;
    
    public Toolbar(int x, int y, int height, Color color) {
        super(x, y, color);
        this.height = height;
    }
    
    @Override
    public Shape generateShape(NeutronPanel panel) {
        return new Rectangle(x, y, panel.getWidth(), height);
    }

    @Override
    public void update(NeutronPanel panel, Graphics2D graphics2D) {
        //if (isMouseOver) {
        //    System.out.println("Mouse is touching this toolbar");
        //}
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
