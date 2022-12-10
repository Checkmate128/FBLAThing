package tungsten_ui.ui.component;

import tungsten_ui.util.TextRenderer;

import java.awt.*;

public class UITextComponent extends UIComponent {

	public UITextComponent(int x, int y, int width, int height, int fontSize, String text) {
		super(x, y, width, height);
		this.fontSize = fontSize;
		this.text = text;
		borderColor = new Color(0, 0, 0, 0);
		bodyColor = new Color(0, 0, 0, 0);
		textColor = Color.WHITE;
	}

	public UITextComponent(int x, int y, int width, int height, int fontSize, Color textColor, String text) {
		super(x, y, width, height);
		this.fontSize = fontSize;
		this.text = text;
		borderColor = new Color(0, 0, 0, 0);
		bodyColor = new Color(0, 0, 0, 0);
		this.textColor = textColor;
	}

	@Override
	public void render(Graphics2D g, int offsetX, int offsetY) {
		g.setColor(textColor);
		TextRenderer.drawCenteredString(g, x + offsetX, y + offsetY, width, height, text, new Font("Arial", Font.PLAIN, fontSize));
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
