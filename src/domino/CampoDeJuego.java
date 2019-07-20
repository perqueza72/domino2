package domino;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.swing.*;
import java.awt.*;

public class CampoDeJuego extends JPanel {
    private String par0 = "src/Fichas/00.png",par1 = "src/Fichas/11.png",par2 = "src/Fichas/22.png",par3 = "src/Fichas/33.png";
    private String par4 = "src/Fichas/44.png",par5 = "src/Fichas/55.png",par6 = "src/Fichas/66.png";
    private GridBagConstraints cIzq, cDer;
    private JLabel cen;
    private int fichasIzq=0, fichasDer=0, rIzq=-2, rDer=3, rutaDer=1, rutaIzq=-1;
    private boolean rotarIzq = true, rotarDer = true;

    public void dibujar(Icon primerFicha) {
        this.setLayout(new GridBagLayout());
        cIzq = new GridBagConstraints();
        cDer = new GridBagConstraints();
        cIzq.gridwidth =3;
        cIzq.gridheight = 3;
        cDer.gridwidth =3;
        cDer.gridheight = 3;

        int cXInicial = 240, cYInicial=100;
        this.setBackground(Color.blue);

        int x = 800;
        int y = 600;
        this.setPreferredSize(new Dimension(x, y));
        cen = new JLabel(primerFicha);
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
        cIzq.gridheight = 3;
        cIzq.gridwidth = 3;
        Icon iconoFicha = label.getIcon();
        rIzq=3*rutaIzq;
       if(PonerFichaEn == 1) {
            fichasIzq++;
           if((fichasIzq%6 == 0 || fichasIzq%7==0 || fichasIzq%8==0) && rotarIzq) {
               RotatedIcon rotada = new RotatedIcon(iconoFicha, 90);
               label.setIcon(rotada);

               if(fichasIzq%6 == 0) {
                   rutaIzq *= -1;
                   cIzq.gridx-=3;
               }else {
                   cIzq.gridy -= 3;
                   cIzq.gridy-=3;
                   rotarIzq=false;
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
            rDer = 3 * rutaDer;

            if((fichasDer%6 == 0 || fichasDer%7==0 || fichasDer%8==0) && rotarDer) {
                RotatedIcon rotada = new RotatedIcon(iconoFicha, 90);
                label.setIcon(rotada);

                if(fichasDer%6 == 0) {
                    rutaDer *= -1;
                    cDer.gridx+=3;
                }else {
                    cDer.gridy += 3;
                    cDer.gridy+=3;
                    rotarDer=false;
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

}
