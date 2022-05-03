package User;

import Utillities.Utillities;

public class OrderState extends UserState{

	private boolean running;
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
	
	public void setRunning(boolean running)
	{
		this.running = running;
	}
	
	@Override
	public void changeState() {
		running = false;
		u.setState(new WaitFoodState(u));
	}

}
