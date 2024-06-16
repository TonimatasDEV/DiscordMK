package dev.discordmk.neutron;

import dev.discordmk.neutron.components.NeutronMenuBar;
import dev.discordmk.neutron.panels.WorkspacePanel;
import dev.discordmk.neutron.util.AssetGetter;

import javax.swing.*;

public class NeutronFrame extends JFrame {
    
    public NeutronFrame() {
        super("DiscordMK");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        setJMenuBar(new NeutronMenuBar());
        
        add(new WorkspacePanel()); // TODO

        ImageIcon icon = AssetGetter.getImageIcon("icon");
        if (icon != null) setIconImage(icon.getImage());
        setVisible(true);
    }
}
