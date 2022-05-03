package Chef;

public abstract class ChefState {

	public Chef c;
	public String name;
	
	public ChefState(Chef c)
	{
		this.c = c;
	}
	
	public String getStateName()
	{
		return name;
	}
	
	public abstract void changeState();
}
