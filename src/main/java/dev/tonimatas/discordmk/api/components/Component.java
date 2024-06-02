package dev.tonimatas.discordmk.api.components;

import dev.tonimatas.discordmk.api.NeutronPanel;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public interface Component {
    Shape generateShape(NeutronPanel panel);
    
    void onTouchingBounds(NeutronPanel panel, Graphics2D graphics2D);

    void onStopTouchingBounds(NeutronPanel panel, Graphics2D graphics2D);
    
    void update(NeutronPanel panel, Graphics2D graphics2D);
    
    void onClickInBounds(NeutronPanel panel);
     
    boolean isMouseOver();
    
    Color getColor();
    
    default boolean isFilled() {
        return true;
    }
    
    default boolean hasSubComponents() {
        return !getSubComponents().isEmpty();
    }
    
    default List<Component> getSubComponents() {
        return Collections.emptyList();
    }
}
