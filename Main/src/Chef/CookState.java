package Chef;

import User.User;
import Utillities.Utillities;

public class CookState extends ChefState{

	
	private Utillities util;
	private User user;
	
	public CookState(User u, Chef c) {
		super(c);
		util = Utillities.getInstance();
		this.user = u;
		this.name = "cook";
		this.start();
	}

	public void run()
	{
		int waitTime = (6 - c.getSpeed()) * 1000;
		util.wait(waitTime);
		user.getUserState().changeState();
		this.changeState();
	}
	
	@Override
	public void changeState() {
		c.setState(new IdleState(c));
	}
	
}
