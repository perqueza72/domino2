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
	private JLabel origen, destino, auxOrigen = new JLabel(), imgSocket, imgSocketRotated, monto, sacarFicha;
	private JPanel fichasUsuario, campoDeJuego, fichasMaquina, var;
	private ArrayList<JLabel> fichaDelJugador, fichaDeMaquina, fichaEnColeccion, fichaEnBlanco;
	private ImageIcon imagen;
	private Icon imgFicha;
	private MouseSacarFicha mouseSacarFicha;
	private int nFichasJugador=4, nFichasMaquina, nFichasVAR;
	private boolean bloquear, socketRotated, cambiar;

	private CampoDeJuego campito;

	private Border margin = BorderFactory.createEmptyBorder(0,0,0,0);
	private Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
	private Border nonBorder = BorderFactory.createLineBorder(Color.white, 2);
	private Border overObject =BorderFactory.createLineBorder(Color.red, 2);

	private Wallet chequera = new Wallet();
	private Var robar = new Var();

	public GUIsDelJuego() {
		MenuPrincipal();

		setTitle("Domino");
		this.setResizable(false);
		setSize(1800, 1024);
		this.setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nFichasJugador = 4;
		nFichasMaquina = 4;
		nFichasVAR = 10;
		campito = new CampoDeJuego();
	}

	private void MenuPrincipal()
	{
		InteraccionBotonInicio interaccionBotonMenu = new InteraccionBotonInicio();
		this.getContentPane().setLayout(new FlowLayout());
		JButton botonInicio = new JButton();
		botonInicio.setText("Jugar");
		botonInicio.addMouseListener(interaccionBotonMenu);
		add(botonInicio);
		monto = new JLabel(Integer.toString(chequera.verMonto()));
		add(monto);

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
		MouseJuegoMedio mouseJuegoMedio;
		this.getContentPane().setLayout(new BorderLayout());
		fichasUsuario = new JPanel();
		fichasMaquina = new JPanel();
		campoDeJuego = new JPanel();
		mouseJuegoMedio = new MouseJuegoMedio();

		imagen = new ImageIcon("src/Fichas/55.png");
		imgSocket = new JLabel();
		imgSocket.setIcon(new ImageIcon("src/Fichas/camino.png"));
		imgSocketRotated = new JLabel();
		imgSocketRotated.setIcon(new ImageIcon("src/Fichas/space.png"));




		//BARAJA DE LA MAQUINA.

		fichaDeMaquina = new ArrayList<JLabel>();
		fichaDelJugador = new ArrayList<JLabel>();
		robar.generarFichas(fichaDelJugador, fichaDeMaquina);
		robar.repartirFichasIniciales(fichaDelJugador, fichaDeMaquina);

		for(int i = 0; i < fichaDeMaquina.size(); i++)
		{
			fichaDeMaquina.get(i).addMouseListener(mouseJuegoMedio);
			fichaDeMaquina.get(i).setBorder(nonBorder);
			fichasMaquina.add(fichaDeMaquina.get(i));
		}
		//TERMINADO MAQUINA
		//BARAJA DEL JUGADOR.
		for(int i = 0; i < fichaDelJugador.size(); i++) {
			fichaDelJugador.get(i).addMouseListener(mouseJuegoMedio);
			fichaDelJugador.get(i).setBorder(nonBorder);
			fichasUsuario.add(fichaDelJugador.get(i));
		}
		fichasUsuario.setPreferredSize(new Dimension(400, 100));
		fichasUsuario.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		fichasMaquina.setAlignmentX(JPanel.LEFT_ALIGNMENT);

		//TERMINADO BARAJA jUGADOR

		fichasMaquina.setPreferredSize(new Dimension(400, 100));
		fichasMaquina.setAlignmentY(JPanel.TOP_ALIGNMENT);
		fichasMaquina.setAlignmentX(JPanel.LEFT_ALIGNMENT);





		//CAMPO DE JUEGO


		campito.dibujar();
		campito.add(monto);
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
		mouseSacarFicha = new MouseSacarFicha();
		var = new JPanel();
		sacarFicha = new JLabel("Sacar ficha");
		var.setPreferredSize(new Dimension(200, 400));
		var.setBackground(Color.ORANGE);
		var.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		var.add(new JLabel("Monto: " + chequera.verMonto()));
		var.add(monto);
		var.add(sacarFicha);
		monto.removeMouseListener(mouseJuegoMedio);
		sacarFicha.removeMouseListener(mouseJuegoMedio);
		sacarFicha.addMouseListener(mouseSacarFicha);


		//TERMINADO VAR


		add(fichasMaquina, BorderLayout.NORTH);
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
			destino = (JLabel)e.getSource();
			imgFicha = destino.getIcon();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			String nulo = null;
			if((destino.getIcon().toString()).equals(imgSocket.getIcon().toString()))
			{
				origen = destino;
				auxOrigen.setIcon(imgFicha);
				bloquear = false;
				cambiar = false;
			}
			else if(destino.getIcon().toString().equals(imgSocketRotated.getIcon().toString()))
			{
				origen = destino;
				auxOrigen.setIcon(imgSocketRotated.getIcon());
				bloquear = false;
				cambiar = false;
			}
			else if(nulo == destino.getName())
			{
				origen = (JLabel)e.getSource();
				auxOrigen.setIcon(origen.getIcon());
				bloquear = true;
				cambiar = true;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			String nulo = null;
			String quePasa = destino.getIcon().toString();
			
			
			for(int i = 0; i < 1; i++) {
				if((quePasa.substring(i, 1)).equals("d")) {
					socketRotated = true;
					imgSocketRotated.setIcon(destino.getIcon());
				}
				else
					socketRotated = false;
			}
			
			if((((destino.getIcon().toString()).equals(imgSocket.getIcon().toString())) || socketRotated) &&
				(nulo == destino.getName()) && cambiar)
			{
				for(int i = 0; i < nFichasJugador; i++)
				{
					if((fichasUsuario.getComponent(i)).equals(origen))
					{
						fichasUsuario.getComponent(i).setVisible(false);
						fichasUsuario.remove(i);
						fichaDelJugador.remove(origen);
						nFichasJugador--;
					}
				}
				
				destino.setIcon(auxOrigen.getIcon());
				if(bloquear)
					destino.setName("DontMove");
				
				if(origen.getIcon().toString().equals(imgSocketRotated.getIcon().toString())) {
					origen = imgSocketRotated;
					auxOrigen.setIcon(imgSocketRotated.getIcon());
				}
				else {
					origen = imgSocket;
					auxOrigen.setIcon(imgSocket.getIcon());
				}
				
				bloquear = false;
			}
		}
	}

	private class MouseSacarFicha implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(robar.fichasRestantes() != 0) {
				robar.otroDar(fichaDelJugador);
				((JLabel) e.getSource()).setText(Integer.toString(robar.fichasRestantes()));
			}
			else
				((JLabel)e.getSource()).setText("0");
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

	}
}