package dev.tonimatas.discordmk;

import com.formdev.flatlaf.FlatDarkLaf;
import dev.tonimatas.discordmk.frames.ProjectFrame;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatDarkLaf());

        //NeutronLoginFrame loginFrame = new NeutronLoginFrame();

        new ProjectFrame();
    }
}