package memory;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cbutton extends JButton {
private static final long serialVersionUID = 1L;
	
	private Image imgFace;
	private Image imgDos;
	private String nomImage;
	
	public static final int ETAT_INVISIBLE = 0;
	public static final int ETAT_DOS = 1;
	public static final int ETAT_FACE = 2;
	//public static final String choix_card;
	//private String choix_card;
	private int etat;
	
	public Cbutton(String text, String imageBtn, ActionListener actionListener){
		super(text);
		
		URL ressourceDos;
		URL ressourceFace;
		nomImage = imageBtn;
		ressourceFace= getClass().getResource("/resources/"+imageBtn+".jpg");
		ressourceDos = getClass().getResource("/resources/dos.jpg");
		
		try {
			imgFace = ImageIO.read(ressourceFace);
			imgDos = ImageIO.read(ressourceDos);
		} catch (IOException e) {
		}
		setIcon(new ImageIcon(imgFace));
		etat = ETAT_DOS;
		addActionListener(actionListener);
	}
	
	public int getEtat(){
		return this.etat;
	}
	
	public void setEtat(int etat){
		this.etat = etat;
		
		switch (etat) {
		case ETAT_DOS:
			setIcon(new ImageIcon(imgDos));
			break;
		case ETAT_FACE : 
			setIcon(new ImageIcon(imgFace));
			break;
		default:
			setVisible(false) ;
			break;
		}
		repaint(); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomImage == null) ? 0 : nomImage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cbutton other = (Cbutton) obj;
		if (nomImage == null) {
			if (other.nomImage != null)
				return false;
		} else if (!nomImage.equals(other.nomImage))
			return false;
		return true;
	}
	
	

}
