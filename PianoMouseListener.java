import java.awt.event.*;
import java.util.*;

/**
 * Handles mouse press, release, and drag events on the Piano.
 */
public class PianoMouseListener extends MouseAdapter {
	// You are free to add more instance variables if you wish.
	private ArrayList<Key> _keys;
	private Key lastKey;
	/**
	 * @param keys the list of keys in the piano.
	 */
	public PianoMouseListener (ArrayList<Key> keys) {
		_keys = keys;
	}

	// TODO implement this method.
	@Override
	/**
	 * This method is called by Swing whenever the user drags the mouse.
	 * @param e the MouseEvent containing the (x,y) location, relative to the upper-left-hand corner
	 * of the entire piano, of where the mouse is currently located.
	 */
	public void mouseDragged (MouseEvent e) {
		Key recentKey = getKey(e);
		if(lastKey != recentKey){
			if(lastKey != null) {
				lastKey.play(false);
			}
			recentKey.play(true);
			lastKey = recentKey;
		}
	}


	// TODO implement this method.
	@Override
	/**
	 * This method is called by Swing whenever the user presses the mouse.
	 * @param e the MouseEvent containing the (x,y) location, relative to the upper-left-hand corner
	 * of the entire piano, of where the mouse is currently located.
	 */
	public void mousePressed (MouseEvent e) {
		Key key = getKey(e);
		key.play(true);
		System.out.println("This key was pressed: " + key);
		lastKey = key;
	}

	// TODO implement this method.
	@Override
	/**
	 * This method is called by Swing whenever the user releases the mouse.
	 * @param e the MouseEvent containing the (x,y) location, relative to the upper-left-hand corner
	 * of the entire piano, of where the mouse is currently located.
	 */
	public void mouseReleased (MouseEvent e) {
		Key key = getKey(e);
		key.play(false);
		System.out.println("This key was released: " + key);
		lastKey = null;
	}
	private Key getKey(MouseEvent e){
		Key key = null;
		for(Key k: _keys){
			if(k.getPolygon().contains(e.getX(), e.getY())){
				key = k;
//				break;
			}
		}
		return key;
	}
}

