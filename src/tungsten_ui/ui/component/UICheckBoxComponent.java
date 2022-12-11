package tungsten_ui.ui.component;

import tungsten_ui.ui.ScreenManager;
import tungsten_ui.util.MouseInput;

import java.awt.*;

public class UICheckBoxComponent extends UIComponent {

    public UICheckBoxComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public UICheckBoxComponent(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics2D g, int offsetX, int offsetY) {
        g.setColor(borderColor);
        g.drawRect(x + offsetX, y + offsetY, width, height);
        if(isChecked) {
            g.setColor(bodyColor);
            g.drawLine(x + offsetX + width / 8, y + offsetY + height / 8, x + offsetX + width / 2, y + offsetY + height - height / 8);
            g.drawLine(x + offsetX + width / 2, y + offsetY + height - height / 8, x + offsetX + (3 * width) / 2, y + offsetY - (3 * height) / 2);
        }

        if(MouseInput.x > x + offsetX && MouseInput.x < x + offsetX + width && MouseInput.y - 26 > y + offsetY && MouseInput.y - 26 < y + offsetY + height && MouseInput.leftClick && ScreenManager.isReadyForAction()) {
            isChecked = !isChecked;
            ScreenManager.resetActionDelay();
        }


    }
}
