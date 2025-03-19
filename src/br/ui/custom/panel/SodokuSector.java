package br.ui.custom.panel;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.plaf.DimensionUIResource;

import static java.awt.Color.black;

public class SodokuSector extends JPanel {

    public SodokuSector() {
        var dimension = new DimensionUIResource(170, 170);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setBorder(new LineBorder(black, 2, true));
        this.setVisible(true);
    }
}
