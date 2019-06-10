package azulu.main;

import azulu.ritefile.*;

/* R object is created so that its class is accessed
 * from other classes without using static methods
 * 1)-reads from a file to array list,
 *    then creates new aircraft
 * 2)-registers aircrafts,
 *	  and updates weather conditions
 * 3)-writes messages from array list to file
*/
public class Main {
	
	public static void main(String[] args) {
		
		RidFile R = new RidFile();
		
		/*1*/
		R.ridFile(args);

		/*2*/
		new Simulator().simulate(R);

		/*3*/
		RiteFile.addMessageToFile();
	}
}
