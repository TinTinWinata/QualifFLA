package User;

import Chef.Chef;
import Utillities.Utillities;
import Waiter.Waiter;

public class WaitFoodWaiterState extends UserState{
	
	private boolean running;
	private Utillities util = Utillities.getInstance();
	
	public WaitFoodWaiterState(User u, Chef c) {
		super(u);
		this.setChef(c);
		this.setStateName("wait food waiter");
		running = true;
		this.start();
	}
	
	public void run() {
		while(running) {
			u.sendWaiterSignal("wait food bring by waiter#" + getChef().getName());
			util.wait(4000);
			u.minusTolerance(1);
		}
	}

	@Override
	public void changeState() {
		u.setState(new EatState(u, getChef()));
	}
		
}
