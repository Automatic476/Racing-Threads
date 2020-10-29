/**
 * Defines the Producer (Thread) class
 *    Produces an integer and deposits in cubbyhole
 * (From Campione, Lesson 15)
 * 
 * @author andrianoff
 * @version 8 March 2018
 */	

public class Producer extends Thread 
{
	private BoundedBuffer box;
	private int id;

	/**
	 * Creates a Producer thread 
	 * @param c the shared box (CubbyHole) where data is deposited
	 * @param n id of Producer
	 */
	public Producer(BoundedBuffer b, int n) 
	{
		super("Producer(" + n + ")");
		box = b;
		id = n;
	}

	/**
	 * Deposits 10 values into box and displays values deposited.
	 */
	public void run() 
	{
		for (int i = 0; i < 10; i++) 
		{
			box.put(i);
			System.out.println("Producer #" + id 
											+ " put: " + i);
		}
	}
}