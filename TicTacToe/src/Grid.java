import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Grid extends JPanel{

	private static XOButton[][] button;
	private static int rows;
	private static int cols;
	Grid(int rows, int cols) {
		Grid.rows = rows;
		Grid.cols = cols;
		this.setLayout(new GridLayout(rows, cols));
		button = new XOButton[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				button[i][j] = new XOButton();
				button[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
				this.add(button[i][j]);
			}
		}
	}
	public static boolean checkWin() {
		String[][] text = getButtonText(rows,cols);
		if(checkRowWin(text) || checkColWin(text) || checkDiagonalWin(text)) {
			return true;
		}
		return false;
	}

	private static boolean checkRowWin(String[][] text) {
		
		for (int i = 0; i < rows; i++) {
			if ((text[i][0].equals(text[i][1])) && (text[i][1].equals(text[i][2]))) {
				if (!text[i][0].equals("")) {
					return true;
				}
			}
		}
		return false;

	}

	private static String[][] getButtonText(int rows, int cols) {
		String[][] text = new String[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				text[i][j] = button[i][j].getText();
			}
		}
		return text;
	}
	
	private static boolean checkColWin(String[][] text) {
		for (int i = 0; i < cols; i++) {
			if ((text[0][i].equals(text[1][i])) && (text[1][i].equals(text[2][i]))) {
				if (!text[0][i].equals("")) {
					return true;
				}
			}
		}
		return false;
	}
	private static boolean checkDiagonalWin(String[][] text) {
			if ((text[0][0].equals(text[1][1])) && (text[1][1].equals(text[2][2]))) {
				if (!text[0][0].equals("")) {
					return true;
				}
			} else if((text[0][2].equals(text[1][1])) && (text[1][1].equals(text[2][0]))) {
				if (!text[0][2].equals("")) {
					return true;
				}
			}
			return false;
	}
	public static void disableButtons() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < rows; j++) {
				button[i][j].setEnabled(false);
		}
	}
	}
}
