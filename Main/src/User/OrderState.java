package User;

import Utillities.Utillities;

public class OrderState extends UserState{

	
	private Utillities util = Utillities.getInstance();
	
	public OrderState(User u) {
		super(u);
		this.setStateName("order food");
		running = true;
		this.start();
	}
	
	public void run() {
		while(running)
		{
			u.sendWaiterSignal("order");
			u.minusTolerance(1);
		}
	}
	
	@Override
	public void changeState() {
		u.setState(new OrderWaiterState(u, getWaiter()));
	}

}
