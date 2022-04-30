
public class Highscore {

	Highscore highscore;
	
	public Highscore getHighscoreInstance()
	{
		if(highscore == null)
		{
			highscore = new Highscore();
		}
		return highscore;
	}
}
