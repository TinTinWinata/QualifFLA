package Chef;

import Employee.Employee;
import Employee.EmployeeInterface;
import Mediator.Mediator;
import User.User;

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

	@Override
	public void joinRoom(Mediator room) {
		this.room = room;
		this.room.addChef(this);
	}

	@Override
	public void recieveSignal(User user, String msg) {
		// TODO Auto-generated method stub
		
	}
}
