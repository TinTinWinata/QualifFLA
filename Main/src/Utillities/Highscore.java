package Utillities;

public class Highscore {

	private static Highscore highscore;
	
	public static Highscore getInstance()
	{
		if(highscore == null)
		{
			highscore = new Highscore();
		}
		return highscore;
	}
}
