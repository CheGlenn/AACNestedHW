import structures.AssociativeArray;
import structures.KVPair;
import structures.KeyNotFoundException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class AACMappings {
  /*
   * FIELDS
   */

  String fileName; //name of file 

  AssociativeArray<String, AACCategory<String,String>> imageMap = new AssociativeArray<>();

  AACCategory<String,String> currentCategory = new AACCategory<>();

  AACCategory<String,String> topCategory = new AACCategory<>();
   /*
    * CONSTRUCTOR
    */

    public AACMappings(String fileName){
      this.fileName = fileName;

      try {
        Scanner sc = new Scanner(fileName);

        while (sc.hasNext()){
          String line = sc.nextLine();
          String[] lineArr = line.split(" ");

          if(line.charAt(0) != '>'){
           topCategory.addItem(lineArr[0].toString(), lineArr[1].toString());
          }
          else{
            currentCategory.addItem(lineArr[0].toString(), lineArr[1].toString());
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
      return this.currentCategory.name;
     }

     /*
      * Provides an array of all the images in the current category
      */
     public String[] getImageLocs() throws KeyNotFoundException{
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
     public Boolean isCategory(String imageLoc) throws KeyNotFoundException{
      return imageMap.hasKey(imageLoc);
     }

     /*
      * Resets the current category of the AAC back to the default category
      */
     public void reset(){
      this.currentCategory = this.topCategory;
     }

     public void writeToFile(String fileName){
      //STUB
     }

}
