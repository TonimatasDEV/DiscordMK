package dev.tonimatas.discordmk;

import dev.tonimatas.discordmk.components.Toolbar;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.concurrent.TimeUnit;

public class PanelMK extends JPanel implements Runnable {
    public Toolbar toolbar = new Toolbar();
    public Thread thread;
    
    protected Stroke defaultStroke;
    protected Color defaultColor;
    protected AffineTransform affineTransform;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D graphics2D = (Graphics2D) g;
        
        this.defaultStroke = graphics2D.getStroke();
        this.defaultColor = graphics2D.getColor();
        this.affineTransform = graphics2D.getTransform();

        // Anti-aliasing
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        
        // Paint toolbar
        toolbar.draw(this, graphics2D);
        graphics2D.scale(2, 2);
        graphics2D.drawString("Hola buenas", 200, 200);
        setDefaultDraw(graphics2D);
        
        if (getMousePosition() != null) {
            graphics2D.setStroke(new BasicStroke(3));
            graphics2D.drawLine(getWidth()/2, getHeight()/2, getMousePosition().x, getMousePosition().y);
            graphics2D.setStroke(defaultStroke);
        }
    }
    
    public void setDefaultDraw(Graphics2D graphics2D) {
        graphics2D.setStroke(defaultStroke);
        graphics2D.setColor(defaultColor);
        graphics2D.setTransform(affineTransform);
    }
    
    
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000D / 60;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (thread != null) {
            repaint();
            
            try {
                var reamingTime = nextDrawTime - System.nanoTime();
                reamingTime /= 1000000;

                if (reamingTime < 0) {
                    reamingTime = 0.0;
                }

                System.out.println(reamingTime);
                TimeUnit.MILLISECONDS.sleep((long) reamingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
