package User;

import Employee.Employee;

public abstract class UserState extends Thread{

	public User u;
	protected boolean running;
	private String name;

	
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
