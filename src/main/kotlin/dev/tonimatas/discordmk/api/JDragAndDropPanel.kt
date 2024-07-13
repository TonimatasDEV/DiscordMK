package dev.tonimatas.discordmk.api

import java.awt.Cursor
import java.awt.Point
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JPanel

class JDragAndDropPanel : JPanel() {
    var movingCursor: Cursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)
        private set

    init {
        val mouseAdapter: MouseAdapter = object : MouseAdapter() {
            private var initialClick: Point? = null

            override fun mousePressed(event: MouseEvent) {
                initialClick = event.point
                event.component.cursor = movingCursor
            }

            override fun mouseReleased(event: MouseEvent) {
                event.component.cursor = Cursor.getDefaultCursor()
            }

            override fun mouseDragged(event: MouseEvent) {
                val x = location.x + (event.x - initialClick!!.x)
                val y = location.y + (event.y - initialClick!!.y)
                setLocation(x, y)
            }
        }

        addMouseListener(mouseAdapter)
        addMouseMotionListener(mouseAdapter)
    }

    fun setMouseCursor(cursor: Cursor) {
        this.movingCursor = cursor
    }
}