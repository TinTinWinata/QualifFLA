package User;

import Utillities.Utillities;

public class WaitFoodWaiterState extends UserState{
	
	private boolean running;
	private Utillities util = Utillities.getInstance();
	
	public WaitFoodWaiterState(User u) {
		super(u);
		this.setStateName("wait food waiter");
		running = true;
		this.start();
	}
	
	public void run() {
		while(running) {
			util.wait(4000);
			u.minusTolerance(1);
		}
		changeState();
	}

	@Override
	public void changeState() {
		running = false;
		u.setState(new EatState(u));
	}
		
}
