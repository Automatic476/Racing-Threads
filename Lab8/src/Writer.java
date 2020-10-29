/**
 * Writer thread attempts to write to a shared file
 * 
 * @author andrianoff
 * @version 5 April 2018
 */

public class Writer extends Thread 
{
	private int start;
	private int duration;

	/**
	 * Creates a Writer thread
	 * @param ident id number of Writer
	 * @param st time first requesting access
	 * @param dur duration of writing
	 */
	public Writer(int ident, int st, int dur) 
	{		
		super("Writer" + ident);
		start = st;
		duration = dur;
	}

	/**
	 * Defines the behavior of a Writer
	 *    - waits until start
	 *    - writes for duration
	 */
	public void run() 
	{
		try
		{
			sleep(start);
		} catch (Exception e) {}
		System.out.println("\t" + getName() + " wants to write for " + 
									duration + " units");
		System.out.println("\t" + getName() + " is starting to write for " + 
									duration + " units");
		try
		{
			sleep(duration);
		} catch (Exception e) {}
		System.out.println("\t" + getName() + " is finished writing");
	}
}


		