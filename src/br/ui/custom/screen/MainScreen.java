package br.ui.custom.screen;

import java.awt.Dimension;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import br.ui.custom.button.CheckStatusButton;
import br.service.EventEnum;
import br.ui.custom.button.FinishGameButton;
import br.ui.custom.button.ResetButton;
import br.ui.custom.frame.MainFrame;
import br.ui.custom.panel.MainPanel;
import br.ui.custom.panel.SodokuSector;
import service.BoardService;
import br.ui.custom.input.NumberText;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;


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
        finishGameButton = new FinishGameButton(e -> {
            if (boardService.gameIsFinished()) {
                JOptionPane.showConfirmDialog(null, "Parabéns você concluiu o jogo");
                resetButton.setEnabled(false);
                checkGameButton.setEnabled(false);
                finishGameButton.setEnabled(false);
            } else {
                var message = 
                JOptionPane.showConfirmDialog(null, "Seu jogo tem alguma inconsistência, ajuste e tente novamente")
            }
        });
        mainPanel.add(finishGameButton);
    }
        
    private void addCheckGamestatusButton(final JPanel mainPanel) {
        JButton checkGameButton = new CheckStatusButton(e -> {
        var hasErrors = boardService.hasErrors();
        var gameStatus = boardService.getStatus();
        var message = switch (gameStatus){
            case NOT_STARTED -> "O jogo não foi iniciado";
            case INCOMPLETE -> "O jogo está incompleto";
            case COMPLETE -> "O jogo está completo";
        };
        message += hasErrors ? " e contém erros" : " e não contém erros";

        mainPanel.add(checkGameButton);
    });
        
    private void addResetButton(final JPanel mainPanel) {
        JButton resetButton = new ResetButton(e -> {
            var dialogResult = JOptionPane.showConfirmDialog(
                null,
                "Deseja realmente reiniciar o jogo?",
                "Limpar o jogo",
                YES_NO_OPTION,
                QUESTION_MESSAGE
            );
            if (dialogResult == 0) {
                boardService()
            }
        });
        mainPanel.add(resetButton);
    }
}
}
