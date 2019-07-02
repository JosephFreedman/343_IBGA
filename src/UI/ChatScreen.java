package UI;

import javax.swing.*;
import java.awt.*;

public class ChatScreen extends JDialog {
    private JTextArea chatBox;
    private long startTime;

    ChatScreen() {
        setTitle("343_IBGA Chat Screen");
        setPreferredSize(new Dimension(480, 480));

        startTime = System.currentTimeMillis();

        add(initialize());
        pack();
        setVisible(true);
        setAlwaysOnTop(true);

        print("Hello, World!");
    }

    private JPanel initialize() {
        JPanel jPanel = new JPanel();
        chatBox = new JTextArea();
        chatBox.setEditable(false);

        JScrollPane jScrollPane = new JScrollPane(chatBox);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setPreferredSize(new Dimension(450, 450));
        jPanel.add(jScrollPane);

        return jPanel;
    }

    public void print(String chat) {
        long duration = (System.currentTimeMillis() - startTime) / 1000;
        chat = String.format("[:%d] - %s\n", duration, chat);
        chatBox.setText(chatBox.getText() + chat);
        repaint();
    }
}
