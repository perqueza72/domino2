package domino;


import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Var {
	private ArrayList<JLabel> fichasRobar;

	
	public void generarFichas()
	{
		fichasRobar = new ArrayList<>();
		for(int i = 6; i >= 0; i--) {
			for(int j = i; j >= 0; j--) {
				ImageIcon iconoFicha = new ImageIcon("src/Fichas/" + i + j + ".png");
				fichasRobar.add(new JLabel(iconoFicha));
			}
		}
	}

	public int fichasRestantes()
	{
		return fichasRobar.size();
	}

	public void darFicha(JPanel darA)
	{
		Random rand = new Random();
		int fichaDada = rand.nextInt(fichasRobar.size());
		darA.add(fichasRobar.get(fichaDada));
		darA.repaint();
		darA.revalidate();
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
	}
}
