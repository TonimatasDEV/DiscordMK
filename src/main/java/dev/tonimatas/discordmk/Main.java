package dev.tonimatas.discordmk;

import dev.tonimatas.discordmk.api.NeutronPanel;
import dev.tonimatas.discordmk.api.components.ShapeComponent;
import dev.tonimatas.discordmk.api.components.toolbar.Toolbar;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Toolbar toolbar = new Toolbar(0, 0, 25, 1, Color.LIGHT_GRAY);
        toolbar.addSection(0, 0, 0, 80, Color.GRAY, "File");

        ShapeComponent shapeComponent = new ShapeComponent(new Rectangle(100, 100, 100, 100), Color.GREEN);
        ShapeComponent shapeComponent1 = new ShapeComponent(new Rectangle(100, 100, 20, 20), Color.BLUE);
        
        NeutronPanel neutronPanel = new NeutronPanel("DiscordMK", toolbar, shapeComponent, shapeComponent1);

        neutronPanel.window.setResizable(true);
        neutronPanel.window.setSize(1920, 1080);

        neutronPanel.window.setLocationRelativeTo(null);

        neutronPanel.start();
    }
}