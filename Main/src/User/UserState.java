package User;

import Chef.Chef;
import Employee.Employee;
import Waiter.Waiter;

public abstract class UserState extends Thread{

	public User u;
	protected boolean running;
	private String name;

	private Chef chef;
	private Waiter waiter;
	
	public Waiter getWaiter() {
		return waiter;
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public String getStateName() {
		return name;
	}
	
	public void setStateName(String str)
	{
		this.name = str;
	}
	
	public UserState(User u)
	{
		this.u = u;
	}
	
	public abstract void changeState();


}
