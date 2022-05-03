package User;

import Employee.Employee;
import Mediator.Mediator;
import Utillities.Utillities;

public class User extends Thread{
	
	private Utillities util = Utillities.getInstance();
	
	private UserState state;
	private String name;
	private int tolerance;
	Mediator room;
	private boolean isServe;
	
	public User(String name)
	{
		this.isServe = false;
		this.name = name;
		this.state = new OrderState(this);
	}
	
	public boolean served()
	{
		return isServe;
	}
	
	public void isServe() {
		this.isServe = true;
	}
	
	public void notServe()
	{
		this.isServe = false;
	}

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


	
	public void joinRoom(Mediator room)
	{
		this.room = room;
		this.room.addUser(this);
	}

	public void sendSignal(String msg) {
		this.room.sendChefSignal(this, msg);
		this.room.sendWaiterSignal(this, msg);
	}
	
	public void sendWaiterSignal(String msg)
	{
		this.room.sendWaiterSignal(this, msg);
	}
	public void sendChefSignal(String msg)
	{
		this.room.sendChefSignal(this, msg);
	}
	public void recieveSignal(Employee employee, String msg)
	{
		
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
