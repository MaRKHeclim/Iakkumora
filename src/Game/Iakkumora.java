package Game;

import Tools.Debug;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Iakkumora extends javax.swing.JFrame //basically this class is a JFrame
{
	
	public static void main(String[] args) 
	{
		Debug debug = new Debug("Iakkumora - main", true, false);
		
		// Call Iakkumora Constructor
		Iakkumora game = new Iakkumora();
		// Call Iakkumora Start Game
		game.startGame();
		
	}
	
	//this is the first window that shows up
	Iakkumora launcherWindow;
	
	//this is the main window
	static JFrame mainWindow;
	
	//this string returns the main game screen when
	// Iakkumora.mainWindow.getLayout().show(Iakkumora.mainWindow, Iakkumora.MAINSCREEN)
	static String PLAYSCREEN = "PlayScreen";
	
	Iakkumora() // constructor
	{
		
		
	}
	
	void startGame() //main method
	{
		//create main window set settings for it
		launcherWindow = new Iakkumora();
		launcherWindow.setLayout(new FlowLayout());
		launcherWindow.setVisible(true);
		launcherWindow.setSize(650, 560);
		launcherWindow.setLocationRelativeTo(null);
		launcherWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		launcherWindow.setTitle("Iakkumora");
		launcherWindow.getContentPane().setBackground(new Color(160, 30, 120));
		
		//create a new game button
		//that when pressed calls the actionPerformed method of the StartNewGame class
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new StartNewGame());
		newGameButton.setSize(200,100);
		newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		newGameButton.setBackground(new Color(30,190,190));
		newGameButton.setMnemonic(KeyEvent.VK_N);
		
		
		//add the new game button to the main window
		launcherWindow.add(newGameButton);
	}
}

class StartNewGame implements ActionListener //this exists for the newGameButton
{
	@Override
	public void actionPerformed(ActionEvent e) //this is called when the newGameButton is clicked
	{
		//set up main game window
		Iakkumora.mainWindow = new JFrame();
		Iakkumora.mainWindow.addWindowListener(new WL());
		Iakkumora.mainWindow.setUndecorated(true); //no border or title bar must be done while frame is not visible
		Iakkumora.mainWindow.setLayout(new CardLayout());
		Iakkumora.mainWindow.setVisible(true);
		Iakkumora.mainWindow.setSize((int)Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		Iakkumora.mainWindow.setLocationRelativeTo(null);
		Iakkumora.mainWindow.setTitle("Iakkumora");
		Iakkumora.mainWindow.getContentPane().setBackground(new Color(30, 100, 30));
		Iakkumora.mainWindow.addKeyListener(new KL());
		Iakkumora.mainWindow.addMouseListener(new ML());
		
		
		//create a JPanel "card" that will be the main game screen
		PlayScreen playScreen = new PlayScreen();
		//TODO add necessary things to this panel
		
		//Add the frame to the screen
		Iakkumora.mainWindow.add(playScreen, Iakkumora.PLAYSCREEN);
		
		//TODO if necessary add other "card" screens
		
	}
	
	
	//TODO Keyboard Events
	//Adapter over listener so that not all methods have to be defined
	//there is a keyTyped event that may be useful if non-keyboard characters may be entered
	//		for example if an alt-code is used - it may??? provide the character
	// 			≈ instead of ALT, 0, 2, 4, 7...
	private class KL extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			Debug debug = new Debug("PlayScreen - KL - keyPressed", true, false);
			debug.log("made it!");
			
			int keyCode = e.getKeyCode();
			
			debug.log(Integer.toString(keyCode));
			
			switch (keyCode) {
				case KeyEvent.VK_ESCAPE:
					//TODO add a prompt hefore exiting
					System.exit(0);
					break;
				
				default:
					
					break;
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e)
		{
			Debug debug = new Debug("PlayScreen - KL - keyReleased", true, false);
			debug.log("made it!");
			
			int keyCode = e.getKeyCode();
			
			debug.log(Integer.toString(keyCode));
			
			
			switch (keyCode) {
				default:
					
					break;
			}
		}
	}
	
	//TODO Mouse Events
	private class ML extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e)
		{
		
		}
	}
	
	//TODO Window Events
	private class WL extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e)
		{
			//try {Thread.currentThread().join();} catch (interruptedException ex) {}
		}
	}
}

