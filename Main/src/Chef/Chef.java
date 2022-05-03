package Chef;

import Employee.Employee;
import Employee.EmployeeInterface;

public class Chef extends Employee implements EmployeeInterface{

	private ChefState chefState;
	
	public Chef(String name) {
		super(name);
		this.chefState = new IdleState(this);
	}
	
	public ChefState getChefState() {
		return chefState;
	}

	public void setState(ChefState state) {
		this.chefState = state;
	}
}
