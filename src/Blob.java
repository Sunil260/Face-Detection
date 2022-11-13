/*
 * Sunil Rathagirshnan
 * Monday June 3, 2019 Start
 * Wenesday June 13, 2019 Finished
 * Blob object to be used for future implemention of other types. Acts as super class for a face blob
 * 
 */


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Blob {
	
	//int for the corners of the rect of object blob
	int maxX,minX,maxY,minY;
	
	//List of point objects
	ArrayList<PVector> point;
	
	//Default constructo
	public Blob() {
		
		maxX=0;
		maxY=0;
		minY=0;
		minX=0;
	}
	
	//Overloaded constructor 
    public Blob(int x, int y) {
	
	    this.point=new ArrayList<PVector>();
        PVector v=new PVector(x,y);
		this.point.add(v);
		maxX=x;
		minX=x;
		maxY=y;
		minY=y;
	
    }
	
    public boolean isFace(double minThresh,double maxThresh) {
        
        //gets the height and width of a blob to find the height to width ratio of faces
        double h=this.maxY-this.minY;
        double w= this.maxX-this.minX;
        	
        	//Checks if the height to width ratio is within a specific threshold 
        	if(h/w<maxThresh && h/w>minThresh) {
        		return true;
        	}
        	else {
        	return false;}
        }

	public void add(int x, int y ) {
		
		//this.point= new ArrayList<PVector>();
	    this.point.add(new PVector(x,y));
 
	    //Sets the min and maxs 
		this.minX=Math.min(x,this.minX);
		this.minY=Math.min(y,this.minY);
		this.maxX=Math.max(x,this.maxX);
		this.maxY=Math.max(y,this.maxY);
		//Checks whichever is less and uses it 
		
	}

	//Checks if the coordinate is near
	public boolean isNear(int x,int y,int distance) {
	  
		//int for distance 
		int d=10000;	
		
		//Checks and compares all vectors and checks the distance
		for(PVector a:this.point) {
			//DIstance equation on two dimensional plane
 			int tempD= (int) (Math.sqrt((Math.abs(x-a.x)^2)+(Math.abs(y-a.y)^2)));
 
 			//Sets the distance to the temporary distance if it is less than the distance
 			if(tempD<d)d=tempD;
  		}
 		
		//Checks if it meets a threshold
 		if((d<distance)) {
			return true; 
		}else {
		return false;
		}
		 
		
	}

	//Checks the size of a blob and returns the int
	public int size() {
 	
		//returns size calculation
		return (Math.abs(this.maxX-this.minX)) *(Math.abs( this.maxY-this.minY));
	}

	//Overriding toString method for objects to return size, max X Y and min X Y
	public String toString() {
		
		return "Size= "+ this.size() +" Xs= "+this.maxX+" to "+this.minX+ " Ys= "+ this.maxY+" to "+this.minY+"\n";
	}
 
	//Draw method to draw the blob onto image
	//Takes the graphics object from the buffered image 
	 


}
