package dev.discordmk.neutron;

import dev.discordmk.neutron.util.AssetGetter;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class NeutronLoginFrame extends JFrame {
    public NeutronLoginFrame() {
        super("DiscordMK");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);

        JButton button = new JButton("Login");
        button.setPreferredSize(new Dimension(140, 40));
        button.setFont(new Font(button.getFont().getName(), Font.BOLD, 16));
        ImageIcon githubIcon = AssetGetter.getImageIcon("github");
        if (githubIcon != null) button.setIcon(githubIcon);

        button.addActionListener((actionEvent) -> {
            try {
                Desktop.getDesktop().browse(new URI("http://localhost:8080/oauth2/authorization/discord"));
            } catch (Exception ignored) {
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(button);
        add(panel, BorderLayout.CENTER);

        ImageIcon icon = AssetGetter.getImageIcon("icon");
        if (icon != null) setIconImage(icon.getImage());
    }
}
