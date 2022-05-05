package User;

import Chef.Chef;
import Utillities.Utillities;
import Waiter.Waiter;

public class WaitFoodChefState extends UserState{
	
	private Utillities util = Utillities.getInstance();
	
	public WaitFoodChefState(User u, Chef c) {
		super(u);
		setChef(c);
		this.setStateName("wait food chef " + c.getName());
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
		u.setState(new WaitFoodWaiterState(u, getChef()));
	}
}
