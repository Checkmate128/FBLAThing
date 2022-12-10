package tungsten_ui.ui.action;

import tungsten_ui.ui.ScreenManager;

import java.awt.*;

public class UIActionChangeProperty extends UIAction {

	public static int NULL = 0;
	public static int BODY_COLOR = 1;
	public static int BORDER_COLOR = 2;
	public static int TEXT = 3;
	public static int CLICKABLE = 4;
	public static int VISIBLE = 5;
	public static int SELECTED = 6;

	private int targetScreen = -1;
	private int targetComponent = -1;
	private int property;
	private Color color;
	private String text;
	private boolean visible;
	private boolean selected;
	private boolean clickable;

	public UIActionChangeProperty(int property, Color color) {
		// TODO Auto-generated constructor stub
		this.property = property;
		this.color = color;
	}

	public UIActionChangeProperty(int property, String text) {
		// TODO Auto-generated constructor stub
		this.property = property;
		this.text = text;
	}

	public UIActionChangeProperty(int property, boolean value) {
		// TODO Auto-generated constructor stub
		this.property = property;
		if (property == VISIBLE) {
			this.visible = value;
		} else if (property == SELECTED) {
			this.selected = value;
		}
	}

	@Override
	public void run() {
		
		if (property == BODY_COLOR) {
			ScreenManager.getCheckedComponent().setBodyColor(color);
		} else if (property == BORDER_COLOR) {
			ScreenManager.getCheckedComponent().setBorderColor(color);
		} else if (property == TEXT) {
			ScreenManager.getCheckedComponent().setText(text);
		} else if (property == CLICKABLE) {
			ScreenManager.getCheckedComponent().setClickable(clickable);
		} else if (property == VISIBLE) {
			ScreenManager.getCheckedComponent().setVisible(visible);
		} else if (property == SELECTED) {
			ScreenManager.deselectAll();
			ScreenManager.getCheckedComponent().setSelected(selected);
		}	
		
	}

}
