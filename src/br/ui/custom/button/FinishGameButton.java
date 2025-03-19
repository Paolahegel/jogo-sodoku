package br.ui.custom.button;

import javax.swing.Action;
import javax.swing.JButton;

public class FinishGameButton extends JButton {

    public FinishGameButton(final Action actionListener){
        this.setText("Concluir");
        this.addActionListener(actionListener);
    }
}
