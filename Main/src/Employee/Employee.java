package Employee;

import Mediator.Mediator;
import User.User;

public class Employee {

	private String name;
	private int speed;
	public Mediator room;
	
	
	public Employee(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void sendSignal(String msg)
	{
		this.room.sendUserSignal(this, msg);
	}
}
