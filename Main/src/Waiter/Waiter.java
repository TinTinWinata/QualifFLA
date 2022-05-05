package Waiter;

import Chef.Chef;
import Employee.Employee;
import Employee.EmployeeInterface;
import Main.Restaurant;
import Mediator.Mediator;
import User.User;

public class Waiter extends Employee implements EmployeeInterface {

	private WaiterState waiterState;
	private Restaurant restaurant = Restaurant.getInstance();

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
		if (this.getWaiterState().getStateName().equals("idle")) {
			if (user.getUserState().getStateName().equals("wait food waiter")) {
				if (msg.contains("wait food bring by")) {
					String[] splitMessage = msg.split("#", 10);
					String chefInitial = splitMessage[1];
					Chef c = restaurant.findChef(chefInitial);
					user.getUserState().setWaiter(this);
					this.getWaiterState().changeStateBringOrder(c, user);
				}
			}
			if (user.getUserState().getStateName().equals("order food")) {
				if (msg.equals("order")) {
					this.getWaiterState().changeStateTakeOrder(user);
					user.getUserState().setWaiter(this);
					user.getUserState().setRunning(false); 
					user.getUserState().changeState();
				}
			}
		}
	}

	public void recieveServingFoodSignal(Chef chef, User user, String msg) {
		if (this.getWaiterState().getStateName().equals("idle") && msg.equals("done") && chef.getChefState().getStateName().contains("done")) {
//			System.out.println("[DEBUG WAITER] Chef Done : " + chef.getName() + " " + chef.getChefState().getStateName());
			this.getWaiterState().changeStateServingFood(user);
			chef.getChefState().setRunnable(false);
			chef.getChefState().changeState();
		}
	}

	public void recieveSignal(Chef chef, String msg) {

	}

	public void sendChefSignal(String msg) {
		this.room.sendChefSignal(this, msg);
	}
}
