package Chef;

import User.User;
import Utillities.Utillities;

public class DoneState extends ChefState{
	
	Utillities util;
	
	public DoneState(Chef c, User u) {
		super(c);
		this.util = Utillities.getInstance();
		this.name = "done " + u.getUserName();
		this.setUser(u);
		this.setRunnable(true);
		this.start();
	}
	
	public void run()
	{
		while(isRunnable())
		{
			util.wait(500);
			c.sendWaiterServingFoodSignal(getUser(), "done");
			if(!restaurant.ifUserExist(getUser()))
			{
				changeState();
			}
		}
	}

	@Override
	public void changeState() {
		setRunnable(false);
		c.setState(new IdleState(c));
	}
	

}
