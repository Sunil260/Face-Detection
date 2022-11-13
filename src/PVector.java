/*
 * Sunil Rathagirshnan
 * Monday June 3, 2019 Start
 * Wenesday June 13, 2019 Finished
 * Object class for a point XY of the image location
 */

public class PVector {
//Object for a point this helps with pixels in the image
	//X,Y coordinates
	int x,y;
	
	//Default constructor
	public PVector() {
		this.x=0;
		this.y=0;
	}
	
	//Overloaded constructor taking in the X, Y as parameter and setting the instance vars
	public PVector(int x, int y) {
		this.x=x;
		this.y=y;
	} 
	
	
	
}
