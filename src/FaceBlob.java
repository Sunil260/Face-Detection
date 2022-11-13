/*
 * Sunil Rathagirshnan
 * Monday June 3, 2019 Start
 * Wenesday June 13, 2019 Finished
 * Object class for blob object, this keeps all skin color pixels, whith the max XY and min XY which are the
 * corners of the object. This is used to show and findout if the skin is a face based on height to width ratio
 */
	import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

    public class FaceBlob extends Blob{

    //Id for safe identification that is inaccessible in other classes
    private String id;
 	
    //Method to set the ID
    public  void setID(String nm) {
    	this.id= nm;
    }
    
    //Method to get the ID as it is private
    public String getID() {
    	return id;
    }
    
    //Default Constructor
    public FaceBlob() {
    	//Calls the super to use the default constructor of the etended class
    	super();
 	}

    //The overloaded constructor with the x,y coordinate parameters
	public FaceBlob(int x, int y) {
    	  
		  //Calls the super to use the overloaded constructor of the extended class
		  super(x,y);	  
	}

	//Overriding toString method for objects to return size, max X Y and min X Y
	public String toString() {
		
		return "Size= "+ this.size() +" Xs= "+this.maxX+" to "+this.minX+ " Ys= "+ this.maxY+" to "+this.minY+"\n";
	}
 
	//Draw method to draw the blob onto image
	//Takes the graphics object from the buffered image 
	public void draw(Graphics g) {
		
		//Finds the center of the blob object
		int cx=(minX+maxX)/2;
		int cy=(minY+maxY)/2;
		//Sets the color
        g.setColor(new Color( 0,0,255)); 
        //draws the id number
        g.drawString(this.getID(), cx, cy);
        //Change color
        g.setColor(new Color( 255,0,0)); 
        //Draw oval
        g.fillOval(cx, cy, 15, 15);
  		g.drawOval(cx, cy,15,15); 
 		
	}
	
    }
    
    
    
    
    
    
    
    
    /*
     *   
    //Checks the blob to see if it is a face
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
     
      
     	//Adds to the blob by adding the point
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
	
     * */
