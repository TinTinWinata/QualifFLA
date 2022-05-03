package Chef;

public class IdleState extends ChefState{
	
	public IdleState(Chef c) {
		super(c);
		this.name = "idle";
	}
	
	@Override
	public void changeState() {
		c.setState(new CookState(c));
	}
}
