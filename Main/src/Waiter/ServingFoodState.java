package Waiter;

import User.User;
import Utillities.Utillities;

public class ServingFoodState extends WaiterState{

	Utillities util;
	private User user;
	
	public ServingFoodState(Waiter w, User u) {
		super(w);
		this.user = u;
		this.name = "serving food user " + u.getName();
		util = Utillities.getInstance();
	}

	public void run()
	{
		util.wait(1000);
		user.getUserState().changeState();
		changeState();
	}
	
	@Override
	public void changeState() {
		w.setState(new IdleState(w));
	}
	

}
