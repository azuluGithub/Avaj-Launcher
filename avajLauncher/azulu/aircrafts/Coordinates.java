package azulu.aircrafts;

/*1)-Coordinates are positive numbers
 *2)-The height is in the 0-100 range
 *3)-coordinates can only be accessed through getters
*/

public class Coordinates {

	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		/*1*/
		if (height <= 0) {
			height = 0;
		}
		/*2*/
		else if (height > 100) {
			height = 100;
		}
		this.height = height;
		
		if (longitude <= 0) {
			longitude = 0;
		}
		this.longitude = longitude;
		
		if (latitude <= 0) {
			latitude = 0;
		}
		this.latitude = latitude;
	}
	/*3*/
	public int getLongitude() {
		return this.longitude;
	}
	
	public int getLatitude() {
		return this.latitude;
	}
	
	public int getHeight() {
		return this.height;
	}
}