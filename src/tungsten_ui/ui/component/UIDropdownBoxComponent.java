package tungsten_ui.ui.component;

import tungsten_ui.ui.ScreenManager;
import tungsten_ui.util.KeyboardInput;
import tungsten_ui.util.MouseInput;

import java.awt.*;

public class UIDropdownBoxComponent extends UICompoundComponent {

	private int totalHeight = 0;

	public UIDropdownBoxComponent(int x, int y, int width, int height, int numberOfElements) {
		super(x, y, width, height, numberOfElements);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isCompound = true;
		selectedElement = 0;
		// TODO Auto-generated constructor stub
	}

	public UIDropdownBoxComponent(int x, int y, int numberOfElements) {
		super(x, y, numberOfElements);
		this.x = x;
		this.y = y;
		isCompound = true;
		selectedElement = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics2D g, int offsetX, int offsetY) {

		int finalOffsetX = x + offsetX;
		int finalOffsetY = y + offsetY;

		if (isFocused) {
			hoveredElement = -1;

			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).visible) {
					ScreenManager.setCheckedComponent(elements.get(i));

					if (elements.get(i).isFocused) {
						ScreenManager.setFocus(true);
					}

					totalHeight = elements.get(selectedElement).height;

					for (int j = 0; j < i; j++) {
						totalHeight += elements.get(j).height;
					}

					if (elements.get(i).isClickable && MouseInput.x >= finalOffsetX && MouseInput.x < elements.get(i).width + finalOffsetX && MouseInput.y - 24 >= finalOffsetY + totalHeight && MouseInput.y - 24 < elements.get(i).height + finalOffsetY + totalHeight) {
						if (MouseInput.leftClick && ScreenManager.isReadyForAction()) {
							isFocused = false;
							selectedElement = i;
							for (int j = 0; j < elements.get(i).clickActions.size(); j++) {

								elements.get(i).clickActions.get(j).run();
								ScreenManager.resetActionDelay();
							}
						}
						hoveredElement = i;
						for (int j = 0; j < elements.get(i).hoverActions.size(); j++) {

							elements.get(i).hoverActions.get(j).run();

						}
					} else {

						for (int j = 0; j < elements.get(i).unHoverActions.size(); j++) {
							//hoveredElement = i;
							elements.get(i).unHoverActions.get(j).run();

						}
					}

					elements.get(i).render(g, finalOffsetX, finalOffsetY + totalHeight);

					if (selectedElement == i) {
						g.setColor(itemHoverBodyColor);
						g.fillRect(finalOffsetX, finalOffsetY + totalHeight, elements.get(i).width, elements.get(i).height);
						g.setColor(itemHoverBorderColor);
						g.drawRect(finalOffsetX, finalOffsetY + totalHeight, elements.get(i).width, elements.get(i).height);
					}

					if (hoveredElement == i) {
						g.setColor(itemHoverBodyColor);
						g.fillRect(finalOffsetX, finalOffsetY + totalHeight, elements.get(i).width, elements.get(i).height);
						g.setColor(itemHoverBorderColor);
						g.drawRect(finalOffsetX, finalOffsetY + totalHeight, elements.get(i).width, elements.get(i).height);
					}
				}
			}

			totalHeight += elements.get(elements.size() - 1).height;

			if ((MouseInput.leftClick && ScreenManager.isReadyForAction()) || KeyboardInput.esc) {
				isFocused = false;
				ScreenManager.resetActionDelay();
			}

		} else {
			if (selectedElement >= 0) {
				elements.get(selectedElement).render(g, finalOffsetX, finalOffsetY);
			} else {
				elements.get(0).render(g, finalOffsetX, finalOffsetY);
			}

			totalHeight = elements.get(selectedElement).height;

			if (MouseInput.x >= finalOffsetX && MouseInput.x < finalOffsetX + width && MouseInput.y - 24 >= finalOffsetY && MouseInput.y - 24 < finalOffsetY + height && MouseInput.leftClick) {
				isFocused = true;
				ScreenManager.resetActionDelay();
			}
		}

		g.setColor(bodyColor);
		g.fillRect(x + offsetX, y + offsetY, width, totalHeight);
		g.setColor(borderColor);
		g.drawRect(x + offsetX, y + offsetY, width, totalHeight);
		if (!isFocused) {
			g.drawLine(x + offsetX + width - height - 5, y + offsetY + 5, x + offsetX + width - (height / 2) - 5, y + offsetY + height - 5);
			g.drawLine(x + offsetX + width - (height / 2) - 5, y + offsetY + height - 5, x + offsetX + width - 5, y + offsetY + 5);
			g.drawLine(x + offsetX + width - height - 6, y + offsetY + 5, x + offsetX + width - (height / 2) - 6, y + offsetY + height - 5);
			g.drawLine(x + offsetX + width - (height / 2) - 6, y + offsetY + height - 5, x + offsetX + width - 6, y + offsetY + 5);
			// g.drawLine(x + offsetX + width - height - 5, y + offsetY + 5, x + offsetX +
			// width - 5, y + offsetY + 5);
		}
		if (selected) {
			g.setColor(Color.BLACK);
			g.drawRect(x + offsetX, y + offsetY, width, totalHeight);
		}
	}

	public int getSelectedElement() {
		return selectedElement;
	}

}
