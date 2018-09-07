import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {
	public static Main window;
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					window = new Main();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		this.setSize(750,500);
		setTitle("Tic Tac Toe");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout());

		JPanel startStage = new JPanel();
		startStage.setSize(getWidth(), getHeight());
		startStage.setVisible(true);
		JButton playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) getContentPane().getLayout()).show(getContentPane(), "game");
			}
		});
		startStage.add(new JLabel("Welcome to TicTacToe!"));
		startStage.add(playButton);
		add(startStage, "start");
		Grid gameStage = new Grid(3,3);
		JPanel endStage = new JPanel();
		startStage.setSize(getWidth(), getHeight());
		startStage.setVisible(true);
		JButton mainButton = new JButton("Back to Main Menu");
		mainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) getContentPane().getLayout()).show(getContentPane(), "start");
			}
		});
		endStage.add(mainButton);
		add(startStage, "start");
		add(gameStage, "game");
		add(endStage,"end");
	}
	public static void switchPanels(Main window,String s) {
		((CardLayout) window.getContentPane().getLayout()).show(window.getContentPane(), s);
	}
}