import structures.AssociativeArray;
import structures.KVPair;
import structures.KeyNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AACCategory<K,V> extends AssociativeArray{

  AssociativeArray<String,String> categories = new AssociativeArray<>(); //array for categories

  int count = categories.size(); //num of categories

  String name; //name of current category

  KVPair<K,V> pairs[]; //pairs of keys (categories) and values (img assoc)


  /*
   * Adds the mapping of the imageLoc to the text to the category
   */
  public void addItem(String imageLoc, String text){
    this.categories.set(imageLoc, text);
    count = this.categories.size();
  }

  /*
   * Returns the name of the category
   */
  public String getCategory(String category) throws KeyNotFoundException{
    this.name = this.categories.get(category);
    return this.name;
  }

  /*
   * Returns an array of all the images in the category
   */
  public String[] getImages(String category) throws KeyNotFoundException{
    List<String> imgs = this.categories.returnKeys(); //list to store keys 

    String[] allImages = imgs.toArray(new String[imgs.size()]); //save list to String array
    return allImages; // return string array
    
  } 
  
}