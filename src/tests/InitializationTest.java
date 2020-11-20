package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.EventQueue;
import javax.swing.*;
import org.junit.jupiter.api.Test;
import main.Application;
import main.PearWindow;
import main.Store;

class InitializationTest extends JFrame {
	
	private JFrame frame;
		
	@Test
	void removeFrame() throws Exception {
		
		if(frame != null) {
			frame.dispose();
			frame = null;
		}
		
		assertEquals(null, frame);
		
	}
	
	@Test
	JFrame setupTest() {
		
		if(frame == null) {
			frame = new JFrame();
			assertNotEquals(null, frame);
		}
		return frame;
		
	}

}
