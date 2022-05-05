package Waiter;

import User.User;
import Utillities.Utillities;

public class ServingFoodState extends WaiterState{

	Utillities util;
	private User user;
	
	public ServingFoodState(Waiter w, User u) {
		super(w);
		this.user = u;
		this.name = "serving food user " + u.getUserName();
		util = Utillities.getInstance();
		this.start();
	}

	public void run()
	{
		util.wait(1000);
		user.getUserState().setRunning(false);
		user.getUserState().changeState();
		this.changeState();
	}
	
	@Override
	public void changeState() {
		w.setState(new IdleState(w));
	}
	

}
