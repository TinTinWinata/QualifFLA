package Main;

public class ActiveState extends RestaurantState{

	
	public ActiveState(Restaurant restaurant) {
		super(restaurant);
	}

	@Override
	public void changeState() {
		restaurant.state = new NonActiveState(restaurant);
	}
	
}
