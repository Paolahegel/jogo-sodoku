package br;

import java.awt.Dimension;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ui.custom.frame.MainFrame;
import br.ui.custom.panel.MainPanel;
import br.ui.custom.screen.MainScreen;
import static java.util.stream.Collectors.toMap;

public class UIMain {
    public static void main(String[] args) {
        
        final var gameConfig = Stream.of(args)
        .collect(toMap(
            k -> k.split(";")[0],
            v -> v.split(";")[1]
        ));
        var mainsScreen = new MainScreen(gameConfig);
        mainsScreen.buildMainScreen();
    }

}
