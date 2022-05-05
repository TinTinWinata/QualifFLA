package Waiter;

import User.User;
import Utillities.Utillities;

public class TakeOrderState extends WaiterState {

	private Utillities util;

	public TakeOrderState(Waiter w, User u) {
		super(w);
		this.setUser(u);
		this.name = "take order user " + u.getUserName();
		this.start();
		util = Utillities.getInstance();
	}

	public void run() {
			int takeOrderTime = (6 - w.getSpeed()) * 1000;
			util.wait(takeOrderTime);
			getUser().getUserState().changeState();
			w.getWaiterState().changeStateWaitCook(this.getUser());
	}

	@Override
	public void changeState() {
		w.setState(new IdleState(w));
	}
}
