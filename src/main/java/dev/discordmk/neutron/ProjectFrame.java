package dev.discordmk.neutron;

import dev.discordmk.neutron.components.NeutronMenuBar;
import dev.discordmk.neutron.panels.BottomPanel;
import dev.discordmk.neutron.panels.WorkspacePanel;
import dev.discordmk.neutron.util.AssetGetter;

import javax.swing.*;
import java.awt.*;

public class ProjectFrame extends JFrame {
    public BottomPanel bottomPanel;

    public ProjectFrame() {
        super("DiscordMK");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setJMenuBar(new NeutronMenuBar());
        setLayout(new BorderLayout());

        bottomPanel = new BottomPanel();

        add(new WorkspacePanel(this), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        ImageIcon icon = AssetGetter.getImageIcon("icon");
        if (icon != null) setIconImage(icon.getImage());
        setVisible(true);
    }
}
