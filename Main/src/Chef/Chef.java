package Chef;

import Employee.Employee;
import Employee.EmployeeInterface;
import Mediator.Mediator;
import User.User;
import Waiter.Waiter;

public class Chef extends Employee implements EmployeeInterface {

	private ChefState chefState;
	private int speed;
	private int skill;

	public Chef(String name) {
		super(name);
		this.chefState = new IdleState(this);
		this.speed = 1;
		this.skill = 1;
	}

	public void addSkill(int skill) {
		this.skill += skill;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
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

	}

	public void recieveSignal(Waiter waiter, String msg) {
		String stateName = this.getChefState().getStateName();
		if (stateName.equals("done") || stateName.equals("idle")) {
			if (msg.equals("wait cook")) {
				waiter.getWaiterState().thereIsAChef(this);
				waiter.getWaiterState().setRunnable(false);
			}
		}
	}
	
	public void sendWaiterServingFoodSignal(User user, String msg)
	{
		this.room.sendWaiterServingFoodSignal(this, user, msg);
	}
	

}
