/**
 * Stores an integer value.  Used as a shared buffer by Producer &
 * 		Consumer threads to communicate.
 * (From Campione, Lesson 15)
 * 
 * @author Jason Green
 * @version Oct 12th, 2020
 * 
 */	

public class CubbyHole {
	private int contents;
	private boolean empty;

	public CubbyHole() {
		empty = true;
	}

	/**
	 * Places value into cubbyhole
	 *
	 * @param value to be deposited
	 */
	public synchronized void put(int value) {
		try {
			if (!empty) {
				wait();
			} else {
				contents = value;
				empty = false;
				notifyAll();
			}
			//Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

	}

	/**
	 * Retrieves a value from cubbyhole
	 *
	 * @return value retrieved
	 */
	public synchronized int get() {
		try {
			if (empty) {
				wait();
			} else {
				empty = true;
				notifyAll();
				return contents;
			}
			//Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		return contents;
	}

}
