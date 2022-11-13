/*
 * Sunil Rathagirshnan
 * Monday June 3, 2019 Start
 * Wenesday June 13, 2019 Finished
 * Image processing algorithms used for face detection withouth the use of libraries
 */
 import java.io.IOException;
import java.util.ArrayList;
 import java.awt.image.BufferedImage;
 
public class ImageProcessingMain{
	
	  public static void main(String args[])throws IOException{
		 
		  new imgProcGUI();
		  //Runs the GUI where all the code is tested
		  
	    }//main() ends here
	  
	  //Finds maxRGB walue from the 24 bit pixel number
	  private static int maxRGB(int p) {
 		
		  //Pushes each component into its own int
	      int r = (p>>16)&0xff;
	      int g = (p>>8)&0xff;
	      int b = p&0xff;
	      
		  //IF statements to check which is greatest then return it
		  if(r>b&&r>g) {
			  return r;
	
		  }else if(b>g&&b>r) {
			  return b;
	
		  }else if(g>r&&g>b) {
			  return g;
	
		  }
		   return 0;
	   } 
	   
	  //Finds minRGB walue from the 24 bit pixel number
	  private static int minRGB(int p) {

		 //Pushes each component into its own int
	     int r = (p>>16)&0xff;
	     int g = (p>>8)&0xff;
	     int b = p&0xff;
		 
	     //IF statements to check which is smallest then return it
		  if(r<b&&r<g) {
			  return r;
	
		  }else if(b<g&&b<r) {
			  return b;
	
		  }else if(g<r&&g<b) {
			  return g;
	
		  }
		   return 0;
	  } 
	 
	  //Method to find skin and create a binary (Black and white) image
	  //Takes a buffered image object to be manipulated
	  public static BufferedImage BlackWhite(BufferedImage img) {
		 
		//get image width and height
	  	int width = img.getWidth();
	  	int height = img.getHeight();
	
	  	//Run through all pixels in image
	   		for(int y = 0; y < height; y++){	  	
	   			for(int x = 0; x < width; x++){
	      
	   			//Gets 24 bit pixel number
	   			//Pushes each pert into 4 components of a pixel
	  			int p = img.getRGB(x,y);
	  			int a = (p>>24)&0xff;
	  			int r = (p>>16)&0xff;
	  			int g = (p>>8)&0xff;
	  			int b = p&0xff;
	  			
	  			//Create the YCbCr color space nums into doubles to be able to be percise
	  			Double	Y = (0.299*r) + (0.587*g) + (0.114*b);
	  			Double Cb = (b-Y) * 0.564 + 128;
	  			Double Cr = (r-Y) *0.713 + 128;
		       
	  			//Gets max value of rgb and min value of rgb to be able to perform the skin detection
	  		    int maxRGB=maxRGB(p);
  			    int minRGB=minRGB(9);
  			  
  			    //Skin detection algorithm using data collected through AI
  			    //Using both rgb and YCbCr color spaces
  			    //Creating a binary image for easy analysis 
  			    //Black == skin
  			    //White == not skin
  			    
	  			if( r>95&&g>40&&b>20&&(maxRGB-minRGB)>15&&(r-g>15)&&r>g&&r>b||Cr>135 && Cr<180 && Cb>85 && Cb<135&&Y>80) {
	  			   
	  				//pushes black rgb to 24 bit pixel num
			      	p = (a<<24) | ((0)<<16) | (0<<8) | (0);
			        img.setRGB(x, y, p);    
			      	
			      } else {	
			    	  
		  			//pushes white rgb to 24 bit pixel num
			      	p = (a<<24) | ((255)<<16) | (255<<8) | (255);
			        img.setRGB(x, y, p);   
			      	
			      }				 
	   			}	
	   		}
	   	
	   	 
	  			
	   			
	   				
	   		
	   	
	   //Returns the image thats modded		
	   return img;
	   	
	  }
	  
	  //Reduces noise in image. teakes in the buffered image object to be manipulated andd the size for soize reduction as it is done in sqaures of X*X 
	  public static BufferedImage Lowpass(BufferedImage img,int fSize) {
		
		  //Ints to keep track of two pixels
		  //int for the pixel bit num
		  int blacks=0;
		  int whites=0;
		  int pixelBit=0;
		  int chkSize=fSize;
		  
		  //Loop 2 dimentionaly with a square based on noise reduction size. In search for black and white pixels
		  for(int bigX=0;bigX<img.getWidth()-chkSize;bigX+=chkSize) {  
			  for(int bigY=0;bigY<img.getHeight()-chkSize;bigY+=chkSize) {
				
				  //Resets values to for each new square being looked at
				  whites=0;
				  blacks=0;
				  pixelBit=0;
				 
				  //Loop through pixels in the squate region beeing currently analyzed
				  for(int x1 = bigX; x1 < bigX+chkSize; x1++){	
					  for(int y1 = bigY; y1 < bigY+chkSize; y1++){
	  
						  //Gets the piel bit number
						  //Pushes into rgb components
						  pixelBit=img.getRGB(x1, y1);
						  int r = (pixelBit>>16)&0xff;
				  		  int g = (pixelBit>>8)&0xff;
				  		  int b = pixelBit&0xff;
						 
				  		    //Checks the piels and sees which color it is to increase the specific value of blacks and whites
							if(r==255&&g==255&&b==255) {
								whites++; 
							}else {
								blacks++;
							}}}
				  
				  //Checks the dominant color in the region and sets all pixels to the dominant pixel
				  if(blacks>whites) {
					  for(int x1 = bigX; x1 < bigX+chkSize; x1++){				      	
						  for(int y1 = bigY; y1 < bigY+chkSize; y1++){
							  
							  //Sets all to black if it is dominant
							  pixelBit =  ((0)<<16) | (0<<8) | (0);
						      img.setRGB(x1, y1, pixelBit);							  
						  }}  
				  }else {
					  for(int x1 = bigX; x1 < bigX+chkSize; x1++){
					      	
						  for(int y1 = bigY; y1 < bigY+chkSize; y1++){
							  //Sets all to white if it is dominant
							  pixelBit =  ((255)<<16) |((255)<<8) | (255);
						      img.setRGB(x1, y1, pixelBit);							  
						  }}}}}  
	  //Returns the modified image
	  return img;	 
}
 	  
	  //Method to sort all the blobs based in size largest to smallest
	  public static ArrayList<FaceBlob> sort(ArrayList<FaceBlob> blobs){
		  
		  //Goes to private method merge sort
		  blobs=mergeSort(blobs);
 		 
		  //Loop to system out the list of blobs 
		  for(FaceBlob a:blobs){
			 System.out.println(a.toString()); 
		  }
		  return blobs;

	  }
	  
	  //Private method for merge sort to split the arraylist
	  private static ArrayList<FaceBlob> mergeSort(ArrayList<FaceBlob> whole) {
		  	
		  	//Create two arrays for every array that is passed in when called 
		    ArrayList<FaceBlob> left = new ArrayList<FaceBlob>();
		    ArrayList<FaceBlob> right = new ArrayList<FaceBlob>();
		    
		    //Integer to hold the center of the whole array to know where to "split" but actually fill the left and right to and from that point
		    int center ;
		    
		    //Checks if there is only one object in the arraylist
		    if (whole.size() == 1) {    
		        return whole;
		    } else {
		    	//Get the middle of the arraylsit
		        center = whole.size()/2;
 		        	
		            //Gets the components up to the middle and saves it into the left array
			        for (int i=0; i<center; i++) {
			                left.add(whole.get(i));
			        }
			 
		            //Gets the components from the middle to the end and saves it into the right array
 			        for (int i=center; i<whole.size(); i++) {
			                right.add(whole.get(i));
			        }
		 
		        // recurse to the mergeSort for the left and right halves of the arraylist
		        left  = mergeSort(left);
		        right = mergeSort(right);
		 
		        // Merge the results back together
		        merge(left, right, whole);
		    }
		    return whole;
		}
	  
	  //Private helper method to put the array lists back together
	  private static void merge(ArrayList<FaceBlob> left, ArrayList<FaceBlob> right, ArrayList<FaceBlob> whole) {
		   
		  	//Keeps track of all locations for the whole, left, and right 
		  	int leftIndex = 0;
		    int rightIndex = 0;
		    int wholeIndex = 0;
		 
		    //Goes through  both arrays 
		    while (leftIndex < left.size() && rightIndex < right.size()) {
		      
		    	//Checks if the current index of the left arraylists size is greater than the right side 
		    	//Sets the whole arrays index to the greater one's
		    	if (left.get(leftIndex).size()>right.get(rightIndex).size()){
		            whole.set(wholeIndex, left.get(leftIndex));
		            leftIndex++;
		        } else {
		        	//When the right is larger save the right index into the whole array
		            whole.set(wholeIndex, right.get(rightIndex));
		            rightIndex++;
		        }
		    	//Goes to the next index  of the array
		        wholeIndex++;
		    }
		 
		    //Checks the remaining objects and saves it into the rest array in the restOfList array 
		    ArrayList<FaceBlob> restOfList;
		    int restIndex;
		    
		    if (leftIndex >= left.size()) {
 		    	restOfList = right;
		        restIndex = rightIndex;
		    } else {   
		    	restOfList = left;
		        restIndex = leftIndex;
		    }
		 
		    // Copy the remaining list to the whole ArrayList which ever side is not used up
		    for (int i=restIndex; i<restOfList.size(); i++) {
		        whole.set(wholeIndex, restOfList.get(i));
		        wholeIndex++;
		    }
		}
    
	  //Filter to find shapes in the image then uses the isFace method to see if it is a face
	  public static BufferedImage shapeFind(BufferedImage img,ArrayList<FaceBlob> faceBlobs,ArrayList<Blob> blobs, BufferedImage img2,int distance,double minThresh,double maxThresh) {
		  
		  //Loops through the entire image 
		  for(int x = 0; x < img.getWidth(); x++){	  	
	   			for(int y = 0; y < img.getHeight(); y++){
 	  			
	   				//gets and pushes the bit pixel num to rgb color space
		   			int p = img.getRGB(x,y); 
	 	  			int r = (p>>16)&0xff;
		  			int g = (p>>8)&0xff;
		  			int b = p&0xff;
	 
		  		    //Checks if it meets black threshold
			  	    if(r==0&&b==0&&g==0) {
			  	    	
			  	    	//Sees if a blob was found in the array list to avoid creating a new blob
			  	    	boolean found=false;	
			  			
			  	    	//Runs through all the blob objects 
			  	    	for(Blob b1:blobs) {			  				
	 		  				
			  	    		//Checks if current pixel is near any pixel in the current blob 
			  	    		if(b1.isNear(x,y,distance) ){			
			  	    			
			  	    			 //Adds to the blob object
			  	    			 //Stops loop so that the pixel is only added to one blob
		 		  				 b1.add(x,y);
				  				 found=true;
				  				 break;
		 		     		}	
			  			}
			  	    	
			  	    	//If after the loop it is not near any blob the it is a new blob
			  			if(!found ){  
			  				//Creates new blob with adding it to the list
			  				blobs.add(new FaceBlob(x,y));
			  			}		
			  	    }	        
	   			}
		  }
		  
  		  //loop through the blobs int the array 
		  for(Blob b1:blobs) {
			  		
	     //Checks if it is a face using the method in faceblob
		 if(b1.isFace(  minThresh,  maxThresh)) {
			 //Uses method to set the secure id number 
			 faceBlobs.add((FaceBlob) b1);
		  }
		  
 		  }
		  //id number for each face 

		  int idNum=0;

		  for(FaceBlob a:faceBlobs) {
			  a.setID("# "+idNum);
				//Adds to the id number
			  //Draws the dot on the actual image and also id number 
  			  a.draw(img2.createGraphics());	
			 
			 idNum++;
		  }
		  
		  //Returns the final image with identified faces
		  return img2;
}  	  
}
	















	
/* File f =  new File("/Users/sunil/Pictures/testIM.jpg");
File fnum2 =  new File("/Users/sunil/Pictures/testIM.jpg");
BufferedImage img2= ImageIO.read(fnum2);
BufferedImage img = ImageIO.read(f);
BufferedImage analyzeImg = img;

ArrayList<FaceBlob> faceBlobs = new ArrayList<FaceBlob>();

analyzeImg=BlackWhite(analyzeImg);
File bWIMG=new File("/Users/sunil/Pictures/BWBOTH.jpg");
ImageIO.write(analyzeImg, "jpg", bWIMG);
 
analyzeImg =Lowpass(analyzeImg);
File LPIMG=new File("/Users/sunil/Pictures/BWCLEANEDBOTH.jpg");
ImageIO.write(analyzeImg, "jpg", LPIMG);


analyzeImg= shapeFind( analyzeImg,faceBlobs,img2);	      	    
File finalIMG=new File("/Users/sunil/Pictures/detectedTogether.jpg");
ImageIO.write(analyzeImg, "jpg", finalIMG);*/
/*	  int d1=blobs.get(i).maxX-blobs.get(i+1).maxX;
int d2=blobs.get(i).maxX-blobs.get(i+2).maxX;;
int d3=blobs.get(i).maxX-blobs.get(i+3).maxX;;
int davg=(d1+d2+d3)/3;

if( d1<davg) {
	 
	 blobs.remove(i+1);
}  
if( d2<davg) {
	 
	 blobs.remove(i+2);
} 
if( d3<davg) {
	 
	 blobs.remove(i+3);
}
*/

