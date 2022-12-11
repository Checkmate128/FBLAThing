package tungsten_ui.ui.component;

import tungsten_ui.ui.action.UIAction;

import java.awt.*;
import java.util.ArrayList;

public class UIComponent {

	protected Color bodyColor = new Color(0, 0, 0);
	protected Color borderColor = new Color(0, 0, 0);

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean isChecked = false;

	protected boolean selected = false;
	protected boolean isSelectable = false;
	protected boolean hovered;
	protected boolean visible = true;
	protected boolean isCompound = false;
	protected boolean isFocused = false;
	protected boolean isClickable = true;

	protected String text = "";
	protected int fontSize;
	protected Color textColor;

	protected Color itemHoverBorderColor = new Color(0, 0, 0, 0);
	protected Color itemHoverBodyColor = new Color(0, 0, 0, 0);
	protected Color itemDefaultBorderColor = new Color(0, 0, 0, 0);
	protected Color itemDefaultBodyColor = new Color(0, 0, 0, 0);
	protected Color itemSelectedBorderColor = new Color(0, 0, 0, 0);
	protected Color itemSelectedBodyColor = new Color(0, 0, 0, 0);

	public ArrayList<UIAction> hoverActions = new ArrayList<UIAction>();
	public ArrayList<UIAction> unHoverActions = new ArrayList<UIAction>();
	public ArrayList<UIAction> clickActions = new ArrayList<UIAction>();

	public ArrayList<UIComponent> elements = new ArrayList<UIComponent>();

	public UIComponent(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		isCompound = false;
	}

	public UIComponent(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 10;
		this.height = 10;

		isCompound = false;
	}
	
	public void addClickAction(UIAction uia) {
		clickActions.add(uia);
	}
	
	public void addHoverAction(UIAction uia) {
		hoverActions.add(uia);
	}
	
	public void addUnHoverAction(UIAction uia) {
		unHoverActions.add(uia);
	}

	public void render(Graphics2D g, int offsetX, int offsetY) {
		g.setColor(bodyColor);
		g.drawRect(x + offsetX, y + offsetY, width, height);
		g.setColor(borderColor);
		g.fillRect(x + offsetX, y + offsetY, width, height);
		if (selected) {
			g.setColor(Color.BLACK);
			g.drawRect(x + offsetX, y + offsetY, width, height);
		}
	}

	public void setBodyColor(Color c) {
		bodyColor = c;
	}

	public void setBorderColor(Color c) {
		borderColor = c;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void deselect() {
		selected = false;
	}

	public void setItemHoverBorderColor(Color itemHoverBorderColor) {
		this.itemHoverBorderColor = itemHoverBorderColor;
	}

	public void setItemHoverBodyColor(Color itemHoverBodyColor) {
		this.itemHoverBodyColor = itemHoverBodyColor;
	}

	public void setItemDefaultBorderColor(Color itemDefaultBorderColor) {
		this.itemDefaultBorderColor = itemDefaultBorderColor;
	}

	public void setItemDefaultBodyColor(Color itemDefaultBodyColor) {
		this.itemDefaultBodyColor = itemDefaultBodyColor;
	}

	public void setItemSelectedBorderColor(Color itemSelectedBorderColor) {
		this.itemSelectedBorderColor = itemSelectedBorderColor;
	}

	public void setItemSelectedBodyColor(Color itemSelectedBodyColor) {
		this.itemSelectedBodyColor = itemSelectedBodyColor;
	}

	public void setClickable(boolean clickable) {
		isClickable = clickable;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public boolean isHovered() {
		return hovered;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public boolean isCompound() {
		return isCompound;
	}
	
	public boolean isFocused() {
		return isFocused;
	}
	
	public boolean isClickable() {
		return isClickable;
	}

	public boolean isSelectable() {
		return isSelectable;
	}

	public boolean isChecked() {
		return isChecked;
	}

}
