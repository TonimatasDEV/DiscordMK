package dev.discordmk.neutron;

import dev.discordmk.neutron.components.NeutronMenuBar;
import dev.discordmk.neutron.util.AssetGetter;

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

        ImageIcon icon = AssetGetter.getImageIcon("icon");
        if (icon != null) setIconImage(icon.getImage());
    }
}
