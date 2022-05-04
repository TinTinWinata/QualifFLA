package User;

import Utillities.Utillities;

public class WaitFoodChefState extends UserState{
	
	private Utillities util = Utillities.getInstance();
	
	public WaitFoodChefState(User u) {
		super(u);
		this.setStateName("wait food chef");
		running = true;
		this.start();
	}

	public void run()
	{
		while(running)
		{
			util.wait(4000);
			u.minusTolerance(1);
		}
		changeState();
	}
	
	@Override
	public void changeState() {
		running = false; 
		u.setState(new WaitFoodWaiterState(u));
	}
}
