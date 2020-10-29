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
		BoundedBuffer bb = new BoundedBuffer(4);
		Producer p1 = new Producer(bb, 1);
		Consumer c1 = new Consumer(bb, 1);
		c1.start();
		p1.start();
		
		
		

		p1.join();
		c1.join();
	}
}