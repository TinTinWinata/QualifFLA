package Waiter;

import Chef.Chef;
import User.User;
import Utillities.Utillities;

public class WaitCookState extends WaiterState{

	private Utillities util;

	public WaitCookState(Waiter w, User u) {
		super(w);
		this.setUser(u);
		this.util = Utillities.getInstance();
		this.name = "wait cook";
		setRunnable(true);
		this.start();
	}
	

	
	public void run()
	{
			w.sendChefSignal("wait cook");		
		if(getChef() != null)
		{
			w.getWaiterState().changeStateBringOrder(getChef(), getUser());			
		}
		
	}
	
	@Override
	public void changeState() {
		w.setState(new IdleState(w));
	}

}
