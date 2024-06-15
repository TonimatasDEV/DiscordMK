package dev.discordmk.neutron;

import dev.discordmk.neutron.components.NeutronMenuBar;
import dev.discordmk.neutron.util.AssetGetter;

import javax.swing.*;

public class NeutronFrame extends JFrame {
    public NeutronFrame() {
        super("DiscordMK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        setJMenuBar(new NeutronMenuBar());

        ImageIcon icon = AssetGetter.getImageIcon("icon");
        if (icon != null) setIconImage(icon.getImage());
    }
}
