package Main;

public abstract class RestaurantState {
	
	Restaurant restaurant;
	public RestaurantState(Restaurant restaurant)
	{
		super();
		this.restaurant = restaurant;
	}
	
	public abstract void changeState();
	
}
