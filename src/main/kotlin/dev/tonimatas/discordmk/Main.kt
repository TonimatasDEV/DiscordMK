package dev.tonimatas.discordmk

import com.formdev.flatlaf.FlatDarkLaf
import dev.tonimatas.discordmk.frames.ProjectFrame
import javax.swing.UIManager

fun main() {
    UIManager.setLookAndFeel(FlatDarkLaf())
    
    //dev.tonimatas.discordmk.frames.NeutronLoginFrame loginFrame = new dev.tonimatas.discordmk.frames.NeutronLoginFrame();

    ProjectFrame()
}