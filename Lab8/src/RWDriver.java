/**
 * Driver for the solution to Readers & Writers problem
 * 
 * @author andrianoff
 * @version 5 April 2018
 */

public class RWDriver 
{

	public static void main(String[] args) throws InterruptedException 
	{
		Reader r1 = new Reader(1, 100, 50);
		Reader r2 = new Reader(2, 50, 70);
		Writer w1 = new Writer(1, 70, 80);

		r1.start();
		r2.start();
		w1.start();
		
		r1.join();
		r2.join();
		w1.join();
	}
}



		