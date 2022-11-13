/*
 * Sunil Rathagirshnan
 * Monday June 3, 2019 Start
 * Wenesday June 13, 2019 Finished
 * img with face is an object 
 */

import java.awt.image.BufferedImage;
 
public class imgWFace {
	
	
	//Instance variables of location, faces and image
 	int faceCount;
	BufferedImage img;
	
	//Default constructor
	public imgWFace() {
 		faceCount=0;
		img=null;
	}

	//Overloaded constructor
	public imgWFace( int faceCount,BufferedImage img) {
 		this.faceCount=faceCount;
		this.img=img;
	}
	 
}
