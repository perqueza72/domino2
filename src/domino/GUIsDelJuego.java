package domino;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class GUIsDelJuego extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5709401444963150583L;
	private JLabel ficha1, origen, destino, auxOrigen = new JLabel();
	private JPanel fichasUsuario, campoDeJuego, fichasMaquina, var;
	private ArrayList<JLabel> fichaDelJugador, fichaDeMaquina, fichaEnColeccion, fichaEnBlanco;
	private ImageIcon imagen;
	private Icon imgFicha;
	private MouseJuegoMedio mouseJuegoMedio;
	private boolean cambiar;
	private int nFichasJugador=4, nFichasMaquina, nFichasVAR;


	private CampoDeJuego campito;

	private Border margin = BorderFactory.createEmptyBorder(0,0,0,0);
	private Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
	private Border nonBorder = BorderFactory.createLineBorder(Color.white, 2);
	private Border overObject =BorderFactory.createLineBorder(Color.red, 2);

	public GUIsDelJuego() {
		MenuPrincipal();

		setTitle("Domino");
		this.setResizable(false);
		setSize(1000, 600);
		this.setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nFichasJugador = 4;
		nFichasMaquina = 4;
		nFichasVAR = 10;
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
			juegoMedio();

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



	private void juegoMedio() {
		cambiar=false;
		this.getContentPane().setLayout(new BorderLayout());
		fichasUsuario = new JPanel();
		fichasMaquina = new JPanel();
		campoDeJuego =new JPanel();
		mouseJuegoMedio = new MouseJuegoMedio();

		imagen = new ImageIcon("src/Fichas/55.png");

		//BARAJA DE LA MAQUINA.

		fichaDeMaquina = new ArrayList<>();
		for(int i = 0; i < nFichasJugador; i++) {
			fichaDeMaquina.add(new JLabel(imagen));
		}
		for(int i = 0; i < nFichasJugador; i++) {
			fichaDeMaquina.get(i).addMouseListener(mouseJuegoMedio);
			fichaDeMaquina.get(i).setBorder(nonBorder);
			fichasMaquina.add(fichaDeMaquina.get(i));
		}

		//TERMINADO MAQUINA

		//CAMPO DE JUEGO



		fichaDeMaquina.get(0).setBorder(new CompoundBorder(null, margin));
		fichaDeMaquina.get(0).setFocusable(false);
		fichaDeMaquina.get(0).removeMouseListener(mouseJuegoMedio);
		fichaDeMaquina.get(1).setBorder(new CompoundBorder(null, margin));
		JPanel espacio = new JPanel();
		espacio.setSize(110, 110);
		espacio.setBackground(Color.red);
		espacio.add(new JLabel(imagen));
		campoDeJuego.add(espacio);
		campoDeJuego.add(Box.createHorizontalStrut(-10));
		campoDeJuego.add(new JPanel().add(new JLabel(imagen)));
		campoDeJuego.add(Box.createHorizontalStrut(-10));
		campoDeJuego.add(fichaDeMaquina.get(0));
		campoDeJuego.add(Box.createHorizontalStrut(-10));
		campoDeJuego.add(fichaDeMaquina.get(1));


		campito = new CampoDeJuego();
		campito.dibujar();
		int nObjetos =campito.getComponentCount();
		for(int i=0; i<nObjetos; i++) {
			campito.getComponent(i).addMouseListener(mouseJuegoMedio);
		}
		add(campito);





		campoDeJuego.setPreferredSize(new Dimension(800, 300));
		campoDeJuego.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		campoDeJuego.setBackground(Color.BLUE);



		imagen = new ImageIcon("src/Fichas/22.png");
		//TERMINADO CAMPO DE JUEGO

		//VAR.

		var = new JPanel();
		var.setPreferredSize(new Dimension(50, 400));
		var.setBackground(Color.ORANGE);
		var.setAlignmentX(JPanel.RIGHT_ALIGNMENT);

		//TERMINADO VAR

		//BARAJA DEL JUGADOR.

		fichaDelJugador = new ArrayList<JLabel>();
		for(int i = 0; i < nFichasJugador; i++) {
			fichaDelJugador.add(new JLabel(imagen));
		}
		for(int i = 0; i < nFichasJugador; i++) {
			fichaDelJugador.get(i).addMouseListener(mouseJuegoMedio);
			fichaDelJugador.get(i).setBorder(nonBorder);
			fichasUsuario.add(fichaDelJugador.get(i));
		}
		fichasUsuario.setPreferredSize(new Dimension(400, 100));
		fichasUsuario.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		fichasMaquina.setAlignmentX(JPanel.LEFT_ALIGNMENT);

		//TERMINADO BARAJA jUGADOR

		//GRAFICAR ENTORNO

		fichasMaquina.setPreferredSize(new Dimension(400, 100));
		fichasMaquina.setAlignmentY(JPanel.TOP_ALIGNMENT);
		fichasMaquina.setAlignmentX(JPanel.LEFT_ALIGNMENT);

		add(fichasMaquina, BorderLayout.NORTH);
		//add(campoDeJuego, BorderLayout.CENTER);
		add(fichasUsuario, BorderLayout.SOUTH);
		add(var, BorderLayout.EAST);

	}
	
	private class MouseJuegoMedio implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(cambiar && (JLabel)e.getSource() != origen)
			{
				((JLabel) e.getSource()).setBorder(overObject);
			}
			destino = (JLabel)e.getSource();
			imgFicha = destino.getIcon();
		}
		//@Override
		//public void mouseDoubleClicked(MouseEvent e)
		//{

		//}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(cambiar && (JLabel)e.getSource() != origen)
			{
				((JComponent) e.getSource()).setBorder(nonBorder);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			cambiar = true;
			origen = (JLabel)e.getSource();
			auxOrigen.setIcon(origen.getIcon());
			((JLabel) e.getSource()).setBorder(border);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			origen.setIcon(imgFicha);
			destino.setIcon(auxOrigen.getIcon());
			auxOrigen.setIcon(destino.getIcon());
			cambiar = false;
			((JLabel) e.getSource()).setBorder(nonBorder);
		}
	}

}
