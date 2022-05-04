package User;

import Utillities.Utillities;

public class WaitFoodState extends UserState{

	Utillities util = Utillities.getInstance();
	
	public WaitFoodState(User u) {
		super(u);
		this.setStateName("wait food");
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
		u.setState(new WaitFoodChefState(u));
	}
	
}
