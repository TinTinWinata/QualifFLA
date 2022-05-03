package Chef;

public class CookState extends ChefState{

	
	public CookState(Chef c) {
		super(c);
		this.name = "cook";
	}

	@Override
	public void changeState() {
		c.setState(new DoneState(c));
	}
	
}
