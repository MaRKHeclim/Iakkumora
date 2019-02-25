package Game;

import Tools.Debug;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
		newGameButton.setSize(200,100);
		newGameButton.setBackground(new Color(30,190,190));
		newGameButton.setMnemonic(KeyEvent.VK_N);
		newGameButton.addActionListener(new StartNewGame());
		
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
		Iakkumora.mainWindow.setUndecorated(true); //no border or title bar must be done while frame is not visible
		Iakkumora.mainWindow.setLayout(new CardLayout());
		Iakkumora.mainWindow.setVisible(true);
		Iakkumora.mainWindow.setSize((int)Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		Iakkumora.mainWindow.setLocationRelativeTo(null);
		Iakkumora.mainWindow.setTitle("Iakkumora");
		Iakkumora.mainWindow.getContentPane().setBackground(new Color(30, 100, 30));
		
		//create a JPanel "card" that will be the main game screen
		PlayScreen playScreen = new PlayScreen();
		//TODO add necessary things to this panel
		
		//Add the frame to the screen
		Iakkumora.mainWindow.add(playScreen, Iakkumora.PLAYSCREEN);
		
		//TODO if necessary add other "card" screens
		
	}
}

