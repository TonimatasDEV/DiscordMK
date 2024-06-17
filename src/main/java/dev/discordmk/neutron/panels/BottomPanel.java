package dev.discordmk.neutron.panels;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    public JLabel coordinates;
    
    public BottomPanel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(getWidth(), 30));
        setLayout(new BorderLayout());
        
        coordinates = new JLabel();
        coordinates.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        coordinates.setText("x: 0 | y: 0");

        add(coordinates, BorderLayout.EAST);
    }
}
