package TicTacToePackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

public class TicTacToeGame {

	private JFrame frame;
	private String startGame = "Green";
	private JTextField textFieldGreen;
	private JTextField textFieldRed;
	private JTextField textFieldScoreGreen;
	private JTextField textFieldScoreRed;
	private JButton btnGame1;
	private JButton btnGame2;
	private JButton btnGame3;
	private JButton btnGame4;
	private JButton btnGame5;
	private JButton btnGame6;
	private JButton btnGame7;
	private JButton btnGame8;
	private JButton btnGame9;
	private Color greenColor = new Color(0, 153, 0);
	private Color redColor = new Color(255, 0, 51);
	private Player playerGreen;
	private Player playerRed;

/////////////////////METHODS//////////////////////////////////
	
	
	
	
//METHOD THAT CHANGES THE PLAYER
	private void choosePlayer(){
		if(startGame.equalsIgnoreCase("Green")){
			startGame = "Red";
		} else {
			startGame = "Green";
		}
	}

//METHOD THAT CHANGES THE COLOR OF THE BUTTON ACCORDING TO THE CURRENT PLAYER
	private void setBtnColor(JButton btnGame){
		btnGame.setBackground(new Color(0, 153, 0)); //CHANGING TO GREEN
		if(startGame == "Red"){
			btnGame.setBackground(new Color(255, 0, 51)); //CHANGING TO RED
		}
		choosePlayer(); //CHANGING THE PLAYER
	}
	
//METHOD TO CLEAN THE GAME
	private void cleanGame(){
	    btnGame1.setBackground(Color.LIGHT_GRAY);
	    btnGame2.setBackground(Color.LIGHT_GRAY);
	    btnGame3.setBackground(Color.LIGHT_GRAY);
	    btnGame4.setBackground(Color.LIGHT_GRAY);
	    btnGame5.setBackground(Color.LIGHT_GRAY);
	    btnGame6.setBackground(Color.LIGHT_GRAY);
	    btnGame7.setBackground(Color.LIGHT_GRAY);
	    btnGame8.setBackground(Color.LIGHT_GRAY);
	    btnGame9.setBackground(Color.LIGHT_GRAY);
	}
	
//METHOD THAT CHECKS IF THERE IS 3 BUTTONS ALIGNED AND WITH THE SAME COLOR AND GIVE A POINT TO THE CORRESPONDING PLAYER IF ITS THE CASE
	private void checkLine(JButton btn1, JButton btn2, JButton btn3){
		if (btn1.getBackground().equals(btn2.getBackground()) && btn1.getBackground().equals(btn3.getBackground())){
			if(btn1.getBackground().equals(greenColor)){
				playerGreen.addOnePoint();
				textFieldScoreGreen.setText(playerGreen.getPlayerScore().getScoreValue());
				JOptionPane.showMessageDialog(null, playerGreen.getPlayerName()+" won this game !");
				cleanGame();
			} else if(btn1.getBackground().equals(redColor)) {
				playerRed.addOnePoint();
				textFieldScoreRed.setText(playerRed.getPlayerScore().getScoreValue());
				JOptionPane.showMessageDialog(null, playerRed.getPlayerName()+" won this game !");
				cleanGame();
			}
			
		}	
	}

//METHODS THAT CHECKS IF THERE IS 3 BUTTONS ALIGNED AND WITH THE SAME COLOR AND GIVE A POINT TO THE CORRESPONDING PLAYER IF ITS THE CASE
	private void winningGame(){
		//FIRST CASE (BUTTONS 1,2,3)
		checkLine(btnGame1,btnGame2,btnGame3);
		//SECOND CASE (BUTTONS 4,5,6)
		checkLine(btnGame4,btnGame5,btnGame6);
		//THIRD CASE (BUTTONS 7,8,9)
		checkLine(btnGame7,btnGame8,btnGame9);
		//FORTH CASE (BUTTONS 1,4,7)
		checkLine(btnGame1,btnGame4,btnGame7);
		//FIFTH CASE (BUTTONS 2,5,8)
		checkLine(btnGame2,btnGame5,btnGame8);
		//SIXTH CASE (BUTTONS 3,6,9)
		checkLine(btnGame3,btnGame6,btnGame9);
		//SEVENTH CASE (BUTTONS 1,5,9)
		checkLine(btnGame1,btnGame5,btnGame9);
		//EIGHTH CASE (BUTTONS 3,5,7)
		checkLine(btnGame3,btnGame5,btnGame7);
	}


/////////////////////////////////////////////////////////////////
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGame window = new TicTacToeGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	/**
	 * Create the application.
	 */
	public TicTacToeGame() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 150, 872, 679);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelGame = new JPanel();
		panelGame.setBorder(new LineBorder(Color.GRAY, 4));
		frame.getContentPane().add(panelGame, BorderLayout.CENTER);
		panelGame.setLayout(new GridLayout(3, 5, 2, 2));
		
		
		
		JPanel panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, BorderLayout.CENTER);
		panelMenu.setLayout(null);	
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setForeground(Color.GRAY);
		panelGame.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		btnGame1 = new JButton("");
		btnGame1.setFont(new Font("Rockwell", Font.BOLD, 31));
		btnGame1.setForeground(Color.BLACK);
		btnGame1.setBackground(Color.LIGHT_GRAY);
		
//CLICK ON THE 1ST BUTTON OF THE GAME
		btnGame1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBtnColor(btnGame1);
				winningGame();
			}
		});
		panel_1.add(btnGame1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setForeground(Color.GRAY);
		panelGame.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btnGame2 = new JButton("");
//CLICK ON THE 2ND BUTTON OF THE GAME
		btnGame2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBtnColor(btnGame2);
				winningGame();
			}
		});
		btnGame2.setFont(new Font("Rockwell", Font.BOLD, 31));
		btnGame2.setBackground(Color.LIGHT_GRAY);
		btnGame2.setForeground(Color.BLACK);
		panel_2.add(btnGame2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setForeground(Color.GRAY);
		panelGame.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnGame3 = new JButton("");
//CLICK ON THE 3RD BUTTON OF THE GAME
		btnGame3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBtnColor(btnGame3);
				winningGame();
			}
		});
		btnGame3.setFont(new Font("Rockwell", Font.BOLD, 31));
		btnGame3.setBackground(Color.LIGHT_GRAY);
		btnGame3.setForeground(Color.BLACK);
		panel_3.add(btnGame3, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setForeground(Color.GRAY);
		panelGame.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblPlayerGreenScoreOf = new JLabel("SCORE OF");
		lblPlayerGreenScoreOf.setBounds(12, 55, 143, 30);
		lblPlayerGreenScoreOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerGreenScoreOf.setBackground(Color.GREEN);
		lblPlayerGreenScoreOf.setFont(new Font("Rockwell", Font.BOLD, 25));
		lblPlayerGreenScoreOf.setForeground(new Color(0, 153, 0));
		panel_4.add(lblPlayerGreenScoreOf);
		
		JLabel lblPlayerGreenName = new JLabel("");
		lblPlayerGreenName.setBounds(12, 100, 143, 43);
		lblPlayerGreenName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlayerGreenName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerGreenName.setForeground(new Color(0, 153, 0));
		lblPlayerGreenName.setFont(new Font("Rockwell", Font.PLAIN, 22));
		panel_4.add(lblPlayerGreenName);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setForeground(Color.GRAY);
		panelGame.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		textFieldScoreGreen = new JTextField();
		textFieldScoreGreen.setText("0");
		textFieldScoreGreen.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldScoreGreen.setFont(new Font("Rockwell", Font.BOLD, 60));
		panel_5.add(textFieldScoreGreen, BorderLayout.CENTER);
		textFieldScoreGreen.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setForeground(Color.GRAY);
		panelGame.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		btnGame4 = new JButton("");
//CLICK ON THE 4TH BUTTON OF THE GAME
		btnGame4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBtnColor(btnGame4);
				winningGame();
			}
		});
		btnGame4.setFont(new Font("Rockwell", Font.BOLD, 31));
		btnGame4.setBackground(Color.LIGHT_GRAY);
		btnGame4.setForeground(Color.BLACK);
		panel_6.add(btnGame4, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setForeground(Color.GRAY);
		panelGame.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		btnGame5 = new JButton("");
//CLICK ON THE 5TH BUTTON OF THE GAME
		btnGame5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBtnColor(btnGame5);
				winningGame();
			}
		});
		btnGame5.setFont(new Font("Rockwell", Font.BOLD, 31));
		btnGame5.setBackground(Color.LIGHT_GRAY);
		btnGame5.setForeground(Color.BLACK);
		panel_7.add(btnGame5, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setForeground(Color.GRAY);
		panelGame.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		btnGame6 = new JButton("");
//CLICK ON THE 6TH BUTTON OF THE GAME
		btnGame6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBtnColor(btnGame6);
				winningGame();
			}
		});
		btnGame6.setFont(new Font("Rockwell", Font.BOLD, 31));
		btnGame6.setBackground(Color.LIGHT_GRAY);
		btnGame6.setForeground(Color.BLACK);
		panel_8.add(btnGame6, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setForeground(Color.BLACK);
		panelGame.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblPlayerRedScoreOf = new JLabel("SCORE OF");
		lblPlayerRedScoreOf.setBounds(12, 55, 143, 30);
		lblPlayerRedScoreOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerRedScoreOf.setFont(new Font("Rockwell", Font.BOLD, 25));
		lblPlayerRedScoreOf.setForeground(new Color(255, 0, 51));
		panel_9.add(lblPlayerRedScoreOf);
		
		JLabel lblPlayerRedName = new JLabel("");
		lblPlayerRedName.setBounds(12, 100, 143, 43);
		lblPlayerRedName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerRedName.setFont(new Font("Rockwell", Font.PLAIN, 22));
		lblPlayerRedName.setForeground(new Color(255, 0, 51));
		panel_9.add(lblPlayerRedName);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setForeground(Color.GRAY);
		panelGame.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		textFieldScoreRed = new JTextField();
		textFieldScoreRed.setText("0");
		textFieldScoreRed.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldScoreRed.setFont(new Font("Rockwell", Font.BOLD, 60));
		textFieldScoreRed.setColumns(10);
		panel_10.add(textFieldScoreRed, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_11.setForeground(Color.GRAY);
		panelGame.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		btnGame7 = new JButton("");
//CLICK ON THE 7TH BUTTON OF THE GAME
		btnGame7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBtnColor(btnGame7);
				winningGame();
			}
		});
		btnGame7.setFont(new Font("Rockwell", Font.BOLD, 31));
		btnGame7.setBackground(new Color(192, 192, 192));
		btnGame7.setForeground(Color.BLACK);
		panel_11.add(btnGame7, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13.setForeground(Color.GRAY);
		panelGame.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		btnGame8 = new JButton("");
//CLICK ON THE 8TH BUTTON OF THE GAME
		btnGame8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBtnColor(btnGame8);
				winningGame();
			}
		});
		btnGame8.setFont(new Font("Rockwell", Font.BOLD, 31));
		btnGame8.setBackground(Color.LIGHT_GRAY);
		btnGame8.setForeground(Color.BLACK);
		panel_13.add(btnGame8, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.setForeground(Color.GRAY);
		panelGame.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		btnGame9 = new JButton("");
//CLICK ON THE 9TH BUTTON OF THE GAME
		btnGame9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBtnColor(btnGame9);
				winningGame();
			}
		});
		btnGame9.setFont(new Font("Rockwell", Font.BOLD, 31));
		btnGame9.setBackground(Color.LIGHT_GRAY);
		btnGame9.setForeground(Color.BLACK);
		panel_12.add(btnGame9, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_14.setForeground(Color.BLACK);
		panelGame.add(panel_14);
		
		JButton btnGameReset = new JButton("RESET");
		btnGameReset.setFont(new Font("Rockwell", Font.BOLD, 28));
		btnGameReset.setForeground(Color.BLACK);
		btnGameReset.setBackground(new Color(0, 204, 255));
		

//I RESET THE COLOR OF ALL BUTTONS WHEN CLICKING ON THE "RESET" BUTTON
		btnGameReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanGame();
			}
		});
		panel_14.setLayout(new BorderLayout(0, 0));
		panel_14.add(btnGameReset);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_15.setForeground(Color.GRAY);
		panelGame.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JButton btnGameBack = new JButton("BACK");
//CLICK ON THE "BACK" BUTTON
				btnGameBack.addActionListener(new ActionListener() {
//I SET THE MENU PANEL WHEN I CLICK ON THE PLAY BUTTON
					public void actionPerformed(ActionEvent e) {
						frame.setContentPane(panelMenu);
						frame.invalidate();
						frame.validate();
					}
				});
				btnGameBack.setFont(new Font("Rockwell", Font.BOLD, 28));
				btnGameBack.setBackground(Color.ORANGE);
				btnGameBack.setForeground(Color.BLACK);
				panel_15.add(btnGameBack, BorderLayout.CENTER);
		
				
				JPanel panel_16 = new JPanel();
				panel_16.setBounds(0, 0, 854, 632);
				panel_16.setBackground(new Color(153, 204, 255));
				panelMenu.add(panel_16);
				panel_16.setLayout(null);
				

				
				JButton btnYo = new JButton("PLAY !");
				btnYo.setForeground(new Color(255, 255, 255));
				btnYo.setBackground(new Color(0, 0, 0));
				btnYo.setFont(new Font("Rockwell", Font.BOLD, 30));
				btnYo.setBounds(361, 396, 155, 92);
				panel_16.add(btnYo);
				
				textFieldGreen = new JTextField();
				textFieldGreen.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textFieldGreen.setBounds(444, 236, 184, 31);
				panel_16.add(textFieldGreen);
				textFieldGreen.setColumns(10);
				
				textFieldRed = new JTextField();
				textFieldRed.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textFieldRed.setBounds(444, 300, 184, 31);
				panel_16.add(textFieldRed);
				textFieldRed.setColumns(10);
				
				JLabel lblPlayerName1 = new JLabel("Green player name");
				lblPlayerName1.setForeground(new Color(0, 153, 51));
				lblPlayerName1.setFont(new Font("MS PGothic", Font.BOLD, 18));
				lblPlayerName1.setBounds(227, 235, 183, 31);
				panel_16.add(lblPlayerName1);
				
				JLabel lblPlayerName2 = new JLabel("Red player name");
				lblPlayerName2.setForeground(new Color(255, 0, 51));
				lblPlayerName2.setFont(new Font("MS PGothic", Font.BOLD, 18));
				lblPlayerName2.setBounds(247, 299, 163, 31);
				panel_16.add(lblPlayerName2);
				
				JLabel label = new JLabel("TicTacToe Game");
				label.setForeground(new Color(0, 0, 0));
				label.setFont(new Font("Rockwell", Font.BOLD, 53));
				label.setBounds(201, 13, 474, 92);
				panel_16.add(label);
				
				JLabel label_1 = new JLabel("Developed by Evan Dadure");
				label_1.setForeground(Color.BLACK);
				label_1.setFont(new Font("MS PGothic", Font.PLAIN, 21));
				label_1.setBounds(421, 76, 244, 39);
				panel_16.add(label_1);
				
				JButton btnExitTheGame = new JButton("Exit the game");
				
//EXIT BUTTON -> NEW FRAME TO CONFIRM EXIT THE GAME (IF YES -> EXIT, IF NO -> GO BACK TO MENU)
				btnExitTheGame.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame frameExit = new JFrame("Exit");
						if (JOptionPane.showConfirmDialog(frameExit, "Are you sure you want to exit ?", "Exit TicTacToe",
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
							System.exit(0);
						}
					}
				});
				btnExitTheGame.setForeground(new Color(255, 255, 255));
				btnExitTheGame.setBackground(new Color(255, 0, 51));
				btnExitTheGame.setBounds(346, 523, 184, 39);
				panel_16.add(btnExitTheGame);
				btnYo.addActionListener(new ActionListener() {

					
//CLICK ON THE PLAY BUTTON
//THE NAMES IN THE TEXTFIELDS ARE PUT IN THE LABELS OF THE GAME
				public void actionPerformed(ActionEvent e) {
		
					playerGreen = new Player(); //using constructor without parameters
					playerGreen.setPlayerName(textFieldGreen.getText());
					
					playerRed = new Player(textFieldRed.getText(),new Score()); //using constructor with parameters
					
					lblPlayerGreenName.setText(playerGreen.getPlayerName());
					lblPlayerRedName.setText(playerRed.getPlayerName());
					

//I SET THE GAME PANEL WHEN I CLICK ON THE PLAY BUTTON	
					frame.setContentPane(panelGame);
					frame.invalidate();
					frame.validate();
				}
			});
	}
	


}
