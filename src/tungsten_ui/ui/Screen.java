package tungsten_ui.ui;

import tungsten_ui.ui.component.UIComponent;
import tungsten_ui.util.MouseInput;

import java.awt.*;
import java.util.ArrayList;

public class Screen {

	public ArrayList<UIComponent> elements = new ArrayList<UIComponent>();

	public Screen() {
		
	}
	
	public void addComponent(UIComponent uic) {
		elements.add(uic);
	}

	public void deselectAll() {
		for (int i = 0; i < elements.size(); i++) {
			elements.get(i).deselect();
		}
	}

	public void manage(Graphics2D g) {
		if(MouseInput.leftClick && ScreenManager.isReadyForAction()) {
			deselectAll();
		}

		for (int i = 0; i < elements.size(); i++) {

			ScreenManager.setCheckedComponent(elements.get(i));

			if (elements.get(i).isFocused()) {
				ScreenManager.setFocus(true);
			}

			if (elements.get(i).isVisible()) {

				if (elements.get(i).isClickable() && MouseInput.x >= elements.get(i).getX() && MouseInput.x < elements.get(i).getX() + elements.get(i).getWidth() && MouseInput.y - 24 >= elements.get(i).getY() && MouseInput.y - 24 < elements.get(i).getY() + elements.get(i).getHeight()) {
					if (MouseInput.leftClick && ScreenManager.isReadyForAction()) {

						if(elements.get(i).isSelectable()) {
							deselectAll();
							elements.get(i).setSelected(true);
						}

						for (int j = 0; j < elements.get(i).clickActions.size(); j++) {
							elements.get(i).clickActions.get(j).run();
							ScreenManager.resetActionDelay();	
						}
					}
					for (int j = 0; j < elements.get(i).hoverActions.size(); j++) {
						elements.get(i).hoverActions.get(j).run();
					}
				} else {
					for (int j = 0; j < elements.get(i).unHoverActions.size(); j++) {
						elements.get(i).unHoverActions.get(j).run();
					}
				}

				elements.get(i).render(g, 0, 0);
			}
		}
	}
}
