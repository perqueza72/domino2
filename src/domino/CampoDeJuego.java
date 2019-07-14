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

    public void campoDeJuego()
    {
        this.setLayout(new FlowLayout());
        imagen = new ImageIcon("src/Fichas/Ficha_En_Blanco.png");
        RotatedIcon iconoRotado = new RotatedIcon(imagen, RotatedIcon.Rotate.UPSIDE_DOWN);
        fichasInvisibles = new ArrayList<>();
        int nFichasJugador = 28;
        for(int i = 0; i < nFichasJugador; i++)
        {
            fichasInvisibles.add(new JLabel(imagen));
        }
        JPanel espacio = new JPanel();
		fichasInvisibles.get(0).setFocusable(false);

		espacio.setSize(110, 110);
		espacio.setBackground(Color.red);
		espacio.add(new JLabel(imagen));

		this.add(espacio);
		this.add(Box.createHorizontalStrut(-10));
		this.add(new JPanel().add(new JLabel(imagen)));
		this.add(Box.createHorizontalStrut(-10));
		this.add(fichasInvisibles.get(0));
		this.add(Box.createHorizontalStrut(-10));
		this.add(fichasInvisibles.get(1));
    }

    private class MouseRotar implements MouseListener{

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
