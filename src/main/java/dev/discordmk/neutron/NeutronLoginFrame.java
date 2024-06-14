package dev.discordmk.neutron;

import dev.discordmk.neutron.util.AssetGetter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class NeutronLoginFrame extends JFrame {
    public NeutronLoginFrame() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DiscordMK");
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon icon = AssetGetter.getImageIcon("icon");
        if (icon != null) setIconImage(icon.getImage());

        JButton button = new JButton("Login");
        button.setPreferredSize(new Dimension(140, 40));
        button.setFont(new Font(button.getFont().getName(), Font.BOLD, 16));
        ImageIcon githubIcon = AssetGetter.getImageIcon("github");
        if (githubIcon != null) button.setIcon(githubIcon);
        
        button.addActionListener((actionEvent) -> {
            // DO THE LOGIN
        });
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(button);
        add(panel, BorderLayout.CENTER);
    }
}
