package UI;

import Game.RunGame;

import javax.swing.*;
import java.awt.*;

public class MainGameScreen extends JFrame {
    private ChatScreen chatScreen;
    private JTextArea info;
    private String phase;
    private String player;

    public MainGameScreen(int players) {
        setTitle("343_IBGA Main Game");
        setPreferredSize(new Dimension(1280, 720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(initialize());
        pack();
        setVisible(true);

        chatScreen = new ChatScreen();
    }

    private JPanel initialize() {
        JPanel jPanel = new JPanel();
        String infoString = "Current Phase:\nCurrent Player:";

        info = new JTextArea(infoString);
        jPanel.add(info);
        return jPanel;
    }

    public ChatScreen getChatScreen() {
        return chatScreen;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void updateInformation(String phase, String player) {
        String infoString = String.format("Current Phase: %s\nCurrent Player: %s", phase, player);
        info.setText(infoString);
    }
}

// Phase: Beginning the Game
// Roll dice