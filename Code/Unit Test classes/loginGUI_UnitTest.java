import static org.junit.Assert.*;

import org.junit.Test;

/* Here, we are testing the function isValidInput that checks if the user enter
 * a valid username and password that is just with letters and numbers.
 */
public class loginGUI_UnitTest {

	@Test
	public void test()
	{
		mainWindows main_win = new mainWindows();
		loginGUI w = new loginGUI(main_win);
		char[] pass = {'!', '3', '5'};
		assertEquals(false, w.isValidInput("yoni", pass)); // user write a good username but password not valid
		char[] pass2 = {'1', '3', '5'};
		assertEquals(false, w.isValidInput("yoni![", pass2)); // user write a good password but username not valid
		char[] pass3 = {'@', 'A', '>'};
		assertEquals(false, w.isValidInput("yo#ni", pass3)); // user write an invalid username and password
		char[] pass4 = {'d', 'A', 'a'};
		assertEquals(true, w.isValidInput("YoNi", pass4)); // user write a valid username and password
		
		
	}

}
