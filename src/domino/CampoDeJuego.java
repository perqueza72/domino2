package domino;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CampoDeJuego extends JPanel {

    private MouseRotar mouseRotar;
    private JPanel campoDeJuego;
    private ImageIcon imagen;
    private ArrayList<JLabel> fichasInvisibles;
    private RotatedIcon iconoRotado;
    private JLabel cosa;
    public void dibujar()
    {
        this.setLayout(new FlowLayout());
        imagen = new ImageIcon("src/Fichas/10.png");
        iconoRotado = new RotatedIcon(imagen, RotatedIcon.Rotate.UP);
        mouseRotar = new MouseRotar();
        fichasInvisibles = new ArrayList<>();
        int nFichasJugador = 28;
        for(int i = 0; i < nFichasJugador; i++)
        {
            fichasInvisibles.add(new JLabel(imagen));
            fichasInvisibles.get(i).addMouseListener(mouseRotar);
        }
        JPanel espacio = new JPanel();
		fichasInvisibles.get(0).setFocusable(false);

		espacio.setSize(110, 110);
		espacio.setBackground(Color.red);
		cosa = new JLabel();
		cosa.setIcon(imagen);
		cosa.addMouseListener(mouseRotar);
		espacio.add(cosa);

		this.add(espacio);
		this.add(Box.createHorizontalStrut(-10));
		this.add(cosa);
		this.add(Box.createHorizontalStrut(-10));
		this.add(fichasInvisibles.get(0));
		this.add(Box.createHorizontalStrut(-10));
		this.add(fichasInvisibles.get(1));
    }

    private class MouseRotar implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e)
        {
            ((JLabel)e.getSource()).setIcon(iconoRotado);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
        }
    }
}
