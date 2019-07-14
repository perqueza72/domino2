package domino;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class GUIJuegoInicial extends JFrame{
	
	private static final long serialVersionUID = 1982387610;

	private int contador = 28;
	
	private JLabel destino, fichaBlanca;
	private ArrayList<JLabel> fichaEnColeccion, fichasDeTablero;
	private ImageIcon imagen;
	private Icon imgFicha;
	private MouseJuegoInicial mouseJuegoInicial;
	
	private Border nonBorder = BorderFactory.createLineBorder(Color.white, 2);
	private Border overObject = BorderFactory.createLineBorder(Color.red, 2);
	private Border error = BorderFactory.createLineBorder(Color.CYAN, 2);
	
	public GUIJuegoInicial() {
		MenuPrincipal();
		
		setTitle("Domino");
		this.setResizable(false);
		setSize(800,800);
		this.setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void MenuPrincipal()
	{
		InteraccionBotonInicio interaccionBotonMenu = new InteraccionBotonInicio(); 
		this.getContentPane().setLayout(new FlowLayout());
		JButton botonInicio = new JButton();
		botonInicio.setText("Jugar");
		//botonInicio.setVerticalAlignment(500);
		botonInicio.addMouseListener(interaccionBotonMenu); 
		//botonInicio.setDefaultCapable(true);
		add(botonInicio);
	}	
	
	private class InteraccionBotonInicio implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			((JComponent) e.getSource()).setVisible(false);;
			repaint();
			JuegoInicial();
			
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

	private void JuegoInicial() {
		
		this.getContentPane().setLayout(new FlowLayout());
		mouseJuegoInicial = new MouseJuegoInicial();
		fichaEnColeccion = new ArrayList<JLabel>();
		
		//PONER N FICHAS
		
		for(int i = 6; i >= 0; i--) {
			for(int j = i; j >= 0; j--) {
				imagen = new ImageIcon("src/imagenes/Ficha_" + Integer.toString(i) + "-" + Integer.toString(j) + ".png");
				fichaEnColeccion.add(new JLabel(imagen));
			}
		}
		
		imagen = new ImageIcon("src/imagenes/Ficha_En_Blanco.png");
		fichasDeTablero = new ArrayList<JLabel>();
		
		for(int i = 0; i < 28; i++) // Crea ArrayList con las fichas blancas.
		{
			fichaBlanca = new JLabel(imagen);
			fichasDeTablero.add(fichaBlanca);
		}
		
		for(int i = 0; i < 28; i++) {
			fichasDeTablero.get(i).addMouseListener(mouseJuegoInicial);
			fichasDeTablero.get(i).setBorder(nonBorder);
			add(fichasDeTablero.get(i));
		}
		
	}
	
	private class MouseJuegoInicial implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Random aleatorio = new Random();
			int random = aleatorio.nextInt(contador);
			
			destino = (JLabel)e.getSource();
			
			if(destino.getIcon() == imagen)
			{
				imgFicha = (fichaEnColeccion.get(random)).getIcon();
				
				RotatedIcon imgRotada = new RotatedIcon(imgFicha, RotatedIcon.Rotate.DOWN);
				destino.setIcon(imgRotada);  // ROTACION.
				//destino.setIcon(imgFicha);
				fichaEnColeccion.remove(random);
				contador--;
			}
			else
			{
				((JComponent) e.getSource()).setBorder(error);
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			((JComponent) e.getSource()).setBorder(overObject);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			((JComponent) e.getSource()).setBorder(nonBorder);
		}
		
	}
}
