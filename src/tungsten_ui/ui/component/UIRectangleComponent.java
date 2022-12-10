package tungsten_ui.ui.component;

import java.awt.*;

public class UIRectangleComponent extends UIComponent {

	public UIRectangleComponent(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.bodyColor = color;
		this.borderColor = color;
	}

	public UIRectangleComponent(int x, int y, int width, int height, Color bodyColor, Color borderColor) {
		super(x, y, width, height);
		this.bodyColor = bodyColor;
		this.borderColor = borderColor;
	}

	@Override
	public void render(Graphics2D g, int offsetX, int offsetY) {
		g.setColor(bodyColor);
		g.fillRect(x + offsetX, y + offsetY, width, height);
		g.setColor(borderColor);
		g.drawRect(x + offsetX, y + offsetY, width, height);
		if (selected) {
			g.setColor(Color.BLACK);
			g.drawRect(x + offsetX, y + offsetY, width, height);
		}
	}

}
