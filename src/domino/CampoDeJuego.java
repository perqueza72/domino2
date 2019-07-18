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
    final private int w = 98, h = 48;

    public void dibujar() {
        cIzq = new GridBagConstraints();
        cDer = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.blue);
        int x = 800;
        int y = 600;
        this.setPreferredSize(new Dimension(x, y));
        JLabel izq = new JLabel(new ImageIcon("src/Fichas/camino.png"));
        JLabel cen = new JLabel(new ImageIcon("src/Fichas/11.png"));
        JLabel der = new JLabel(new ImageIcon("src/Fichas/camino.png"));
        add(izq, cIzq);
        cIzq.gridx+=240;
        add(cen, cIzq);
        cDer.gridx=cIzq.gridx+60;
        add(der, cDer);
        cIzq.gridx=0;
    }
    public void validad(JLabel label, Icon icono, ArrayList<JLabel> puntas)
    {
        JLabel espacio = new JLabel(new ImageIcon("src/Fichas/camino.png"));
        contador++;
        cIzq.gridx+=1;
        add(espacio, cIzq);
        cIzq.gridx+=1;
        label.setIcon(icono);

        //puntas.get(0).setIcon(icono);
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
