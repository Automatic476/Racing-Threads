/**
 * Stores an integer value.  Used as a shared buffer by Producer &
 * 		Consumer threads to communicate.
 * (From Campione, Lesson 15)
 * 
 * @author Jason Green
 * @version Oct 12th, 2020
 * 
 */	

public class BoundedBuffer {
	private int contents;
	private boolean empty;

	public BoundedBuffer(int n) {
		empty = true;
		int[] circularArray = new int[n];
		int count = 0;
		int capacity = 0;
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
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}

	}

	/**
	 * Retrieves a value from cubbyhole
	 *
	 * @return value retrieved
	 */
//	public synchronized int get() {
//		try {
//			if (empty) {
//				wait();
//			} else {
//				empty = true;
//				notifyAll();
//				return contents;
//			}
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//
//		}
//		return contents;
//	}

}