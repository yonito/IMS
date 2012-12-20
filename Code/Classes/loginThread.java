
public class loginThread extends Thread
{
	mainWindows mainWin;
	public loginThread(mainWindows w)
	{
		mainWin = w;
	}
	public void run()
	{
		loginGUI loginWin = new loginGUI(mainWin);
	}
}
	