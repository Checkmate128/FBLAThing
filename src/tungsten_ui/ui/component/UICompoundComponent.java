package tungsten_ui.ui.component;

import tungsten_ui.ui.ScreenManager;
import tungsten_ui.util.MouseInput;

import java.awt.*;

public class UICompoundComponent extends UIComponent {

	protected boolean dynamicWidth = false;
	protected boolean dynamicHeight = false;

	protected int numberOfElements;

	protected int selectedElement = -1;
	protected int hoveredElement = -1;

	public UICompoundComponent(int x, int y, int width, int height, int numberOfElements) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isCompound = true;
		borderColor = new Color(0, 0, 0, 0);
		bodyColor = new Color(0, 0, 0, 0);
	}

	public UICompoundComponent(int x, int y, int numberOfElements) {
		super(x, y);
		this.x = x;
		this.y = y;
		isCompound = true;
		borderColor = new Color(0, 0, 0, 0);
		bodyColor = new Color(0, 0, 0, 0);
	}

	public UICompoundComponent(int x, int y) {
		super(x, y);
		this.x = x;
		this.y = y;
		isCompound = true;
		borderColor = new Color(0, 0, 0, 0);
		bodyColor = new Color(0, 0, 0, 0);
	}

	public void addComponent(UIComponent uic) {
		if(isCompound) {
			elements.add(uic);
		} else {
			throw new RuntimeException("This component is not compound!");
		}
	}
	
	@Override
	public void render(Graphics2D g, int offsetX, int offsetY) {
		tick();

		hoveredElement = -1;

		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).visible) {
				ScreenManager.setCheckedComponent(elements.get(i));

				if (elements.get(i).isFocused) {
					ScreenManager.setFocus(true);
				}

				int finalOffsetX = x + offsetX;
				int finalOffsetY = y + offsetY;

				if (elements.get(i).isClickable && MouseInput.x >= elements.get(i).x + finalOffsetX && MouseInput.x < elements.get(i).x + elements.get(i).width + finalOffsetX && MouseInput.y - 24 >= elements.get(i).y + finalOffsetY && MouseInput.y - 24 < elements.get(i).y + elements.get(i).height + finalOffsetY) {
					if (MouseInput.leftClick && ScreenManager.isReadyForAction()) {
						selectedElement = i;
						ScreenManager.deselectAll();
						ScreenManager.resetActionDelay();
						elements.get(i).setSelected(true);
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
						elements.get(i).unHoverActions.get(j).run();
					}
				}

				elements.get(i).render(g, finalOffsetX, finalOffsetY);

				if (selectedElement == i) {
					g.setColor(itemHoverBodyColor);
					g.fillRect(elements.get(i).x + finalOffsetX, elements.get(i).y + finalOffsetY, elements.get(i).width, elements.get(i).height);
					g.setColor(itemHoverBorderColor);
					g.drawRect(elements.get(i).x + finalOffsetX, elements.get(i).y + finalOffsetY, elements.get(i).width, elements.get(i).height);
				}

				if (hoveredElement == i) {
					g.setColor(itemHoverBodyColor);
					g.fillRect(elements.get(i).x + finalOffsetX, elements.get(i).y + finalOffsetY, elements.get(i).width, elements.get(i).height);
					g.setColor(itemHoverBorderColor);
					g.drawRect(elements.get(i).x + finalOffsetX, elements.get(i).y + finalOffsetY, elements.get(i).width, elements.get(i).height);
				}
			}

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

	public void tick() {

	}

	private void checkElements() {

	}

	@Override
	public void deselect() {
		for (int i = 0; i < elements.size(); i++) {
			elements.get(i).deselect();
		}
	}

}
