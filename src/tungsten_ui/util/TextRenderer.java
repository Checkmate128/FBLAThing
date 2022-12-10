package tungsten_ui.util;

import java.awt.*;
import java.util.ArrayList;

public class TextRenderer {

	public TextRenderer() {

	}

	public static void drawCenteredString(Graphics2D g, int x, int y, int width, int height, String text, Font font) {
		FontMetrics metrics = g.getFontMetrics(font);
		int drawX = x + (width - metrics.stringWidth(text)) / 2;
		int drawY = y + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
		g.setFont(font);
		g.drawString(text, drawX, drawY);
	}

	public static void drawCenteredString(Graphics2D g, int x, int y, int width, int height, String text, Font font, boolean wrapText) {
		FontMetrics metrics = g.getFontMetrics(font);
		if(wrapText) {
			String currentRawText = "";
			String currentLine = "";
			String currentWord = "";
			ArrayList<String> lines = new ArrayList<>();
			for(int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				currentRawText += c;
				currentWord += c;
				if(c == ' ' || i == text.length() - 1) {
					if(metrics.stringWidth(currentRawText) > width || i == text.length() - 1) {
						if(metrics.stringWidth(currentRawText) > width) {
							lines.add(currentLine);
						} else {
							if (currentLine.length() > 0) {
								lines.add(currentLine + currentWord);
							} else {
								lines.add(currentWord);
							}
						}
						currentLine = "";
						currentRawText = currentWord;
						//currentWord = "";
					} else {
						currentLine += currentWord;
						currentWord = "";
					}
				}
			}
			int drawX;
			int drawY = y + (lines.size() * (height - metrics.getHeight()) / 2) + metrics.getAscent();
			g.setFont(font);
			if(lines.size() > 0) {
				for (int i = 0; i < lines.size(); i++) {
					drawX = x + (width - metrics.stringWidth(lines.get(i))) / 2;
					g.drawString(lines.get(i), drawX, drawY);
					System.out.println(lines.get(i));
					drawY += metrics.getHeight();
				}
			}

		} else {
			int drawX = x + (width - metrics.stringWidth(text)) / 2;
			int drawY = y + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
			g.setFont(font);
			g.drawString(text, drawX, drawY);
		}
	}

}
