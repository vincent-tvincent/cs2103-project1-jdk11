import javax.swing.*;
import java.awt.event.*;
import javax.sound.midi.*;
import java.util.*;

/**
 * Handles mouse press, release, and drag events on the Piano.
 */
public class PianoMouseListener extends MouseAdapter {
	// You are free to add more instance variables if you wish.
	private ArrayList<Key> _keys;

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
	}

	// TODO implement this method.
	@Override
	/**
	 * This method is called by Swing whenever the user presses the mouse.
	 * @param e the MouseEvent containing the (x,y) location, relative to the upper-left-hand corner
	 * of the entire piano, of where the mouse is currently located.
	 */
	public void mousePressed (MouseEvent e) {
		for (Key key : _keys) {
			if (key.getPolygon().contains(e.getX(), e.getY())) {
				key.play(true);  // Note that the key should eventually be turned off!
				System.out.println("This key was pressed: " + key);
			}
		}
	}

	// TODO implement this method.
	@Override
	/**
	 * This method is called by Swing whenever the user releases the mouse.
	 * @param e the MouseEvent containing the (x,y) location, relative to the upper-left-hand corner
	 * of the entire piano, of where the mouse is currently located.
	 */
	public void mouseReleased (MouseEvent e) {
	}
}
