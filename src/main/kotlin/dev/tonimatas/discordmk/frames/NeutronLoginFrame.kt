package dev.tonimatas.discordmk.frames

import dev.tonimatas.discordmk.util.AssetGetter
import java.awt.*
import java.net.URI
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

class NeutronLoginFrame : JFrame("DiscordMK") {
    init {
        isVisible = true
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(400, 200)
        isResizable = false
        setLocationRelativeTo(null)

        val button = JButton("Login")
        button.preferredSize = Dimension(140, 40)
        button.font = Font(button.font.name, Font.BOLD, 16)
        val githubIcon: ImageIcon = AssetGetter.getImageIcon("github")
        button.icon = githubIcon

        button.addActionListener {
            try {
                Desktop.getDesktop().browse(URI("http://localhost:8080/oauth2/authorization/discord"))
            } catch (ignored: Exception) {
            }
        }

        val panel = JPanel(GridBagLayout())
        panel.add(button)
        add(panel, BorderLayout.CENTER)

        val icon: ImageIcon = AssetGetter.getImageIcon("icon")
        iconImage = icon.image
    }
}