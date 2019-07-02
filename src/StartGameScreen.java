import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartGameScreen extends JFrame {
	private JPanel mainPanel;

	private GridLayout mainLayout;

	private JButton newGameButton;
	private JButton optionButton;
	private JButton quitButton;

	private String newGameButtonName = "newGameBtn";
	private String optionButtonName = "optionBtn";
	private String quitButtonName = "quitBtn";

	/**
	 * Constructs the main menu.
	 **/
	protected StartGameScreen()
	{
		setTitle("343_IBGA Start Game");
		setPreferredSize(new Dimension(300, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		add(mainMenu());

		pack();
		setVisible(true);
		toFront();
		new PlayerCountScreen(this, true);
	}

	private JPanel mainMenu()
	{
		// Creates the panel
		mainPanel = new JPanel();

		// Sets Layout
		mainLayout = new GridLayout(3, 1, 5, 5);
		mainPanel.setLayout(mainLayout);

		// Creates buttons
		newGameButton = new JButton("New Game");
		optionButton = new JButton("Option");
		quitButton = new JButton("Quit");

		// Sets button commands
		newGameButton.setActionCommand(newGameButtonName);
		optionButton.setActionCommand(optionButtonName);
		quitButton.setActionCommand(quitButtonName);

		// Adds buttons to mainPanel
		mainPanel.add(newGameButton);
		mainPanel.add(optionButton);
		mainPanel.add(quitButton);

		return mainPanel;
	}

	protected void riskViewActionListeners(ActionListener evt)
	{
		newGameButton.addActionListener(evt);
		optionButton.addActionListener(evt);
		quitButton.addActionListener(evt);
	}


	//Testing the UI
	public static void main (String [] args) {
		StartGameScreen test = new StartGameScreen();
	}
}



	

