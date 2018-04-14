package memory;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cbutton extends JButton {
private static final long serialVersionUID = 1L;
	
	private Image imgCroix;
	private Image imgRond;
	
	public static final int ETAT_DEFAULT = 0;
	public static final int ETAT_X = 1;
	public static final int ETAT_O = 2;
	private int etat;
	
	public Cbutton(String text){
		super(text);
		
		URL ressourceCroix;
		URL ressourceRond;
		
		ressourceCroix = getClass().getResource("/immg/bille.jpg");
		//ressourceRond = getClass().getResource("/resources/rond.png");
		
		try {
			imgCroix = ImageIO.read(ressourceCroix);
			//imgRond = ImageIO.read(ressourceRond);
		} catch (IOException e) {
		}
		
		etat = ETAT_DEFAULT;
		
	}
	
	public int getEtat(){
		return this.etat;
	}
	
	public void setEtat(int etat){
		this.etat = etat;
		switch (etat) {
		case ETAT_X:
			setIcon(new ImageIcon(imgCroix));
			break;
		case ETAT_O : 
			setIcon(new ImageIcon(imgRond));
			break;
		default:
			setIcon(null);
			break;
		}
	}
}
