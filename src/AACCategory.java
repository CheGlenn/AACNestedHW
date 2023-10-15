import structures.AssociativeArray;
import structures.KeyNotFoundException;
import java.util.List;

/*
 * @author Che Glenn
 * Date: October 13
 * 
 * AACCategory represent a single category of items in the AAC. It stores the mapping between the image location and the text that should be spoken and the name of the category. 
 * 
 */

public class AACCategory<K,V>{

  /*
   * FIELDS
   */

  AssociativeArray<String,String> categories = new AssociativeArray<>(); //array for categories

  String name; //name of current category




  /*
   * CONSTRUCTOR 
   */

   public AACCategory(String name){
    this.name = name;
   }

   public AACCategory(){
   }
   


  /*
   * Adds the mapping of the imageLoc to the text to the category
   * pre: String imageLocation, String text
   * post:
   */
  public void addItem(String imageLoc, String text){
    this.categories.set(imageLoc, text);
  } //addItem()

  /*
   * Returns the name of the category
   * pre: 
   * post: returns String category name
   */
  public String getCategory(){
    return this.name;
  } //getCategory()

  /*
   * Returns an array of all the images in the category
   * pre: 
   * post: returns String[] of allImages
   */
  public String[] getImages(){
 
    List<String> imgs = this.categories.returnKeys(); //list to store keys 
    String[] allImages = imgs.toArray(new String[imgs.size()]);         //save list to String array
 
    return allImages; // return string array
    
  } //getImages()

  /*
   * Returns an array of all images in the category
   * pre: 
   * post: returns String[] of allTexts
   */

   public String[] getTexts(){
    List<String> txts = this.categories.returnValues(); //list to store values 
    String[] allTexts = txts.toArray(new String[txts.size()]); //save list to String array

    return allTexts; //return string array
   } //getTexts()

  /*
   * Returns the text associated with the given image loc in this category
   * pre: String imageLocation
   * post: returns String value of assoc key
   */
  public String getText(String imageLoc) throws KeyNotFoundException{
    return this.categories.get(imageLoc); //returns value of assoc key
  } //getText()

  /*
   * Determines if the provided images is stored in the category
   * pre: String imageLocation
   * post: returns Bool ife key imageLoc is found in AA
   */
  public Boolean hasImage(String imageLoc){
    return this.categories.hasKey(imageLoc);
  }//hasImage()
  
}
