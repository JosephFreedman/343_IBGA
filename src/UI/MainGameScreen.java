package UI;

import Game.RunGame;

import javax.swing.*;
import java.awt.*;

public class MainGameScreen extends JFrame {
    MainGameScreen(int players) {
        setTitle("343_IBGA Main Game");
        setPreferredSize(new Dimension(1280, 720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        RunGame runGame = new RunGame(players);
    }


}

// Phase: Beginning the Game
// Roll dice