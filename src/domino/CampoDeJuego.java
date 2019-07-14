package domino;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observer;

public class CampoDeJuego extends JPanel {

    private MouseRotar mouseRotar;
    private JPanel campoDeJuego;
    private ImageIcon camino;
    private Icon imgFicha;
    private ArrayList<JLabel> fichasInvisibles;
    private RotatedIcon iconoRotado;
    private JLabel cosa, origen, destino, auxOrigen = new JLabel();
    private String par0 = "src/Fichas/00.png",par1 = "src/Fichas/11.png",par2 = "src/Fichas/22.png",par3 = "src/Fichas/33.png";
    private String par4 = "src/Fichas/44.png",par5 = "src/Fichas/55.png",par6 = "src/Fichas/66.png";
    public void dibujar() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        camino = new ImageIcon("src/Fichas/camino.png");
        RotatedIcon rotado = new RotatedIcon(camino, RotatedIcon.Rotate.UP);
        mouseRotar = new MouseRotar();
        fichasInvisibles = new ArrayList<>();
        int nFichasCamino = 54;
        for (int i = 0; i < nFichasCamino; i++) {
            if (i % 10 == 0) {
                fichasInvisibles.add(new JLabel(rotado));
            } else {
                fichasInvisibles.add(new JLabel(camino));
            }
            fichasInvisibles.get(i).addMouseListener(mouseRotar);
        }

        int tamano = 50;
        for (int i = 0; i < nFichasCamino; i++) {
            this.add(Box.createHorizontalStrut(-10));
            if(i%10 == 0) {
                if(i%20 == 0)
                    c.gridx=8*60;
                else
                    c.gridx=0;
                c.gridy+=60;
                this.add(fichasInvisibles.get(i), c);
                c.gridy+=60;
                c.gridx=0;
            }
            else
                {
                    this.add(fichasInvisibles.get(i), c);
                    c.gridx+=60;
                }
        }
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
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
        }
    }
}
