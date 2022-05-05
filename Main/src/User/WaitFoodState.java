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
	}

	@Override
	public void changeState() {
		u.setState(new WaitFoodChefState(u, getChef()));
	}
	
}
