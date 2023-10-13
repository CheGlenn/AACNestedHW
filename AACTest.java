import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/*
 * @author Che Glenn
 * Date: Oct 13
 * 
 * AACTest tests the functions of AACCategory
 */

public class AACTest {
  
  @Test
  public void addItemTest() throws Exception{ //tests add item and getText
    AACCategory<String,String> testArr = new AACCategory<>("Category");

    testArr.addItem("Test Img", "Test Text");
    assertEquals("Test Text", testArr.getText("Test Img") );
  }

  @Test
  public void getCategoryTest() throws Exception{ //tests returnCatergory
    AACCategory<String,String> testArr = new AACCategory<>("Category");

    assertEquals("Category", testArr.getCategory());
  }

  @Test
  public void getImagesTest() throws Exception{
    AACCategory<String,String> testArr = new AACCategory<>("Category");
    String [] tester = {"1", "2", "3"};


    testArr.addItem("1", "Test Text");
    testArr.addItem("2", "Test Text");
    testArr.addItem("3", "Test Text");
  

    // assertEquals(tester, testArr.getImages());
  
    
  }




}
