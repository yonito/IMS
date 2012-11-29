import java.awt.EventQueue;


public class tester
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Thread(new Runnable() {
			public void run() {
				mainWindows mainWin = new mainWindows();
		      }
		  }).start();
	}

}