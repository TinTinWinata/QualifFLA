package Waiter;

import User.User;
import Utillities.Utillities;

public class TakeOrderState extends WaiterState {

	private boolean running;
	private Utillities util;
	private User user;

	public TakeOrderState(Waiter w, User u) {
		super(w);
		user = u;
		this.name = "take order user " + u.getName();
		this.running = true;
		this.start();
		util = Utillities.getInstance();
	}

	public void run() {
		while (running) {
			util.wait(6000);
			user.getUserState().changeState();
		}
	}

	@Override
	public void changeState() {
		w.setState(new IdleState(w));
	}
}
