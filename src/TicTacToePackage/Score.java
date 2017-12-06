package TicTacToePackage;

public class Score {
	
	private int scoreValue;
	
	
	//CONSTRUCTOR FOR A SCORE
	public Score(){
		this.scoreValue = 0;
	}
	
	public Score(int scoreValue){
		this.setScoreValue(scoreValue);
	}

	/**
	 * @return the scoreValue
	 */
	public String getScoreValue() {
		return String.valueOf(scoreValue);
	}

	/**
	 * @param scoreValue the scoreValue to set
	 */
	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

}
