package Chef;

import User.User;

public class DoneState extends ChefState{
	
	public DoneState(Chef c, User u) {
		super(c);
		this.name = "done " + u.getName();
	}

	@Override
	public void changeState() {
		c.setState(new IdleState(c));
	}
	

}
