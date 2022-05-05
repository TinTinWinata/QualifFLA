package Chef;

import User.User;
import Utillities.Utillities;

public class CookState extends ChefState{

	
	private Utillities util;
	
	public CookState(User u, Chef c) {
		super(c);
		util = Utillities.getInstance();
		this.setUser(u);
		this.name = "cook " + u.getUserName();
		this.start();
	}

	public void run()
	{
		int waitTime = (6 - c.getSpeed()) * 1000;
		util.wait(waitTime);
		getUser().getUserState().setChef(c);
		getUser().getUserState().setRunning(false);
		getUser().getUserState().changeState();
		this.changeDoneState(getUser());
	}
	
	@Override
	public void changeState() {
		c.setState(new IdleState(c));
	}
	
}
