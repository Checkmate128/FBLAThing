package tungsten_ui.alternator;

import java.util.ArrayList;

public interface Alternator<E> {
	
	public E thisItem();
	public void next();
	public void previous();
	public E nextItem();
	public E previousItem();
	public E randomItem();
	public void setList(ArrayList<E> list);
}
