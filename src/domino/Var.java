package domino;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Var {
	private int fichas = 28;
	private ArrayList<JLabel> fichaEnColeccion;
	private ImageIcon imagen;
	private MouseEnInicio mouseEnInicio;
	private Border nonBorder = BorderFactory.createLineBorder(Color.white, 2);
	public void generarFichas() 
	{
		imagen = new ImageIcon("src/imagenes/ficha2.png");;
		for(int i = 0; i < fichas; i++) {
		    fichaEnColeccion.add(new JLabel());
		}
	}
	public int darFicha(int fichasUsuario) 
	{
		Random rand = new Random();
		int fichaDada = rand.nextInt(fichas);
		fichas--;
		fichaEnColeccion.remove(fichaDada);
		return (fichasUsuario+1);
	}
	public void MostrarFichas()
	{
		
		for(int i = 0; i < 27; i++) {
			fichaEnColeccion.get(i).addMouseListener(mouseEnInicio);
			fichaEnColeccion.get(i).setBorder(nonBorder);
			//add(fichaEnColeccion.get(i));
		}
	}
	
	 private class MouseEnInicio implements MouseListener
	 {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	 }
}
