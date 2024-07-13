package dev.tonimatas.discordmk.panels

import dev.tonimatas.discordmk.frames.ProjectFrame
import dev.tonimatas.discordmk.api.JDragAndDropPanel
import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.IOException
import java.util.*
import javax.imageio.ImageIO
import javax.swing.JPanel

class WorkspacePanel(frame: ProjectFrame) : JPanel() {
    private var background: Image? = null
    private var panelX: Int
    private var panelY: Int
    private var widthDragged = 0
    private var heightDragged = 0

    init {
        layout = null

        try {
            background =
                ImageIO.read(Objects.requireNonNull(javaClass.getResourceAsStream("/assets/other/background.png")))
        } catch (e: IOException) {
            throw RuntimeException("Error on get background image.")
        }

        panelX = 0
        panelY = 0

        val dragAndDrop = JDragAndDropPanel()
        dragAndDrop.setBackground(Color.BLUE)
        dragAndDrop.setBounds(100, 100, 40, 40)

        val dragAndDrop2 = JDragAndDropPanel()
        dragAndDrop2.setBackground(Color.RED)
        dragAndDrop2.setBounds(200, 400, 40, 40)

        val dragAndDrop3 = JDragAndDropPanel()
        dragAndDrop3.setBackground(Color.GREEN)
        dragAndDrop3.setBounds(300, 200, 40, 40)

        val panel = JPanel()
        panel.background = Color.PINK
        panel.setBounds(800 / 2, 600 / 2, 40, 40)


        add(panel)
        add(dragAndDrop)
        add(dragAndDrop2)
        add(dragAndDrop3)

        val mouseAdapter: MouseAdapter = object : MouseAdapter() {
            private var lastPoint: Point? = null

            override fun mouseMoved(event: MouseEvent) {
                val x = panelX + (event.x - width / 2)
                val y = panelY - (event.y - height / 2)

                frame.bottomPanel.coordinates.setText("x: $x y: $y")
            }

            override fun mousePressed(event: MouseEvent) {
                lastPoint = event.point
                event.component.cursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)
            }

            override fun mouseReleased(event: MouseEvent) {
                event.component.cursor = Cursor.getDefaultCursor()
            }

            override fun mouseDragged(event: MouseEvent) {
                val draggedX = lastPoint!!.x - event.point.x
                val draggedY = lastPoint!!.y - event.point.y

                widthDragged += draggedX
                heightDragged += draggedY

                panelX += draggedX
                panelY -= draggedY

                for (component in components) {
                    val newComponentX = component.x - draggedX
                    val newComponentY = component.y - draggedY
                    component.setLocation(newComponentX, newComponentY)
                }

                lastPoint = event.point
                repaint()
            }
        }

        addMouseListener(mouseAdapter)
        addMouseMotionListener(mouseAdapter)
        addMouseWheelListener(mouseAdapter)
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        val g2D = g as Graphics2D

        val cellSize = background!!.getHeight(null)

        val minWidth = -cellSize - widthDragged
        val maxWidth = width + cellSize
        val minHeight = -cellSize - heightDragged
        val maxHeight = height + cellSize

        var width = minWidth
        var height = minHeight

        if (widthDragged >= cellSize || widthDragged <= -cellSize) {
            widthDragged = 0
        }

        if (heightDragged >= cellSize || heightDragged <= -cellSize) {
            heightDragged = 0
        }

        while (width < maxWidth && height < maxHeight) {
            g2D.drawImage(background, width, height, cellSize, cellSize, null)

            width += cellSize

            if (width >= maxWidth) {
                width = minWidth
                height += cellSize
            }
        }
    }
}