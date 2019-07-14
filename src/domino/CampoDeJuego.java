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
    private Icon imgFicha;
    private ArrayList<JLabel> fichasInvisibles;
    private RotatedIcon iconoRotado;
    private JLabel cosa, origen, destino, auxOrigen;
    private String par0 = "src/Fichas/00.png",par1 = "src/Fichas/11.png",par2 = "src/Fichas/22.png",par3 = "src/Fichas/33.png";
    private String par4 = "src/Fichas/44.png",par5 = "src/Fichas/55.png",par6 = "src/Fichas/66.png";
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
            String direccion = ((JLabel) e.getSource()).getIcon().toString();
                if (direccion == par0 || direccion == par1 || direccion == par2 || direccion == par3 || direccion == par4 || direccion == par5 || direccion == par6) {
                    ImageIcon fichaARotar = (ImageIcon) ((JLabel) e.getSource()).getIcon();
                    RotatedIcon rotar = new RotatedIcon(fichaARotar, RotatedIcon.Rotate.UP);
                    ((JLabel) e.getSource()).setIcon(rotar);
                }
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            destino = (JLabel)e.getSource();
            imgFicha = destino.getIcon();
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            origen.setIcon(imgFicha);
            destino.setIcon(auxOrigen.getIcon());
            auxOrigen.setIcon(destino.getIcon());
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            origen = (JLabel)e.getSource();
            auxOrigen.setIcon(origen.getIcon());
        }
    }
}
