package domino;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class PrincipalMoverFicha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try { 
			  String className = UIManager.getCrossPlatformLookAndFeelClassName();
			  UIManager.setLookAndFeel(className); 
			  } 
		catch (Exception e) {}
		  
		  EventQueue.invokeLater(new Runnable() {public void run() { GUIsDelJuego myWindow =
		  new GUIsDelJuego(); }});
	}

}
