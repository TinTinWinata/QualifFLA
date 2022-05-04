package Waiter;

import Chef.Chef;
import User.User;
import User.WaitFoodWaiterState;
import Utillities.Utillities;

public class BringOrderState extends WaiterState{

	private Chef chef;
	private Utillities util;
	private User user;
	
	public BringOrderState(Waiter w, Chef c) {
		super(w);
		util = Utillities.getInstance();
		chef = c;
		this.name = "bring order chef " + c;
		this.start();
	}
	
	public void run()
	{
		if(chef.getChefState().getStateName().equals("idle"))
		{
			this.changeState();
			util.wait(1000);
		}
		else if(chef.getChefState().getStateName().equals("done")) {
			util.wait(1000);
			if(user != null && user.getUserState() instanceof WaitFoodWaiterState)
			{
				user.getUserState().setRunning(false);
				chef.getChefState().changeState();
			}
		}
	}

	
	@Override
	public void changeState() {
		w.setState(new IdleState(w));
	}
	

}
