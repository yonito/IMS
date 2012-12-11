
public class loginThread implements Runnable
{

	loginGUI loginWindow;
	@Override
	public void run()
	{
		loginWindow = new loginGUI();
		loginWindow.setVisible(true);
		loginWindow.setAlwaysOnTop(true);
		cancelThread();		
	}
	
	
	private void cancelThread()
	{
		while(loginWindow.endThread == false){}
		Thread.interrupted();
	}

}
