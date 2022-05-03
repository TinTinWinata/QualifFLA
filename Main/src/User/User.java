package User;

import Utillities.Utillities;

public class User extends Thread{
	
	private Utillities util = Utillities.getInstance();
	
	private UserState state;
	private String name;
	private int tolerance;
	
	
	public void run()
	{
		
	}
	
	public void minusTolerance(int mins) {
		tolerance -= mins;
	}
	
	public String getUserName() {
		return name;
	}

	public void setUserName(String name) {
		this.name = name;
	}

	public int getTolerance() {
		return tolerance;
	}

	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}

	public User(String name)
	{
		this.name = name;
		this.state = new OrderState(this);
	}
	
	public void setState(UserState s)
	{
		this.state = s;
	}
	
	public UserState getUserState()
	{
		return this.state;
	}
}
