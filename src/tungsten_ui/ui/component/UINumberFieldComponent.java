package tungsten_ui.ui.component;

import tungsten_ui.ui.ScreenManager;
import tungsten_ui.util.MouseInput;

import java.awt.*;

public class UINumberFieldComponent extends UIComponent {
    private UIButtonComponent increaseButton;
    private UIButtonComponent decreaseButton;
    private UIRectangleComponent background;
    private UITextComponent numberDisplay;

    private int number = 0;

    public UINumberFieldComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
        background = new UIRectangleComponent(0, 0, width, height, Color.WHITE);
        increaseButton = new UIButtonComponent(0, 0, width, height / 3, "");
        decreaseButton = new UIButtonComponent(0, 2 * (height / 3), width, height / 3,"");
        numberDisplay = new UITextComponent(0, 0, width, height, 20, "0");
    }

    public UINumberFieldComponent(int x, int y) {
        super(x, y);
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

        if(MouseInput.x > increaseButton.x + x + offsetX && MouseInput.x < increaseButton.x + x + offsetX + increaseButton.width && MouseInput.y - 26 > increaseButton.y + y + offsetY && MouseInput.y - 26 < increaseButton.y + y + offsetY + increaseButton.height && MouseInput.leftClick && ScreenManager.isReadyForAction()) {
            number++;
            ScreenManager.resetActionDelay();
        }

        if(MouseInput.x > decreaseButton.x + x + offsetX && MouseInput.x < decreaseButton.x + x + offsetX + decreaseButton.width && MouseInput.y - 26 > decreaseButton.y + y + offsetY && MouseInput.y - 26 < decreaseButton.y + y + offsetY + decreaseButton.height && MouseInput.leftClick && ScreenManager.isReadyForAction()) {
            number--;
            ScreenManager.resetActionDelay();
        }
    }
}
