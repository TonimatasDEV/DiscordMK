package dev.tonimatas.discordmk.frames

import dev.tonimatas.discordmk.components.NeutronMenuBar
import dev.tonimatas.discordmk.panels.BottomPanel
import dev.tonimatas.discordmk.panels.WorkspacePanel
import dev.tonimatas.discordmk.util.AssetGetter
import java.awt.BorderLayout
import javax.swing.JFrame

class ProjectFrame : JFrame("DiscordMK") {
    var bottomPanel: BottomPanel

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(800, 600)
        setLocationRelativeTo(null)
        jMenuBar = NeutronMenuBar()
        layout = BorderLayout()

        bottomPanel = BottomPanel()

        add(WorkspacePanel(this), BorderLayout.CENTER)
        add(bottomPanel, BorderLayout.SOUTH)

        val icon = AssetGetter.getImageIcon("icon")
        iconImage = icon.image
        isVisible = true
    }
}