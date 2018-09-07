import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class XOButton extends JToggleButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean playerOneTurn = true;
	
	XOButton() {
		createActionListener(this);
	}
	
	static void createActionListener(JToggleButton button) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (playerOneTurn == true) {
					button.setText("X");
				} else {
					button.setText("O");
				}
				playerOneTurn = !playerOneTurn;
				if(Grid.checkWin()) {
					Main.switchPanels(Main.window,"end");
				}
				button.setEnabled(false);
			}

		});
	}
}
