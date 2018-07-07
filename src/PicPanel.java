import java.awt.EventQueue;

import javax.swing.JInternalFrame;


public class PicPanel extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PicPanel frame = new PicPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PicPanel() {
		setBounds(100, 100, 450, 300);

	}

}
