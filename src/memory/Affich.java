package memory;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Affich {

	private JFrame frame;
	public static final int LVL_EASY = 1;
	public static final int LVL_MEDIUM = 2;
	public static final int LVL_HARD = 3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Affich window = new Affich();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Affich() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton ebutton = new JButton("Easy");
		ebutton.addActionListener(choixLvlActionListener);
		//ebutton.setAction(tblo(3,3));
		//ebutton.setActionCommand(arg0);
		frame.getContentPane().add(ebutton);
		
		JButton mbutton = new JButton("Medium");
		mbutton.addActionListener(choixLvlActionListener);
		frame.getContentPane().add(mbutton);
		
		JButton hbutton = new JButton("Hard");
		hbutton.addActionListener(choixLvlActionListener);
		frame.getContentPane().add(hbutton);
	}
	/**
	 * Action par defaut pour savoir quelle niveau veut le joueur
	 */
	ActionListener choixLvlActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			int lvl = 0;
			if(btn.getText().equals("Easy")) {
				lvl = LVL_EASY;
			}else if(btn.getText().equals("Medium")){
				lvl = LVL_MEDIUM;
			}else {
				lvl = LVL_HARD;
			}
			//TODO je creer ma nouvel fenetre 
			GameWindow frame = new GameWindow(lvl);
			
			//Je donne dans son constructeur le lvl choisi par l'utilisateur...
			frame.setVisible(true);
			//Je cache cette fenetre
			Affich.this.frame.setVisible(false);
		}
	};
}
