/**
 * Reader thread attempts to read from a shared file
 * 
 * @author andrianoff
 * @version 5 April 2018
 */

public class Reader extends Thread 
{
	private int start;
	private int duration;
	
	/**
	 * Creates a Reader thread
	 * @param ident id number of Reader
	 * @param st time first requesting access
	 * @param dur duration of reading
	 */
	public Reader(int ident, int st, int dur) 
	{
		super("Reader" + ident);
		start = st;
		duration = dur;
	}

	/**
	 * Defines the behavior of a Reader
	 *    - waits until start
	 *    - reads for duration
	 */
	public void run() 
	{
		try
		{
			sleep(start);
		} catch (Exception e) {}
		System.out.println(getName() + " wants to read for " + 
									duration + " units");
		System.out.println(getName() + " is starting to read for " + 
									duration + " units");
		try
		{
			sleep(duration);
		} catch (Exception e) {}
		System.out.println(getName() + " is finished reading");
	}
}


		