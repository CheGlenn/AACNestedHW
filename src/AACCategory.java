import structures.AssociativeArray;
import structures.KeyNotFoundException;
import java.util.List;

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
   */
  public void addItem(String imageLoc, String text){
    this.categories.set(imageLoc, text);
  }

  /*
   * Returns the name of the category
   */
  public String getCategory(){
    return this.name;
  }

  /*
   * Returns an array of all the images in the category
   */
  public String[] getImages() throws KeyNotFoundException{
 

    
    List<String> imgs = this.categories.returnKeys(); //list to store keys 
    String[] allImages = imgs.toArray(new String[imgs.size()]);         //save list to String array
 
    return allImages; // return string array
    
  } 

  /*
   * Returns the text associated with the given image loc in this category
   */
  public String getText(String imageLoc) throws KeyNotFoundException{
    return this.categories.get(imageLoc);
  }

  /*
   * Determines if the provided images is stored in the category
   */
  public Boolean hasImage(String imageLoc) throws KeyNotFoundException{
    return this.categories.hasKey(imageLoc);
  }
  
}