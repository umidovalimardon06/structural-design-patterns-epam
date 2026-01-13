import java.awt.*;

public class ComponentWithRedBorder implements Component {
    private Component dComponent;

    public ComponentWithRedBorder(Component component) {
        this.dComponent = component;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        dComponent.draw(graphics);
        graphics.setColor(Color.BLACK);
    }
}
