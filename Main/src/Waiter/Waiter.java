package Waiter;

import Employee.Employee;
import Employee.EmployeeInterface;
import Mediator.Mediator;
import User.User;

public class Waiter extends Employee implements EmployeeInterface{

	private WaiterState waiterState;
	
	public Waiter(String name) {
		super(name);
		this.waiterState = new IdleState(this);
	}

	public WaiterState getWaiterState() {
		return waiterState;
	}

	public void setState(WaiterState state) {
		this.waiterState = state;
	}
	
	@Override
	public void joinRoom(Mediator room) {
		this.room = room;
		this.room.addWaiter(this);
	}

	@Override
	public void recieveSignal(User user, String msg) {
		if(!user.served())
		{
			
		}
	}
		

}
