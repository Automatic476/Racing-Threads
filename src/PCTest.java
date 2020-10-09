/**
 * Program illustrates Producer/Consumer interaction using a CubbyHole
 * 		as a buffer.
 * Creates a CubbyHole and then creates a Producer thread and a Consumer
 * 		thread.
 * (From Campione, Lesson 15)
 * 
 * @author andrianoff
 * @version 8 March 2018
 */
public class PCTest 
{
	public static void main(String[] args) throws InterruptedException
	{
		CubbyHole c = new CubbyHole();
		Producer p1 = new Producer(c, 1);
		Consumer c1 = new Consumer(c, 1);

		p1.start();
		c1.start();

		p1.join();
		c1.join();
	}
}