package br.ui.custom.button;

import javax.swing.Action;
import javax.swing.JButton;

public class ResetButton extends JButton {
    
    public ResetButton(final Action actionListener){
        this.setText("Verificar jogo");
        this.addActionListener(actionListener);
    }

}
