package tungsten_ui.ui.component;

import tungsten_ui.ui.ScreenManager;
import tungsten_ui.util.MouseInput;

import java.awt.*;

public class UINumberFieldComponent extends UIComponent {
    private UIButtonComponent increaseButton;
    private UIButtonComponent decreaseButton;
    private UIRectangleComponent background;
    private UITextComponent numberDisplay;

    private int number;
    private int min;
    private int max;

    public UINumberFieldComponent(int x, int y, int width, int height, int value, int min, int max) {
        super(x, y, width, height);
        this.min = min;
        this.max = max;
        this.number = value;
        background = new UIRectangleComponent(0, 0, width, height, Color.WHITE);
        increaseButton = new UIButtonComponent(0, 0, width, height / 3, "");
        decreaseButton = new UIButtonComponent(0, 2 * (height / 3), width, height / 3,"");
        numberDisplay = new UITextComponent(0, 0, width, height, 20, "0");
    }

    public UINumberFieldComponent(int x, int y, int value, int min, int max) {
        super(x, y);
        this.min = min;
        this.max = max;
        this.number = value;
        background = new UIRectangleComponent(0, 0, width, height, Color.WHITE);
        increaseButton = new UIButtonComponent(0, 0, width, height / 3, "");
        decreaseButton = new UIButtonComponent(0, 2 * (height / 3), width, height / 3,"");
        numberDisplay = new UITextComponent(0, 0, width, height, 20, "0");
    }

    @Override
    public void render(Graphics2D g, int offsetX, int offsetY) {
        numberDisplay.setText("" + number);
        background.render(g, offsetX + x, offsetY + y);
        increaseButton.render(g, offsetX + x, offsetY + y);
        decreaseButton.render(g, offsetX + x, offsetY + y);
        numberDisplay.render(g, offsetX + x, offsetY + y);
        g.setColor(Color.WHITE);
        g.fillPolygon(new Polygon(new int[]{increaseButton.x + x + offsetX + 2, increaseButton.x + x + offsetX + increaseButton.width / 2, increaseButton.x + x + offsetX + increaseButton.width - 2}, new int[]{increaseButton.y + increaseButton.height + y + offsetY - 2, increaseButton.y + y + offsetY + 2, increaseButton.y + increaseButton.height + y + offsetY}, 3));
        g.fillPolygon(new Polygon(new int[]{decreaseButton.x + x + offsetX + 2, decreaseButton.x + x + offsetX + decreaseButton.width / 2, decreaseButton.x + x + offsetX + decreaseButton.width - 2}, new int[]{decreaseButton.y + decreaseButton.height + y + offsetY - 2, decreaseButton.y + y + offsetY + 2, decreaseButton.y + decreaseButton.height + y + offsetY}, 3));

        if(MouseInput.x > increaseButton.x + x + offsetX && MouseInput.x < increaseButton.x + x + offsetX + increaseButton.width && MouseInput.y - 26 > increaseButton.y + y + offsetY && MouseInput.y - 26 < increaseButton.y + y + offsetY + increaseButton.height && MouseInput.leftClick && ScreenManager.isReadyForAction()) {
            if(number < max) {
                number++;
            }
            ScreenManager.resetActionDelay();
        }

        if(MouseInput.x > decreaseButton.x + x + offsetX && MouseInput.x < decreaseButton.x + x + offsetX + decreaseButton.width && MouseInput.y - 26 > decreaseButton.y + y + offsetY && MouseInput.y - 26 < decreaseButton.y + y + offsetY + decreaseButton.height && MouseInput.leftClick && ScreenManager.isReadyForAction()) {
            if(number > min) {
                number--;
            }
            ScreenManager.resetActionDelay();
        }
    }
}
