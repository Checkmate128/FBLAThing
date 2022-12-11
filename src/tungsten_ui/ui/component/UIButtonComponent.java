package tungsten_ui.ui.component;

import tungsten_ui.ui.action.UIAction;
import tungsten_ui.util.MouseInput;
import tungsten_ui.util.TextRenderer;

import java.awt.*;

public class UIButtonComponent extends UIComponent {

	public UIAction[] hoverActions;
	public UIAction[] unHoverActions;
	public UIAction[] clickActions;

	public void setText(String text) {
		this.text = text;
	}

	public UIButtonComponent(int x, int y, int width, int height, String buttonText) {
		super(x, y, width, height);
		hoverActions = new UIAction[8];
		unHoverActions = new UIAction[8];
		clickActions = new UIAction[8];
		this.text = buttonText;
		bodyColor = new Color(160, 160, 160);
		borderColor = new Color(160, 160, 160);
		itemHoverBodyColor = new Color(255, 60, 60);
		itemHoverBorderColor = new Color(255, 60, 60);
	}

	@Override
	public void render(Graphics2D g, int offsetX, int offsetY) {
		if(isClickable && MouseInput.x > x + offsetX && MouseInput.x < x + offsetX + width && MouseInput.y - 26 > y + offsetY && MouseInput.y - 26 < y + offsetY + height) {
			g.setColor(itemHoverBodyColor);
			g.drawRect(x + offsetX, y + offsetY, width, height);
			g.setColor(itemHoverBorderColor);
			g.fillRect(x + offsetX, y + offsetY, width, height);
		} else {
			g.setColor(bodyColor);
			g.fillRect(x + offsetX, y + offsetY, width, height);
			g.setColor(borderColor);
			g.drawRect(x + offsetX, y + offsetY, width, height);
		}
		if (!isClickable) {
			g.setColor(new Color(0, 0, 0, 150));
			g.fillRect(x + offsetX, y + offsetY, width, height);
		}
		if (selected) {
			g.setColor(Color.BLACK);
			g.drawRect(x + offsetX, y + offsetY, width, height);
		}
		g.setColor(Color.WHITE);
		TextRenderer.drawCenteredString(g, x + offsetX, y + offsetY, width, height, text, new Font("Arial", Font.PLAIN, 50));
	}

}
