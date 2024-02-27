package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("FUNGUY'S ADVENTURE");
		//add GamePanel to main
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		//load/save config file
		gamePanel.config.loadConfig();
		if(gamePanel.fullScreenOn == true) {
			window.setUndecorated(true);
		}
		
		//pack gamePanel below
		window.pack();
		
		//window location below
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.setupGame();
		
		//calling method from gamePanel
		gamePanel.startGameThread();
		
	}

}