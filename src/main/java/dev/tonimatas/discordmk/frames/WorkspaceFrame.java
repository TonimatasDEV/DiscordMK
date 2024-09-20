package dev.tonimatas.discordmk.frames;

import dev.tonimatas.discordmk.components.NeutronMenuBar;
import dev.tonimatas.discordmk.panels.BottomPanel;
import dev.tonimatas.discordmk.panels.WorkspacePanel;
import dev.tonimatas.discordmk.util.AssetGetter;

import javax.swing.*;
import java.awt.*;

public class WorkspaceFrame extends JFrame {
    public BottomPanel bottomPanel;

    public WorkspaceFrame() {
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
