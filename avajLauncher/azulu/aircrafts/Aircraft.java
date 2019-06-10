package azulu.aircrafts;

import azulu.aircrafts.Coordinates;

/*this is a parent class
 *1)-protected methods and attributes can be accessed by child classes
 *2)-private methods and attributes are only accessed in this class
 *3)-nextId method is useless to me beoz idCounter is doing a good job
*/

public class Aircraft {
	/*1*/
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	/*2*/
	private static long idCounter = 1;
	
	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = idCounter++ + nextId();
	}
	/*3*/
	private long nextId() {
		return (0);
	}
}