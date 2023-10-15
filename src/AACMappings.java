import structures.AssociativeArray;
import structures.KVPair;
import structures.KeyNotFoundException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;


/*
 * @author Che Glenn
 * Date: October 13
 * 
 * AACMappings keeps track of the complete set of AAC mappings. It will store the mapping of the images on the home page to the AACCategories. 
 * 
 */


public class AACMappings {
  /*
   * FIELDS
   */

  String fileName; //name of file 

  AssociativeArray<String, AACCategory<String,String>> imageMap = new AssociativeArray<>();
  AACCategory<String,String> topCategory = new AACCategory<String, String>("top");

  AACCategory<String,String> currentCategory;

  File newFile;

 
   /*
    * CONSTRUCTOR
    */

    public AACMappings(String fileName){

      this.currentCategory = this.topCategory; //set current category to top category

      newFile = new File(fileName); //create new file of fileName
     try {
        Scanner sc = new Scanner(newFile); //create scanner for newFie
        while (sc.hasNextLine()){ //while there are lines to read in file
          String line = sc.nextLine(); //save line
          String[] lineArr = line.split(" "); //split line at space and save to String[]

          if(!(line.startsWith(">"))){ //if line does not start with carrot
           topCategory.addItem(lineArr[0], lineArr[1]); //add imageLoc and name to topCategory
           imageMap.set(lineArr[0], new AACCategory<>(lineArr[1])); //map imageLoc to new AACCategory of image name
           try{
            this.currentCategory = this.imageMap.get(lineArr[0]); //set current cat to corresponding image
           } catch (KeyNotFoundException e) {} 
          } //if
          else{
            lineArr[0] = lineArr[0].substring(1, lineArr[0].length()); //concat line arr to remove carrot
            this.currentCategory.addItem(lineArr[0], lineArr[1]); //add imageLoc and image name to currentCat
          } //else
        } //while
        try{
          sc.close(); //close scanner
          this.currentCategory = this.topCategory; //set current category to top category
        } catch (Exception e) {}
      } catch (Exception e) {}
    } 

    /*
     * METHODS
     */

     /*
      * Adds the mapping to the current category (or the default category if that is the current category)
      * pre: String imageLocation, String text to assoc with image
      * post: 
      */
     public void add(String imageLoc, String text){
      this.currentCategory.addItem(imageLoc, text); //add item to current cat
     }//add()

     /*
      * Gets current category
      * pre: 
      * post: returns String current category name
      */
     public String getCurrentCategory(){
      return this.currentCategory.getCategory(); 
     } //getCurrentCategory()

     /*
      * Provides an array of all the images in the current category
      * pre: 
      * post: returns String[] of all images in category
      */
     public String[] getImageLocs(){

      return this.currentCategory.getImages();
     } //getImageLocs()

     /*
      * Given the image location selected, it determines the associated text with the image.
      * pre: String imageLocation
      * post: returns String text assoc with image 
      */
     public String getText(String imageLoc) throws KeyNotFoundException{
      return imageMap.get(imageLoc).getText(imageLoc);
     } //getText

     /*
      * Determines if the image represents a category or text to speak
      * pre: String imageLocation
      * post: returns Bool for if immageLoc is key in AA
      */
     public Boolean isCategory(String imageLoc){
      return topCategory.hasImage(imageLoc);
      
     }//isCategory()

     /*
      * Resets the current category of the AAC back to the default category
      * pre: 
      * post: 
      */
     public void reset(){
      this.currentCategory = this.topCategory;
     } //reset()

     /*
      * Writes the ACC mappings stored to a file.
      * pre: String fileName
      * post: 
      */
     public void writeToFile(String fileName){
      String[] keys; //array of keys
      String [] values; //array of values
      try{

      Scanner newSc = new Scanner(newFile); //scanner to read file
      PrintWriter pen = new PrintWriter(newFile); //pen to print to file

      for(int i = 0; i < imageMap.size(); i++){
        pen.println(imageMap.getKeyAt(i) + " " + imageMap.getValueAt(i).getCategory()); //print top lvl category

        keys = imageMap.getValueAt(i).getImages(); //save images from category into key array
        values = imageMap.getValueAt(i).getTexts(); //save txt into values

        for(int j = 0; j < keys.length; j++){
          pen.println(">" + keys[j] + " " + values[j]); //print img/txt in current cattegory
        }//for

      }//for
      pen.close();
      } catch (Exception e) {}
     } //writeToFile()
}
