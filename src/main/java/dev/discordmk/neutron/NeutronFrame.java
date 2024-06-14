package dev.discordmk.neutron;

import dev.discordmk.neutron.components.NeutronMenuBar;

import javax.swing.*;
import java.util.Objects;

public class NeutronFrame extends JFrame {
    public NeutronFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DiscordMK");
        setVisible(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        
        setJMenuBar(new NeutronMenuBar());
        
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon.png"))).getImage());
    }
}
