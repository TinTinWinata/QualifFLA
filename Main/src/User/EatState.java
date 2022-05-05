package User;

import Chef.Chef;
import Main.Game;
import Main.Restaurant;
import Utillities.Utillities;

public class EatState extends UserState{
	
	private Utillities util = Utillities.getInstance();
	private Game game;
	
	public EatState(User u, Chef c) {
		super(u);
		setChef(c);
		this.game = Game.getInstance();
		this.setStateName("eat");
		this.start();
	}
	
	public void run()
	{
		util.wait(6000);
		this.changeState();
	}
	

	@Override
	public void changeState() {
		game.userDoneEat(getChef(), u);
	}
}
