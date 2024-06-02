package dev.tonimatas.discordmk;

import dev.tonimatas.discordmk.api.NeutronPanel;
import dev.tonimatas.discordmk.api.components.Toolbar;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        NeutronPanel neutronPanel = new NeutronPanel("DiscordMK", new Toolbar(0, 0, 25, Color.GREEN));

        neutronPanel.window.setResizable(true);
        neutronPanel.window.setSize(1920, 1080);

        neutronPanel.window.setLocationRelativeTo(null);

        neutronPanel.start();
    }
}