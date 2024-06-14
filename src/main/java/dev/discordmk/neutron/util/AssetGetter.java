package dev.discordmk.neutron.util;

import javax.swing.*;
import java.net.URL;

public class AssetGetter {
    public static ImageIcon getImageIcon(String name) {
        URL imageIconURL = AssetGetter.class.getResource("/assets/icons/" + name + ".png");
        
        if (imageIconURL == null) {
            System.out.println("Error loading icon: " + name);
            return null;
        } else {
            return new ImageIcon(imageIconURL);
        }
    }
}
