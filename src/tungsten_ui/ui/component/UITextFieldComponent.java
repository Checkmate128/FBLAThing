package tungsten_ui.ui.component;

import tungsten_ui.util.KeyboardInput;
import tungsten_ui.util.TextRenderer;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UITextFieldComponent extends UIComponent{

    protected int characterTypeTimer = 0;
    protected char lastCharacter = ' ';
    public UITextFieldComponent(int x, int y, int width, int height, int fontSize) {
        super(x, y, width, height);
        this.bodyColor = Color.WHITE;
        this.borderColor = Color.WHITE;
        this.fontSize = fontSize;
        this.isSelectable = true;
        this.itemSelectedBorderColor = Color.BLACK;
        this.textColor = Color.BLACK;
    }

    public UITextFieldComponent(int x, int y, int fontSize) {
        super(x, y);
        this.bodyColor = Color.WHITE;
        this.borderColor = Color.WHITE;
        this.fontSize = fontSize;
        this.isSelectable = true;
        this.itemSelectedBorderColor = Color.BLACK;
        this.textColor = Color.BLACK;
    }

    @Override
    public void render(Graphics2D g, int offsetX, int offsetY) {
        g.setColor(bodyColor);
        g.fillRect(x + offsetX, y + offsetY, width, height);
        g.setColor(borderColor);
        g.drawRect(x + offsetX, y + offsetY, width, height);
        if(selected) {
            g.setColor(itemSelectedBodyColor);
            g.fillRect(x + offsetX, y + offsetY, width, height);
            g.setColor(itemSelectedBorderColor);
            g.drawRect(x + offsetX, y + offsetY, width, height);
        }
        g.setColor(textColor);
        TextRenderer.drawCenteredString(g, x + offsetX, y + offsetY, width, height, text, g.getFont(), false);

        //Typing Code
        if(selected && KeyboardInput.typing && KeyboardInput.canBeTyped(KeyboardInput.currentCode)) {
            if ((characterTypeTimer < 0 || KeyboardInput.currentKey != lastCharacter)) {
                if (KeyboardInput.canBeTyped(KeyboardInput.currentCode)) {
                    text += KeyboardInput.currentKey;
                }

                if (KeyboardInput.currentCode == KeyEvent.VK_BACK_SPACE) {
                    if(text.length() == 0) {
                        text = "";
                    } else if(text.length() == 1) {
                        text = "";
                    } else {
                        text = text.substring(0, text.length() - 2);
                    }
                }

                if(KeyboardInput.currentKey != lastCharacter || !KeyboardInput.typing) {
                    lastCharacter = KeyboardInput.currentKey;
                    characterTypeTimer = 30;
                } else {
                    characterTypeTimer = 3;
                }
            } else {
                if(characterTypeTimer > -1) {
                    characterTypeTimer--;
                }
            }
        } else {
            characterTypeTimer = 0;
        }
    }
}
