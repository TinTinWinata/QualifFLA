package Main;

public class NonActiveState extends RestaurantState{

	public NonActiveState(Restaurant restaurant) {
		super(restaurant);
	}

	@Override
	public void changeState() {
		restaurant.state = new ActiveState(restaurant);
	}

}
