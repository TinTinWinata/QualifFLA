package User;

import Utillities.Utillities;
import Waiter.Waiter;

public class OrderWaiterState extends UserState{

	Utillities util;
	
	public OrderWaiterState(User u, Waiter w) {
		super(u);
		this.util = Utillities.getInstance();
		this.setWaiter(w);
		this.setStateName("order food by " + w.getName());
		getWaiter().getWaiterState().changeStateTakeOrder(this.u);
	}		
	
	@Override
	public void changeState() {
		u.setState(new WaitFoodState(u));
	}
}
