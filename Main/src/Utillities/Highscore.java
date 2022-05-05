package Utillities;

import java.util.Vector;

public class Highscore {

	private static Highscore highscore;
	private Utillities util = Utillities.getInstance();
	private Vector<Score> scoreList = new Vector<Score>();
	private Score currentScore;

	public Score getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(Score currentScore) {
		this.currentScore = currentScore;
	}

	public static Highscore getInstance() {
		if (highscore == null) {
			highscore = new Highscore();
			highscore.readHighscore();
		}
		return highscore;
	}

	public void displayHighScore() {
		for (Score score : scoreList) {
			if (score == currentScore) {
				System.out.printf("%-20s [%-5d] <<", ">>" + score.restaurantName, score.score);
			} else {
				System.out.printf("%-20s [%-5d]", score.restaurantName, score.score);
			}
			System.out.println();
		}
	}

	public void setCurrentScore(String name, Integer score) {
		currentScore = new Score(score, name);
		scoreList.add(currentScore);
		sortScore();
		saveScore();
	}
	
	public void saveScore()
	{
		Vector<String> dataList = new Vector<String>();
		for (Score curr : scoreList) {
			String serealizedData = curr.restaurantName + "#" + curr.score;
			dataList.add(serealizedData);
			util.write(dataList, "./highscore.txt");
		}
	}

	public void sortScore() {
		int n = scoreList.size();
		Score tempScore = null;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (scoreList.get(j - 1).score > scoreList.get(j).score) {
					tempScore = scoreList.get(j - 1);
					scoreList.set(j - 1, scoreList.get(j));
					scoreList.set(j, tempScore);
				}
			}
		}
	}
	
	
	
	public void readHighscore() {
		Vector<String> dataList = util.read("./highscore.txt");
		for (String str : dataList) {
			String[] splittedStr = str.split("#", 2);
			Integer score = Integer.parseInt(splittedStr[1]);
			String restaurantName = splittedStr[0];
			scoreList.add(new Score(score, restaurantName));
		}
		sortScore();
	}
}
