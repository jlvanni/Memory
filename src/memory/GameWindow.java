package memory;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class GameWindow extends JFrame {
	
	private int levelGame;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param lvl 
	 */
	public GameWindow(int lvl) {
		this.levelGame = lvl;
		if(this.levelGame == Affich.LVL_EASY) {
			//TODO il faut faire XX paire car c'est facile
		}else if(this.levelGame == Affich.LVL_MEDIUM) {
			//TODO il faut faire XX paire car c'est medium
		}else {
			//TODO il faut faire XX paire car c'est hard
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		//TODO je dois creer le board en fonction du level donnée par la fenetre d'avant....
		switch (lvl) {
		  case 1:
			  contentPane.setLayout(new GridLayout(3, 3, 0, 0));
		    break;
		  case 2:
			  contentPane.setLayout(new GridLayout(6, 6, 0, 0));
		    break;
		  case 3:
			  contentPane.setLayout(new GridLayout(8, 8, 0, 0));
		    break;
		
		}
		
		
	}

}
