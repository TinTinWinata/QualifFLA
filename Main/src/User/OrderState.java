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
			util.wait(2000);
			u.minusTolerance(1);
		}
	}
	
	@Override
	public void changeState() {
		running = false;
		u.setState(new WaitFoodState(u));
	}

}
