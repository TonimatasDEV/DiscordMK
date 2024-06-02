package dev.tonimatas.discordmk;

import dev.tonimatas.discordmk.api.NeutronPanel;
import dev.tonimatas.discordmk.api.components.toolbar.Toolbar;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Toolbar toolbar = new Toolbar(0, 0, 25, 1, Color.LIGHT_GRAY);
        toolbar.addSection(0, 0, 0, 80, Color.GRAY, "File");
        
        NeutronPanel neutronPanel = new NeutronPanel("DiscordMK", toolbar);

        neutronPanel.window.setResizable(true);
        neutronPanel.window.setSize(1920, 1080);

        neutronPanel.window.setLocationRelativeTo(null);

        neutronPanel.start();
    }
}