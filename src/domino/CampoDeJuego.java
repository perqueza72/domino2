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
        imagen = new ImageIcon("src/Fichas/00.png");
        iconoRotado = new RotatedIcon(imagen, RotatedIcon.Rotate.UP);
        mouseRotar = new MouseRotar();
        fichasInvisibles = new ArrayList<>();
        int nFichasJugador = 28;
        for(int i = 0; i < nFichasJugador; i++)
        {
            fichasInvisibles.add(new JLabel(imagen));
            fichasInvisibles.get(i).addMouseListener(mouseRotar);
        }
		fichasInvisibles.get(0).setFocusable(false);

		cosa = new JLabel();
		cosa.setIcon(new ImageIcon("src/Fichas/10.png"));
		cosa.addMouseListener(mouseRotar);

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
            for(int i=0; i<7; i++) {
                if (((JLabel) e.getSource()).getIcon().toString() == "src/Fichas/"+i+i+".png") {
                    ImageIcon fichaARotar = (ImageIcon) ((JLabel) e.getSource()).getIcon();
                    RotatedIcon rotar = new RotatedIcon(fichaARotar, RotatedIcon.Rotate.UP);
                    ((JLabel) e.getSource()).setIcon(rotar);
                    break;
                }
            }


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
