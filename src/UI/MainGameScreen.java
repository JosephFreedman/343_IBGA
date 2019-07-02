package UI;

import Game.Dice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGameScreen extends JFrame {
    private ChatScreen chatScreen;
    private JTextArea info;
    private String phase;
    private String player;

    private JButton rollDice;

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

        rollDice = new JButton("Roll Dice");
        ActionListener evt = (ActionEvent event) -> {
            //System.out.println(event.getActionCommand());
            int diceRoll = new Dice().getRoll();
            chatScreen.print("You rolled a " + diceRoll + " on the dice");
        };
        rollDice.addActionListener(evt);

        jPanel.add(rollDice);
        return jPanel;
    }

    public ChatScreen getChatScreen() {
        return chatScreen;
    }

    public void setPhase(String phase) {
        this.phase = phase;
        updateInformation();
    }

    public void setPlayer(String player) {
        this.player = player;
        updateInformation();
    }

    private void updateInformation() {
        String infoString = String.format("Current Phase: %s\nCurrent Player: %s", phase, player);
        info.setText(infoString);
    }
}
