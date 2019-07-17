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
	private ArrayList<JLabel> fichasRobar;
	private ImageIcon imagen;
	private MouseEnInicio mouseEnInicio;
	private Border nonBorder = BorderFactory.createLineBorder(Color.white, 2);

	
	public void generarFichas(ArrayList<JLabel> arrayUsuario, ArrayList<JLabel> arrayMaquina)
	{
		fichasRobar = new ArrayList<>();
		for(int i = 6; i >= 0; i--) {
			for(int j = i; j >= 0; j--) {
				ImageIcon iconoFicha = new ImageIcon("src/Fichas/" + i + j + ".png");
				fichasRobar.add(new JLabel(iconoFicha));
			}
		}
	}

	public void darFicha(ArrayList<JLabel> darA)
	{


	}
	public int fichasRestantes()
	{
		return fichasRobar.size();
	}

	public void otroDar(ArrayList<JLabel> darA)
	{
		Random rand = new Random();
		int fichaDada = rand.nextInt(fichasRobar.size());
		darA.get(darA.indexOf(fichasRobar.get(fichaDada))).setVisible(true);
		fichasRobar.remove(fichaDada);
	}
		public void repartirFichasIniciales(ArrayList<JLabel> usuario, ArrayList<JLabel> maquina)
		{
			int fichaDada;
			for(int i = 0; i < 7; i++)
			{
				Random rand = new Random();
				fichaDada = rand.nextInt(fichasRobar.size());
				usuario.add(fichasRobar.get(fichaDada));
				fichasRobar.remove(fichaDada);
				fichaDada = rand.nextInt(fichasRobar.size());
				maquina.add(fichasRobar.get(fichaDada));
				fichasRobar.remove(fichaDada);
			}
			for(int i =0; i<fichasRobar.size(); i++)
			{
				fichasRobar.get(i).setVisible(false);
				maquina.add(fichasRobar.get(i));
				usuario.add(fichasRobar.get(i));
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
