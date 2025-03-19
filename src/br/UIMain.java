package br;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ui.custom.frame.MainFrame;
import br.ui.custom.panel.MainPanel;

public class UIMain {
    public static void main(String[] args) {
        
        var dimension = new Dimension(600, 600);
        JPanel maiPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, maiPanel);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

}
