package Chef;

import Main.Restaurant;
import User.User;
import Waiter.Waiter;

public abstract class ChefState extends Thread{

	public Chef c;
	public String name;
	private User user;
	private Waiter waiter;
	Restaurant restaurant = Restaurant.getInstance();
	
	private boolean runnable;
	
	public boolean isRunnable() {
		return runnable;
	}

	public void setRunnable(boolean runnable) {
		this.runnable = runnable;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Waiter getWaiter() {
		return waiter;
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
	
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
