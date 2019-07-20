package domino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CampoDeJuego extends JPanel {
    private int contador=0;
    private MouseRotar mouseRotar;
    private JPanel campoDeJuego, centro, izquierdo, derecha;
    private ImageIcon camino;
    private Icon imgFicha;
    private ArrayList<JLabel> fichasInvisibles;
    private RotatedIcon iconoRotado;
    private JLabel cosa, origen, destino, auxOrigen = new JLabel();
    private String par0 = "src/Fichas/00.png",par1 = "src/Fichas/11.png",par2 = "src/Fichas/22.png",par3 = "src/Fichas/33.png";
    private String par4 = "src/Fichas/44.png",par5 = "src/Fichas/55.png",par6 = "src/Fichas/66.png";
    private GridBagConstraints cIzq, cDer;
    private int w = 98, h = 48, fichasIzq=0, fichasDer=0, rIzq=-1, rDer=2;

    public void dibujar() {
        cIzq = new GridBagConstraints();
        cDer = new GridBagConstraints();
        int cXInicial = 240, cYInicial=100;
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.blue);

        int x = 800;
        int y = 600;
        this.setPreferredSize(new Dimension(x, y));
        JLabel cen = new JLabel(new ImageIcon("src/Fichas/11.png"));
        cIzq.gridx = cXInicial;
        cIzq.gridy = cYInicial;
        add(cen, cIzq);
        cIzq.gridx = cXInicial-1;
        cIzq.gridy = cYInicial;
        cDer.gridx = cXInicial+1;
        cDer.gridy = cYInicial;
    }
    public void ponerFichaEnCampo(JLabel label, int PonerFichaEn)
    {
        //ToDo
        if(PonerFichaEn == 1)
        {
            fichasIzq++;
            if(fichasIzq%6==0 || fichasIzq%7==0) {
                cIzq.gridy-=2;
                if(fichasIzq%6==0)
                {
                    RotatedIcon rotada = new RotatedIcon(label.getIcon(), 90);
                    label.setIcon(rotada);
                    rIzq*=-1;
                }
            }
            else {
                cIzq.gridx+= rIzq;
            }
            add(label, cIzq);
        }
        if(PonerFichaEn == 2)
        {
            fichasDer++;
            if(fichasDer%6==0 || fichasDer%7==0) {
                cDer.gridy+=2;
                if(fichasDer%6==0)
                {
                    RotatedIcon rotada = new RotatedIcon(label.getIcon(), 90);
                    label.setIcon(rotada);
                    rDer*=-1;
                }
            }
            else {
                cDer.gridx+= rDer;
            }
            add(label, cDer);
        }

        repaint();
        revalidate();
    }

    private class MouseRotar implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e)
        {
            /*((JPanel)e.getSource()).add(new JLabel(iconoRotado));
            String direccion = ((JLabel) e.getSource()).getIcon().toString();
                if (direccion == par0 || direccion == par1 || direccion == par2 || direccion == par3 || direccion == par4 || direccion == par5 || direccion == par6) {
                    ImageIcon fichaARotar = (ImageIcon) ((JLabel) e.getSource()).getIcon();
                    RotatedIcon rotar = new RotatedIcon(fichaARotar, RotatedIcon.Rotate.UP);
                    ((JLabel) e.getSource()).setIcon(rotar);
                }
                */
                JLabel auxs = new JLabel(new ImageIcon("src/Fichas/21.png"));
                auxs.addMouseListener(mouseRotar);

        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e)
        {

        }
    }
}
