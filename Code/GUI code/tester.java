import java.awt.EventQueue;


public class tester
{

	/**
	 * @param args
	 */
	static loginThread login_thread;
	public static void main(String[] args)
	{
		login_thread = new loginThread();
		login_thread.run();
		mainWindows mainWin = new mainWindows();
		
		
	}

}