package br.ui.custom.button;

import javax.swing.Action;
import javax.swing.JButton;

public class CheckStatusButton extends JButton {
    
    public CheckStatusButton(final Action actionListener){
        this.setText("Verificar jogo");
        this.addActionListener(actionListener);
    }
}
