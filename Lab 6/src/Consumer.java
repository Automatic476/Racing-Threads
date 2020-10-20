/**
 * Defines the Consumer class
 *    Consumes an integer by fetching value from cubbyhole
 * (From Campione, Lesson 15)
 * 
 * @author andrianoff
 * @version 8 March 2018
 */	

public class Consumer extends Thread 
{
	private CubbyHole box;
	private int id;

	/**
	 * Creates a Consumer thread
	 * @param c the shared box (CubbyHole) from which data is fetched
	 * @param n id of Consumer
	 */
	public Consumer(CubbyHole c, int n) 
	{
		super("Consumer(" + n + ")");
		box = c;
		id = n;
	}

	/**
	 * Fetches 10 values from box and displays them.
	 */
	public void run() 
	{
		int value; 
		for (int i = 0; i < 10; i++) 
		{
			value = box.get();
			System.out.println("\tConsumer #" + id 
											+ " got: " + value);
		}
	}
}