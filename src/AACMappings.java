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
  AACCategory<String,String> topCategory = new AACCategory<String, String>();

  AACCategory<String,String> currentCategory = topCategory;

  File newFile;

 
   /*
    * CONSTRUCTOR
    */

    public AACMappings(String fileName){
      this.fileName = fileName;
      newFile = new File(fileName);
     try {
        Scanner sc = new Scanner(newFile);
        while (sc.hasNextLine()){
          String line = sc.nextLine();
          String[] lineArr = line.split(" ");

          if(!(line.startsWith(">"))){
           topCategory = new AACCategory<String, String>(lineArr[1]);
           this.add(lineArr[0], lineArr[1]);
           topCategory.addItem(lineArr[0], lineArr[1]);
           imageMap.set(topCategory.getCategory(), topCategory);
          }
          else{
            currentCategory = new AACCategory<String, String>(lineArr[1]);
            currentCategory.addItem(lineArr[0], lineArr[1]);
            imageMap.set(currentCategory.getCategory(), currentCategory);
          }
        }
        try{
          sc.close();
        } catch (Exception e) {}
      } catch (Exception e) {}
    }

    /*
     * METHODS
     */

     /*
      * Adds the mapping to the current category (or the default category if that is the current category)
      */
     public void add(String imageLoc, String text){
      this.currentCategory.addItem(imageLoc, text);
     }

     /*
      * Gets current category
      */
     public String getCurrentCategory(){
      return this.currentCategory.getCategory();
     }

     /*
      * Provides an array of all the images in the current category
      */
     public String[] getImageLocs(){

      return this.currentCategory.getImages();
     
      
     }

     /*
      * Given the image location selected, it determines the associated text with the image.
      */
     public String getText(String imageLoc) throws KeyNotFoundException{
      return imageMap.get(imageLoc).getText(imageLoc);
     }

     /*
      * Determines if the image represents a category or text to speak
      */
     public Boolean isCategory(String imageLoc){
      return topCategory.hasImage(imageLoc);
      
     }

     /*
      * Resets the current category of the AAC back to the default category
      */
     public void reset(){
      this.currentCategory = this.topCategory;
     }

     /*
      * Writes the ACC mappings stored to a file.
      */
     public void writeToFile(String fileName){
      // try{

    

      
      // Scanner newSc = new Scanner(newFile);
      // PrintWriter pen = new PrintWriter(newFile);

      // while(newSc.hasNextLine()){
      //   String[] images = topCategory.getImages(); //save all imgs in category to an array
      // String lastImage =  images[images.length-1]; //save the last image in image array (most recently added)
      // String categoryName = topCategory.getText(lastImage); //save the name of the 
      //   if()
      //   String line = newSc.nextLine();
      //   String[] lineArr = line.split(" ");
      //   if(categoryName == lineArr[1]){
      //     pen.println(lineArr[1]);
      //   }
      //   else if{
          
      //   }
      // }


      // } catch (Exception e) {}
      


     }
}