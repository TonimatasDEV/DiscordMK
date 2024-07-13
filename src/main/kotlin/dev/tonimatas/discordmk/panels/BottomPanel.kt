package dev.tonimatas.discordmk.panels

import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel

class BottomPanel : JPanel() {
    var coordinates: JLabel

    init {
        background = Color.BLACK
        preferredSize = Dimension(width, 30)
        layout = BorderLayout()

        coordinates = JLabel()
        coordinates.border = BorderFactory.createEmptyBorder(0, 0, 0, 10)
        coordinates.text = "x: 0 | y: 0"

        add(coordinates, BorderLayout.EAST)
    }
}