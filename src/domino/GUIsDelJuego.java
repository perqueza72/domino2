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
	private JLabel origen, destino, monto, sacarFicha;
	private JPanel fichasUsuario, campoDeJuego, fichasMaquina, var;
	private ArrayList<JLabel> fichaDelJugador, fichaDeMaquina, fichasExternas;
	private ImageIcon imagen;
	private MouseSacarFicha mouseSacarFicha;
	private MouseJuegoMedio mouseJuegoMedio;
	private PonerFichaEnTablero ponerFichaEnTablero;

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
		campito = new CampoDeJuego();
	}

	private void MenuPrincipal()
	{
        this.getContentPane().removeAll();
        this.repaint();
	    InteraccionBotonInicio interaccionBotonMenu = new InteraccionBotonInicio();
		this.getContentPane().setLayout(new FlowLayout());
		JButton botonInicio = new JButton();

		botonInicio.setText("Jugar");
		botonInicio.addMouseListener(interaccionBotonMenu);
		add(botonInicio);
		monto = new JLabel(Integer.toString(chequera.verMonto()));

	}


	private class InteraccionBotonInicio implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			((JComponent) e.getSource()).setVisible(false);
			//repaint();
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
        this.getContentPane().removeAll();
        this.repaint();
		this.getContentPane().setLayout(new BorderLayout());
		fichasUsuario = new JPanel();
		fichasMaquina = new JPanel();
		campoDeJuego = new JPanel();
		mouseJuegoMedio = new MouseJuegoMedio();
		origen = new JLabel();
		destino = new JLabel();
		imagen = new ImageIcon("src/Fichas/55.png");
		ponerFichaEnTablero = new PonerFichaEnTablero();
		fichasExternas = new ArrayList<>();

		fichasExternas.add(new JLabel(imagen));
		fichasExternas.add(new JLabel(imagen));


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
		fichasUsuario.setPreferredSize(new Dimension(400, 120));
		fichasUsuario.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		fichasMaquina.setAlignmentX(JPanel.LEFT_ALIGNMENT);

		//TERMINADO BARAJA jUGADOR

		fichasMaquina.setPreferredSize(new Dimension(400, 120));
		fichasMaquina.setAlignmentY(JPanel.TOP_ALIGNMENT);
		fichasMaquina.setAlignmentX(JPanel.LEFT_ALIGNMENT);




		//CAMPO DE JUEGO
		imagen = new ImageIcon("src/Fichas/22.png");
		RotatedIcon imgRotada = new RotatedIcon(imagen);
		campito.dibujar();

		int nObjetos =campito.getComponentCount();
		for(int i=0; i<nObjetos; i++) {
			campito.getComponent(i).addMouseListener(ponerFichaEnTablero);
		}




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
		sacarFicha.addMouseListener(mouseSacarFicha);


		//TERMINADO VAR


		add(fichasMaquina, BorderLayout.NORTH);
		add(campito, BorderLayout.CENTER);
		add(fichasUsuario, BorderLayout.SOUTH);
		add(var, BorderLayout.EAST);

	}
	private class PonerFichaEnTablero implements  MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

			campito.getComponent(campito.getComponentCount() - 1).addMouseListener(ponerFichaEnTablero);
			campito.validad(destino, origen.getIcon(), fichasExternas);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			destino = (JLabel)e.getSource();
		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}
	private class MouseJuegoMedio implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e)
		{

		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			origen = ((JLabel)e.getSource());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
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