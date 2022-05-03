package Waiter;

import Employee.Employee;
import Employee.EmployeeInterface;

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
	
	
	
}
