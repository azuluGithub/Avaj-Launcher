package azulu.weather;

import java.util.*;
import azulu.weather.Flyable;

/*this is a parent class
 *its also a subject class
 *it registers, unregisters and updates observers
*/

public class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	
	public void register(Flyable flyable) {
		observers.add(flyable);
	}
	
	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}
	
	protected void conditionsChanged() {
		int index = 0;
		while (index < observers.size()) {
			observers.get(index).updateConditions();
			index++;
		}
	}
	
}
