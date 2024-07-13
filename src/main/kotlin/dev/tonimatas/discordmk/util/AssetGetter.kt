package dev.tonimatas.discordmk.util

import javax.swing.ImageIcon

object AssetGetter {
    fun getImageIcon(name: String): ImageIcon {
        val imageIconURL = AssetGetter::class.java.getResource("/assets/icons/$name.png")
        return ImageIcon(imageIconURL)
    }
}