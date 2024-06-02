package dev.tonimatas.discordmk.api;

import dev.tonimatas.discordmk.api.components.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.concurrent.TimeUnit;

public class NeutronPanel extends JPanel implements Runnable {
    public Thread thread;
    protected Component[] components;
    protected Stroke defaultStroke;
    protected Color defaultColor;
    protected AffineTransform affineTransform;
    public JFrame window;
    
    public NeutronPanel(String name, Component ... components) {
        this.components = components;
        this.window = new JFrame();
        this.window.add(this);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setTitle(name);
        this.window.setVisible(true);
        
        this.window.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (Component component : components) {
                    Shape shape = component.generateShape(NeutronPanel.this);

                    if (shape.contains(e.getX(), e.getY() - 30)) {
                        component.onClickInBounds(NeutronPanel.this);
                        break;
                    }
                }
            }
        });
    }

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
        
        Font font = new Font(graphics2D.getFont().getFontName(), Font.PLAIN, 14);
        graphics2D.setFont(font);

        Point mousePos = getMousePosition();
        
        // Paint components
        for (Component component : components) {
            Shape shape = component.generateShape(this);
            graphics2D.setColor(component.getColor());
            
            if (component.isFilled()) {
                graphics2D.fill(shape);
            } else {
                graphics2D.draw(shape);
            }

            setDefaultDraw(graphics2D);

            if (component.hasSubComponents()) {
                for (Component subcomponent : component.getSubComponents()) {
                    Shape subshape = subcomponent.generateShape(this);
                    graphics2D.setColor(subcomponent.getColor());
                    
                    if (subcomponent.isFilled()) {
                        graphics2D.fill(subshape);
                    } else {
                        graphics2D.draw(subshape);
                    }

                    setDefaultDraw(graphics2D);
                    
                    subcomponent.update(NeutronPanel.this, graphics2D);
                }
            }
            
            if (mousePos != null && shape.contains(mousePos)) {
                component.onTouchingBounds(this, graphics2D);
            } else {
                if (component.isMouseOver()) component.onStopTouchingBounds(this, graphics2D);
            }
            
            component.update(this, graphics2D);
        }
    }
    
    public void setDefaultDraw(Graphics2D graphics2D) {
        graphics2D.setStroke(defaultStroke);
        graphics2D.setColor(defaultColor);
        graphics2D.setTransform(affineTransform);
    }
    
    public void drawString(Graphics2D graphics2D, String text, int x, int y) {
        graphics2D.drawString(text, x, y);
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

                TimeUnit.MILLISECONDS.sleep((long) reamingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
