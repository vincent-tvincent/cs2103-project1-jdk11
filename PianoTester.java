import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.awt.event.*;
import org.junit.jupiter.api.*;

/**
 * Contains a set of unit tests for the Piano class.
 */
class PianoTester {
	private TestReceiver _receiver;
	private Piano _piano;
	private PianoMouseListener _mouseListener;

	private MouseEvent makeMouseEvent (int x, int y) {
		return new MouseEvent(_piano, 0, 0, 0, x, y, 0, false);
	}

	@BeforeEach
	void setup () {
		// A new TestReceiver will be created before running *each*
		// test. Hence, the "turn on" and "turn off" counts will be
		// reset to 0 before *each* test.
		_receiver = new TestReceiver();
		_piano = new Piano(_receiver);
		_mouseListener = _piano.getMouseListener();
	}

	@Test
	void testClickUpperLeftMostPixel () {
		// Pressing the mouse should cause the key to turn on.
		_mouseListener.mousePressed(makeMouseEvent(0, 1));
		assertTrue(_receiver.isKeyOn(Piano.START_PITCH));
	}

	@Test
	void testDragWithinKey () {
		// Test that pressing and dragging the mouse *within* the same key
		// should cause the key to be turned on only once, not multiple times.
		// Use makeMouseEvent and TestReceiver.getKeyOnCount.
		// TODO complete me
		_mouseListener.mousePressed(makeMouseEvent(0,1));
		_mouseListener.mouseDragged(makeMouseEvent(0,5));
		assertEquals(1, _receiver.getKeyOnCount(Piano.START_PITCH));

	}

	// TODO write at least 3 more tests!
	@Test
	void testClickUpperRightMostPixel () {
		// Pressing the mouse should cause the key to turn on.
		_mouseListener.mousePressed(makeMouseEvent(839, 0));
		assertTrue(_receiver.isKeyOn(Piano.START_PITCH + 35));
	}

	@Test
	void testOctavesFormat(){
		MouseEvent click;
		boolean result = true;
		int pitch = 48;
		for(int i = 20; i < 240; i += 40){
			click = makeMouseEvent(i, 110);
			_mouseListener.mousePressed(click);
			if(!_receiver.isKeyOn(pitch)){
				result = false;
				break;
			}
			if(pitch == 52){
				pitch ++;
			}else{
				pitch += 2;
			}
		}
		assertTrue(result);
	}

	@Test
	void testBlackKeyLengths(){
		_mouseListener.mousePressed(makeMouseEvent(21,110));
		assertTrue(_receiver.isKeyOn(48));
	}
}
