package memory;


import java.util.*;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class GameWindow extends JFrame {

	private int levelGame;
	private JPanel contentPane;
	public static ArrayList<Cbutton> butimge = new ArrayList<Cbutton>();
	private Cbutton cbutton1;
	private Cbutton cbutton2;
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
		GridLayout gameLayout;


		int nbCard;
		//TODO je dois creer le board en fonction du level donnée par la fenetre d'avant....
		switch (lvl) {
		case Affich.LVL_EASY:
			//Je creer mon plateau ICI je sais combien de carte je dois tiré ....
			gameLayout = new GridLayout(3, 3, 0, 0);
			nbCard = 3*3;
			break;
		case Affich.LVL_MEDIUM:
			gameLayout = new GridLayout(6, 6, 0, 0);
			nbCard = 6 * 6;
			break;
		case Affich.LVL_HARD:
		default:
			gameLayout = new GridLayout(8, 8, 0, 0);
			nbCard = 8*8;
			break;

		}
		contentPane.setLayout(gameLayout);
		ArrayList<Cbutton> listeCartes = new ArrayList<Cbutton>();
		int index = 0;
		for(int i = 0 ; i<(nbCard/2); i++) {
			switch (index) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				listeCartes.add(new Cbutton("", "bille" + index, choiximglActionListener));
				listeCartes.add(new Cbutton("", "bille" + index, choiximglActionListener));
				index++;
				break;
			default:
				break;
			}
			if (index > 4) {
				index = 0;
			}
		}
		Collections.shuffle(listeCartes);

		for (Cbutton cbutton : listeCartes) {
			contentPane.add(cbutton);
			//butimge.add(cbutton);


		}

		// on affiche le dos des cartes
		for (Cbutton cbutton : listeCartes) {
			cbutton.setEtat(1);


		}

		//recupcard();

	}

	ActionListener choiximglActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Cbutton btn = (Cbutton) e.getSource();
			if(btn.getEtat() != Cbutton.ETAT_DOS) return;
			btn.setEtat(Cbutton.ETAT_FACE);
			if(cbutton1 == null) {
				cbutton1 = btn;
			}else if(cbutton2 == null) {
				cbutton2 = btn;
				if(cbutton1.equals(cbutton2)) {
					cbutton1.setEtat(Cbutton.ETAT_INVISIBLE);
					cbutton2.setEtat(Cbutton.ETAT_INVISIBLE);
					cbutton1 = null;
					cbutton2 = null;
				}
			}else {
				if(cbutton1.equals(cbutton2)) {
					cbutton1.setEtat(Cbutton.ETAT_INVISIBLE);
					cbutton2.setEtat(Cbutton.ETAT_INVISIBLE);
					cbutton1 = btn;
					cbutton2 = null;
				}else {
					cbutton1.setEtat(Cbutton.ETAT_DOS);
					cbutton2.setEtat(Cbutton.ETAT_DOS);
					cbutton1 = btn;
					cbutton2 = null;
				}
			}
			//verifetat();
			



			//TODO on start le timer

		}

	};

	// recuperer tout les custom button
	public void recupcard()

	{
		int e;
		for (e=0;e<butimge.size();e++) {
			System.out.println(butimge.get(e));
		}
	}

	public void verifetat()

	{
		int e;
		for (e=0;e<butimge.size();e++) {
			System.out.println(butimge.get(e).getEtat());
		}
	}



}
