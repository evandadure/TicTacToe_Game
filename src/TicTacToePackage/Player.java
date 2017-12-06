package TicTacToePackage;

public class Player {

	private String playerName;
	private Score playerScore;
	
	//CONSTRUCTOR FOR A PLAYER WITHOUT PARAMETERS
	public Player() {
		this.playerName = "";
		this.playerScore = new Score();
	}
	
	//CONSTRUCTOR FOR A PLAYER WITH PARAMETERS
	public Player(String playerName, Score playerScore){
		this.playerName = playerName;
		this.playerScore = playerScore;
	}
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	/**
	 * @return the playerScore
	 */
	public Score getPlayerScore() {
		return playerScore;
	}
	/**
	 * @param playerScore the playerScore to set
	 */
	public void setPlayerScore(Score playerScore) {
		this.playerScore = playerScore;
	}
	
	
//METHOD THAT ADDS ONE POINT TO THE WINNER
	public void addOnePoint()
	{
		this.playerScore.setScoreValue(Integer.parseInt(this.playerScore.getScoreValue())+1);
	}

}
