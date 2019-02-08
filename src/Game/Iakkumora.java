package Game;

import Tools.Debug;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Iakkumora extends javax.swing.JFrame
{
	Debug debug = new Debug("Iakkumora", true, false);
	public static void main(String[] args) 
	{
		// Call Iakkumora Constructor
		Iakkumora game = new Iakkumora();
		// Call Iakkumora Start Game
		game.startGame();
		
	}
	
	Iakkumora game;
	Iakkumora() // constructor
	{
		
		
	}
	
	void startGame() //main method
	{
		game = new Iakkumora();
		game.setLayout(new FlowLayout());
		game.setVisible(true);
		game.setSize(650, 560);
		game.setLocationRelativeTo(null);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setTitle("Iakkumora");
		game.setBackground(new Color(160, 30, 120));
		
		JButton newGameButton = new JButton("New Game");
		newGameButton.setSize(200,100);
		newGameButton.setBackground(new Color(30,190,190));
		newGameButton.setMnemonic(KeyEvent.VK_N);
		
		
		game.add(newGameButton);
	}
}
