package Chef;

import User.User;

public abstract class ChefState extends Thread{

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
	
	public void changeCookState(User u)
	{
		c.setState(new CookState(u, c));
	}
	
	public void changeDoneState(User u)
	{
		c.setState(new DoneState(c, u));
	}
	
	public abstract void changeState();
}
