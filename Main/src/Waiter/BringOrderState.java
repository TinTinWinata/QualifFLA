package Waiter;

import Chef.Chef;
import User.User;
import User.WaitFoodWaiterState;
import Utillities.Utillities;

public class BringOrderState extends WaiterState{

	private Utillities util;
	
	public BringOrderState(Waiter w, Chef c, User u) {
		super(w);
		util = Utillities.getInstance();
		setUser(u);
		setChef(c);
		this.name = "bring order [" + c.getName() + "] [" + u.getUserName() + "]";
		this.start();
	}
	
	public void run()
	{
		util.wait(1000);
		
		if(!restaurant.ifUserExist(getUser()))
		{
			changeState();
		}
		
		if(getChef().getChefState().getStateName().equals("idle"))
		{
			getUser().getUserState().setChef(getChef());
			getUser().getUserState().changeState();
			getChef().getChefState().changeCookState(getUser());
			this.changeState();
		}
		
		else if(getChef().getChefState().getStateName().contains("done")) {
			getUser().getUserState().setChef(getChef());
			getUser().getUserState().changeState();
			getChef().getChefState().changeCookState(getUser());
			w.getWaiterState().changeStateServingFood(getUser());
		}
	}

	
	@Override
	public void changeState() {
		this.setRunnable(false);
		w.setState(new IdleState(w));
	}
	

}
