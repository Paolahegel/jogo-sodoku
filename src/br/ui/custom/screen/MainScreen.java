package br.ui.custom.screen;

import java.awt.Dimension;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ui.custom.frame.MainFrame;
import br.ui.custom.panel.MainPanel;
import service.BoardService;

public class MainScreen {

    private final static Dimension dimension = new Dimension(600, 600);

    private final BoardService boardService;
    private JButton finishGameButton;
    private JButton checkGameButton;
    private JButton resetButton;

    public MainScreen(final Map<String, String> gameConfig) {
        this.boardService = new BoardService(gameConfig);
    }

    public void buildMainScreen(){
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        addResetButton(mainPanel);
        addCheckGamestatusButton(mainPanel);
        addFinishGameButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();                      
    }
                        
    private void addFinishGameButton(final JPanel mainPanel) {
        mainPanel.add(finishGameButton);
    }
        
    private void addCheckGamestatusButton(final JPanel mainPanel) {
        mainPanel.add(checkGameButton);
    }
        
    private void addResetButton(JPanel mainPanel) {
        mainPanel.add(resetButton);
    }
}
