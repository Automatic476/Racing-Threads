/**
 * Stores an integer value.  Used as a shared buffer by Producer &
 * 		Consumer threads to communicate.
 * (From Campione, Lesson 15)
 * 
 * @author andrianoff
 * @version 8 March 2018
 */	

public class CubbyHole 
{
	private int contents;

	/**
	 * Places value into cubbyhole
	 * @param value to be deposited
	 */
	public void put(int value) 
	{
		contents = value;
	}

	/**
	 * Retrieves a value from cubbyhole
	 * @return value retrieved
	 */
	public int get()
	{
		return contents;
	}
}
