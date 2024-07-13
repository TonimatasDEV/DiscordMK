package dev.tonimatas.discordmk.components

import javax.swing.*

class NeutronMenuBar : JMenuBar() {
    init {
        val fileMenu = JMenu("File")

        val openItem = JMenuItem("Open")
        val saveItem = JMenuItem("Save")
        val exitItem = JMenuItem("Exit")

        fileMenu.add(openItem)
        fileMenu.add(saveItem)
        fileMenu.addSeparator()
        fileMenu.add(exitItem)

        add(fileMenu)

        add(Box.createHorizontalGlue())

        val saveButton = JButton("Save")

        add(saveButton)
    }
}