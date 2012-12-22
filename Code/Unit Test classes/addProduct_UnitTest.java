import static org.junit.Assert.*;

import org.junit.Test;

/*the test check the functions that check the inputs of the user in the add product window*/
public class addProduct_UnitTest {

	@Test
	public void test()
	{
		addProductGUI w = new addProductGUI();
		
		/* We are use the isNumber function in order to check if the user enter
		 * a valid price, valid ID product, and valid quantity that is an number.*/
		assertEquals(false, w.isNumber("AAA")); // if the user write an price not valid
		assertEquals(true, w.isNumber("123")); // if the user write a valid price;
		
		assertEquals(false, w.isValidInputName("bamba#$")); // check with the name of the product is valid
		assertEquals(true, w.isValidInputName("bamba"));
		
		
	}

}
