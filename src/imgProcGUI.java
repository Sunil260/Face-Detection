import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JSpinner;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;

public class imgProcGUI extends JFrame{
	
	private JTextField txtNm;
	private JTextField txtMin;
	private JTextField txtMax;
	
	public imgProcGUI()throws IOException{

		setResizable(false);
		 setSize(1350 , 660);		
			//Building the GUI the start to a long loooooong process
	 			 
				//Set the title for the frame 
		  		setTitle("Restauraunt Mangement Group");
				
		  		//Set the size and start location 
				//Panel with color and opacity
				//Bounds
				//Back
				//Foreground
				//Added
				JPanel restaurantPan = new JPanel(); 
				restaurantPan.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				restaurantPan.setBackground(new Color(15,79, 133,180));
		 		restaurantPan.setBounds(0,108,886,87);
				getContentPane().setLayout(null);
				getContentPane().add(restaurantPan);
				restaurantPan.setLayout(null);
				
				//text field for input
				txtNm = new JTextField();
				txtNm.setText("/Users/sunil/Pictures/...");
				txtNm.setColumns(10);
				txtNm.setBounds(105, 16, 338, 26);
				restaurantPan.add(txtNm);
				
				//title
				JLabel lblName = new JLabel("File Directory");
				lblName.setForeground(Color.WHITE);
				lblName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				lblName.setBounds(6, 16, 204, 27);
				restaurantPan.add(lblName);
				
				//button for skindetect
				JButton btnBuild = new JButton("Skin Detection");
				btnBuild.setBackground(new Color(255, 165, 0));				 
				btnBuild.setBounds(105, 46, 117, 29);
				restaurantPan.add(btnBuild);
				
				//lowpass button
				JButton btnLowPassFilter = new JButton("Reduce Noise");
				btnLowPassFilter.setBackground(new Color(255, 165, 0));
				btnLowPassFilter.setBounds(217, 46, 117, 29);
				restaurantPan.add(btnLowPassFilter);
				
				//final face detect filter
				JButton btnFinalDetection = new JButton("Face Detection");
				btnFinalDetection.setBackground(new Color(255, 165, 0));
				
				btnFinalDetection.setBounds(326, 46, 117, 29);
				restaurantPan.add(btnFinalDetection);
				
				//upload to display img
				JButton btnUpload = new JButton("Upload");

				btnUpload.setBackground(new Color(255, 165, 0));
				btnUpload.setBounds(441, 16, 92, 59);
				restaurantPan.add(btnUpload);
				
				 
				//Setting the nice background image up as an icon to be able to be used in a label
				ImageIcon img=new ImageIcon("/Users/sunil/gr12/ImageGray/src/teck.png");
				Image image = img.getImage(); // transform it 
				Image newimg = image.getScaledInstance(1350 , 660, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				img = new ImageIcon(newimg);
				
				//Panel for everything
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_1.setBackground(new Color(15,79, 133, 180));
				panel_1.setBounds(0, 195, 443, 455);
				getContentPane().add(panel_1);
				
				//Title for og pic
				JLabel lblOriginal = new JLabel("Original");
				lblOriginal.setForeground(Color.WHITE);
				lblOriginal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblOriginal.setBounds(6, 6, 431, 27);
				panel_1.add(lblOriginal);
				
				//Pic img frm
				JLabel ogIMGlbl = new JLabel("");
				ogIMGlbl.setBounds(6, 45, 431, 303);
				panel_1.add(ogIMGlbl);
				
				//Panel with color and opacity//Bounds//Back//Foreground//Added
				JPanel bannerPan = new JPanel();
				bannerPan.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				bannerPan.setBackground(new Color(15,79, 133,180));
				bannerPan.setForeground(new Color(0, 0, 0));
				bannerPan.setBounds(0, 0, 886, 108);
				getContentPane().add(bannerPan);
				bannerPan.setLayout(null);
				
				//Title on a panel larger name with specific font 
				JLabel lblNewLabel_1 = new JLabel("Face Detection ");
				lblNewLabel_1.setForeground(new Color(218, 165, 32));
				lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 66));
				lblNewLabel_1.setBounds(144, 19, 436, 83);
				bannerPan.add(lblNewLabel_1);
				
				//Little icon img prep for use
				ImageIcon BanIMG=new ImageIcon("/Users/sunil/gr12/ImageGray/src/logo.png");
				Image BannerIMG = BanIMG.getImage(); // transform it 
				Image plnewimg = BannerIMG.getScaledInstance(130 , 95, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				BanIMG = new ImageIcon(plnewimg);  // transform it back
				
				//Icon display spot
				JLabel lblplane = new JLabel();
				lblplane.setIcon(BanIMG);
				lblplane.setBounds(6, 6, 132, 96);
				bannerPan.add(lblplane);
				
				//Panel with color and opacity//Bounds//Back//Foreground//Added
				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_2.setBackground(new Color(15,79, 133, 180));
				panel_2.setBounds(886, 195, 464, 443);
				getContentPane().add(panel_2);
				
				//Title label
				JLabel lblFaceDetection = new JLabel("Face Detection");
				lblFaceDetection.setForeground(Color.WHITE);
				lblFaceDetection.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblFaceDetection.setBounds(6, 6, 196, 27);
				panel_2.add(lblFaceDetection);
				
				JLabel fceD = new JLabel("");
				fceD.setBounds(6, 45, 452, 303);
				panel_2.add(fceD);
				
				//Panel with color and opacity//Bounds//Back//Foreground//Added
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel.setBackground(new Color(15,79, 133, 180));
				panel.setBounds(443, 195, 443, 443);
				getContentPane().add(panel);
				
				//Subheading 
				JLabel lblLowPassFilter = new JLabel("Noise Reduction");
				lblLowPassFilter.setForeground(Color.WHITE);
				lblLowPassFilter.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblLowPassFilter.setBounds(6, 239, 102, 27);
				panel.add(lblLowPassFilter);
				
				//img frame
				JLabel lPfil = new JLabel("");
				lPfil.setBounds(102, 239, 303, 197);
				panel.add(lPfil);
				
				//Subheading
				JLabel label_3 = new JLabel("Skin Detection");
				label_3.setBounds(6, 6, 84, 27);
				panel.add(label_3);
				label_3.setForeground(Color.WHITE);
				label_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				
				//img frame
				JLabel sknD = new JLabel("");
				sknD.setBounds(102, 19, 303, 197);
				panel.add(sknD);
				
				//Panel with color and opacity//Bounds//Back//Foreground//Added
				JPanel panel_3 = new JPanel();
				panel_3.setLayout(null);
				panel_3.setForeground(Color.BLACK);
				panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_3.setBackground(new Color(15, 79, 133, 180));
				panel_3.setBounds(886, 0, 464, 195);
				getContentPane().add(panel_3);
				
				//Sub heading
				JLabel lblAdjustments = new JLabel("Adjustments");
				lblAdjustments.setBounds(20, 17, 92, 17);
				panel_3.add(lblAdjustments);
				lblAdjustments.setForeground(Color.WHITE);
				lblAdjustments.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				
				//Spinner for values
				JSpinner spnS = new JSpinner();
				spnS.setBounds(108, 46, 101, 26);
				panel_3.add(spnS);
				
				//Spinner for values
				JSpinner dSpn = new JSpinner();
				dSpn.setBounds(108, 84, 101, 26);
				panel_3.add(dSpn);
				
				//Value input
				txtMin = new JTextField();
				txtMin.setBounds(108, 120, 101, 26);
				panel_3.add(txtMin);
				txtMin.setColumns(10);
				
				//subtitle
				JLabel lblSize = new JLabel("Size");
				lblSize.setForeground(Color.WHITE);
				lblSize.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblSize.setBounds(20, 51, 82, 17);
				panel_3.add(lblSize);
				
				//subtitle
				JLabel lblDistance = new JLabel("Distance");
				lblDistance.setForeground(Color.WHITE);
				lblDistance.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblDistance.setBounds(20, 89, 82, 17);
				panel_3.add(lblDistance);
				
				//subtitle
				JLabel lblHwRatio = new JLabel("H/W Ratio min");
				lblHwRatio.setForeground(Color.WHITE);
				lblHwRatio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblHwRatio.setBounds(20, 125, 92, 17);
				panel_3.add(lblHwRatio);
				
				//in values
				txtMax = new JTextField();
				txtMax.setColumns(10);
				txtMax.setBounds(108, 154, 101, 26);
				panel_3.add(txtMax);
				
				//subtitle
				JLabel lblHwRatioMax = new JLabel("H/W Ratio max");
				lblHwRatioMax.setForeground(Color.WHITE);
				lblHwRatioMax.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblHwRatioMax.setBounds(20, 159, 92, 17);
				panel_3.add(lblHwRatioMax);
				
				//Backgroung img label
				JLabel backImg = new JLabel();
				backImg.setBounds(0,0,1350 , 638); 
				backImg.setIcon(img);
				getContentPane().add(backImg);
				
				 //Make frame visible
				setVisible(true);

				//Skin processing runner
				btnBuild.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						
						//file name get and creating two imgs
						String file= txtNm.getText();
						File firstImg =  new File(file);
						//Create a buffered img
 					    BufferedImage img1=null;
 					 	
 					   try {
 						    //get the file and read it to the img
							img1 = ImageIO.read(firstImg);
 							
						} catch (IOException e2) {
 							e2.printStackTrace();
						}
					       
 					   //create new buffered image to save it
					    BufferedImage analyzeImg = img1;
					    
					    //Call the  method for black white
				 	   analyzeImg=ImageProcessingMain.BlackWhite(analyzeImg);
				 	   
				 	   //Write to this new file
					   File bWIMG=new File("/Users/sunil/Pictures/BWBOTH.jpg");			  
					   try {
						ImageIO.write(analyzeImg, "jpg", bWIMG);
					   } catch (IOException e1) {
 						e1.printStackTrace();
					   }
					   
					//Change to img icon and change size for label use
 					ImageIcon BW=new ImageIcon("/Users/sunil/Pictures/BWBOTH.jpg");
					Image  IMG = BW.getImage(); // transform it 
					Image plnewimg =  IMG.getScaledInstance(303 , 197, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					BW = new ImageIcon(plnewimg);  // transform it back
					//set label icon
					sknD.setIcon((Icon) BW);

					}
				});
				
				//Nose reduction filter to make a claen image
				//Get all the input files
				//Make new buffered images
				//Set image icons on the labels 
				//Write out to a new file
				btnLowPassFilter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String file= txtNm.getText();
						File firstImg =  new File(file);
						File secImg =  new File(file);
 					    BufferedImage img1=null;
 					    BufferedImage img2=null;
					 	
 					   try {
 						   
							img1 = ImageIO.read(firstImg);
							img2 = ImageIO.read(secImg);
							
						} catch (IOException e2) {
 							e2.printStackTrace();
						}
					       
					   BufferedImage analyzeImg=ImageProcessingMain.BlackWhite(img1);				 	   
					   File bWIMG=new File("/Users/sunil/Pictures/BWBOTH.jpg");
					  
					   try {
						ImageIO.write(analyzeImg, "jpg", bWIMG);
				    	} catch (IOException e1) {
 						e1.printStackTrace();
					   }

					   ImageIcon BW=new ImageIcon("/Users/sunil/Pictures/BWBOTH.jpg");
						Image  IMG = BW.getImage(); // transform it 
						Image plnewimg =  IMG.getScaledInstance(303 , 197, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
						BW = new ImageIcon(plnewimg);  // transform it back
						
						int spn=0;
						
						try {
						  spn=(int) spnS.getValue();
						}catch(Exception z){
							JOptionPane.showMessageDialog(null,
								    "Enter Valid Information",
								    "Inane error",
								    JOptionPane.ERROR_MESSAGE);
						}
						sknD.setIcon((Icon) BW);
						
  					 analyzeImg =ImageProcessingMain.Lowpass(analyzeImg,spn);
					 File LPIMG=new File("/Users/sunil/Pictures/BWCLEANEDBOTH.jpg");
					 try {
						ImageIO.write(analyzeImg, "jpg", LPIMG);
					} catch (IOException e1) {
 						e1.printStackTrace();
					}
					 
					    ImageIcon LP=new ImageIcon("/Users/sunil/Pictures/BWCLEANEDBOTH.jpg");
						Image lpIMG = LP.getImage(); // transform it 
						Image lpFimg=lpIMG.getScaledInstance(303 , 197, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
						LP = new ImageIcon(lpFimg);  // transform it back						
 						lPfil.setIcon((Icon) LP);
 					}
				});
			 
				//CHeck for faces in image by use of blob detection
				//Check the img blobs for is face
				//calls all the methods to make everthing run 
				//out put to new files keeping the old ones
				btnFinalDetection.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String file= txtNm.getText();
						File firstImg =  new File(file);
						
 					    BufferedImage img1=null;
 					    BufferedImage img2=null;
					 	
 					   try {
 						   
							img1 = ImageIO.read(firstImg);
							img2 = ImageIO.read(firstImg);
							
						} catch (IOException e2) {
 							e2.printStackTrace();
						}
					       
					    BufferedImage analyzeImg = img1;

 
				 	   analyzeImg=ImageProcessingMain.BlackWhite(analyzeImg);
				 	   
					   File bWIMG=new File("/Users/sunil/Pictures/BWBOTH.jpg");
					   try {
						ImageIO.write(analyzeImg, "jpg", bWIMG);
					} catch (IOException e1) {
 						e1.printStackTrace();
					}

					   ImageIcon BW=new ImageIcon("/Users/sunil/Pictures/BWBOTH.jpg");
						Image  IMG = BW.getImage(); // transform it 
						Image plnewimg =  IMG.getScaledInstance(303 , 197, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
						BW = new ImageIcon(plnewimg);  // transform it back
						sknD.setIcon((Icon) BW);
						int spn=0;
						
						try {
						  spn=(int) spnS.getValue();
						}catch(Exception z){
							JOptionPane.showMessageDialog(null,
								    "Enter Valid Information",
								    "Inane error",
								    JOptionPane.ERROR_MESSAGE);
						}
 					 analyzeImg =ImageProcessingMain.Lowpass(analyzeImg,spn);
 					 
					 File LPIMG=new File("/Users/sunil/Pictures/BWCLEANEDBOTH.jpg");
					 
					 try {
						ImageIO.write(analyzeImg, "jpg", LPIMG);
					 } catch (IOException e1) {
 						e1.printStackTrace();
					 }
					 
					 
					    ImageIcon LP=new ImageIcon("/Users/sunil/Pictures/BWCLEANEDBOTH.jpg");
						Image lpIMG = LP.getImage(); // transform it 
						Image lpFimg=lpIMG.getScaledInstance(303 , 197, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
						LP = new ImageIcon(lpFimg);  // transform it back						
						lPfil.setIcon((Icon) LP);
						
						ArrayList<Blob> blobs=new ArrayList<Blob>();

						ArrayList<FaceBlob> faceBlobs = new ArrayList<FaceBlob>();
						try {
 						analyzeImg= ImageProcessingMain.shapeFind( analyzeImg,faceBlobs,blobs,img2,((int)dSpn.getValue()),(Double.parseDouble(txtMin.getText())),(Double.parseDouble(txtMax.getText())));	 
						}catch(Exception z){
							JOptionPane.showMessageDialog(null,
								    "Enter Valid Information",
								    "Inane error",
								    JOptionPane.ERROR_MESSAGE);
						}
						
						File finalIMG=new File("/Users/sunil/Pictures/detectedTogether.jpg");
						try { 
							ImageIO.write(analyzeImg, "jpg", finalIMG);
						} catch (IOException e1) {
 							e1.printStackTrace();
						}
						
						    ImageIcon FIMG=new ImageIcon("/Users/sunil/Pictures/detectedTogether.jpg");
							Image finIMG = FIMG.getImage(); // transform it 
							Image finimgO=finIMG.getScaledInstance(431 , 301, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
							FIMG = new ImageIcon(finimgO);  // transform it back						
 	 						fceD.setIcon((Icon) FIMG);	
 	 						
 							ArrayList<imgWFace> faceImages = new ArrayList<imgWFace>();

 	 						ImageProcessingMain.sort(faceBlobs);
 	 						
 	 						if(faceBlobs.size()>0) {
 	 							faceImages.add(new imgWFace(faceBlobs.size(),analyzeImg));
 	 						}
   

 	 				}
				});

				//Pulls original image to output to GUI 
 				btnUpload.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 
 					    ImageIcon BW=new ImageIcon(txtNm.getText());
 						Image  IMG = BW.getImage(); // transform it 
 						Image plnewimg =  IMG.getScaledInstance(431 , 301, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
 						BW = new ImageIcon(plnewimg);  // transform it back
 						
 						ogIMGlbl.setIcon((Icon) BW);
 					   
						
					}
				});

	}
}
