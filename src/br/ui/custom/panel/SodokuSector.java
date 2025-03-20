package br.ui.custom.panel;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.plaf.DimensionUIResource;

import br.ui.custom.input.NumberText;

import static java.awt.Color.black;

import java.util.List;

public class SodokuSector extends JPanel {

    public SodokuSector(final List<NumberText> textFields) {
        var dimension = new DimensionUIResource(170, 170);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setBorder(new LineBorder(black, 2, true));
        this.setVisible(true);
        textFields.forEach(this::add);
    }
}
