/**
 * Defines a binary semaphore with operations P (wait) and V (signal).
 * 
 * @author andrianoff
 * @version 5 April 2018
 */
public class BSemaphore
{
	private volatile int value;
	
	/**
	 * Creates a semaphore with an initial value.
	 * @param init initial value
	 */
	public BSemaphore (int init)
	{
		value = init;
	}
	
	/**
	 * Performs a wait on the semaphore.
	 * (Waits if value is 0.)
	 */
	public synchronized void P()
	{
		while(value == 0)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{}
		}
		value = 0;
	}
	
	/**
	 * Performs a signal on the semaphore.
	 * Notifies any thread waiting on semaphore.
	 */
	public synchronized void V()
	{
		value = 1;
		notifyAll();
	}

}