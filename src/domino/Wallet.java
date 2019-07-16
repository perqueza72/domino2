package domino;

import javax.swing.*;

public class Wallet {
    private int amount = 100;

    public void actualizarDinero(boolean win, JLabel mostrarDinero)
    {
        if(win)
            amount+=10;
        else
            amount-=10;
        mostrarDinero.setText(Integer.toString(amount));
    }
    public boolean puedeJugar()
    {
        if(amount < 10)
        {
            return false;
        }
        return true;
    }
    public int verMonto()
    {
        return amount;
    }
}
