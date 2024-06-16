package dev.discordmk.neutron.components;

import javax.swing.*;

public class NeutronMenuBar extends JMenuBar {
    public NeutronMenuBar() {
        JMenu fileMenu = new JMenu("File");
        
        
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        add(fileMenu);

        add(Box.createHorizontalGlue());

        JButton saveButton = new JButton("Save");
        
        add(saveButton);
    }
}
