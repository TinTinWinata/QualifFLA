package Chef;


public class DoneState extends ChefState{
	
	public DoneState(Chef c) {
		super(c);
		c.setName("done");
	}

	@Override
	public void changeState() {
		c.setState(new IdleState(c));
	}
	

}
