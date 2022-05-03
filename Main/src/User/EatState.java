package User;

import Main.Restaurant;
import Utillities.Utillities;

public class EatState extends UserState{
	
	private Utillities util = new Utillities();
	
	public EatState(User u) {
		super(u);
		this.setStateName("eat");
	}

	@Override
	public void changeState() {
	}
}
