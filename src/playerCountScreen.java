

import java.awt.Dimension;
import java.awt.GridLayout;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;


public class playerCountScreen extends JDialog {
	private JPanel playerCountPanel;
	
	private GridLayout playerCountLayout;
	
	private JLabel playerCountLabel;

	private JButton twoPlayersBtn;
	private JButton threePlayersBtn;
	private JButton fourPlayersBtn;
	private JButton fivePlayersBtn;
	private JButton sixPlayersBtn;
	private JButton sevenPlayersBtn;
	private JButton eightPlayersBtn;
	private JButton backBtn;
	
	private String twoPlayersBtnName = "twoPlayersBtn";
	private String threePlayersBtnName = "threePlayersBtn";
	private String fourPlayersBtnName = "fourPlayersBtn";
	private String fivePlayersBtnName = "fivePlayersBtn";
	private String sixPlayersBtnName = "sixPlayersBtn";
	private String sevenPlayersBtnName = "sevenPlayersBtn";
	private String eightPlayersBtnName = "eightPlayersBtn";
	private String backBtnName = "backBtn";
	
	/**
	 * Player count selection.
	 **/
	protected playerCountScreen(startGameScreen owner, boolean modality)
	{
		super(owner, modality);
		setTitle("343_IBGA");
		
		setPreferredSize(new Dimension(150, 280));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		
		add(playerCountPanel());
		
		setLocationRelativeTo(null);
		
		pack();
	}
	
	/**
	 * The main panel.
	 **/
	private JPanel playerCountPanel()
	{
		playerCountPanel = new JPanel();
		
		playerCountLayout = new GridLayout(9, 1, 5, 5);
		playerCountPanel.setLayout(playerCountLayout);
		
		playerCountLabel = new JLabel("Number of Players:");
		
		twoPlayersBtn = new JButton("Two");
		threePlayersBtn = new JButton("Three");
		fourPlayersBtn = new JButton("Four");
		fivePlayersBtn = new JButton("Five");
		sixPlayersBtn = new JButton("Six");
		sevenPlayersBtn = new JButton("Seven");
		eightPlayersBtn = new JButton("Eight");
		backBtn = new JButton ("Back");
		
		twoPlayersBtn.setActionCommand(twoPlayersBtnName);
		threePlayersBtn.setActionCommand(threePlayersBtnName);
		fourPlayersBtn.setActionCommand(fourPlayersBtnName);
		fivePlayersBtn.setActionCommand(fivePlayersBtnName);
		sixPlayersBtn.setActionCommand(sixPlayersBtnName);
		sevenPlayersBtn.setActionCommand(sevenPlayersBtnName);
		eightPlayersBtn.setActionCommand(eightPlayersBtnName);
		backBtn.setActionCommand(backBtnName);
		
		playerCountPanel.add(playerCountLabel);
		playerCountPanel.add(twoPlayersBtn);
		playerCountPanel.add(threePlayersBtn);
		playerCountPanel.add(fourPlayersBtn);
		playerCountPanel.add(fivePlayersBtn);
		playerCountPanel.add(sixPlayersBtn);
		playerCountPanel.add(sevenPlayersBtn);
		playerCountPanel.add(eightPlayersBtn);
		playerCountPanel.add(backBtn);
		
		return playerCountPanel;
	}	

	/**
	 * Adds the action listeners.
	 **/
	protected void addActionListeners(ActionListener evt)
	{
		threePlayersBtn.addActionListener(evt);
		fourPlayersBtn.addActionListener(evt);
		fivePlayersBtn.addActionListener(evt);
		sixPlayersBtn.addActionListener(evt);
		backBtn.addActionListener(evt);
	}
}