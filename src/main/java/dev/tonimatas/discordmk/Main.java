package dev.tonimatas.discordmk;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setResizable(true);
        window.setTitle("DiscordMK");
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PanelMK panel = new PanelMK();
        
        window.add(panel);
        window.setSize(1920, 1080);
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.start();
    }
}