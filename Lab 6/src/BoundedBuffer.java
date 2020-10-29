import java.nio.BufferOverflowException;

/**
 * Stores an integer value.  Used as a shared buffer by Producer &
 * 		Consumer threads to communicate.
 * (From Campione, Lesson 15)
 * 
 * @author Jason Green & Maggie Sweeney
 * @version Oct 26th, 2020
 * 
 */	

public class BoundedBuffer {

	private boolean empty;
	private boolean full; // for step 2
	private int capacity; // max buffer size
	private int count; // number of items in buffer
	private int inIndex; // buffer pointer
	private int outIndex; // buffer pointer
	private int[] circularArray;

	public BoundedBuffer(int n) {
		empty = true;
		full = false; // for step 2
		capacity = n; 
		circularArray = new int[capacity]; //set array to hold capacity
	//	count = 0;
		inIndex = 0;
		outIndex = 0;
	}

	/**
	 * Places value into BoundedBuffer
	 *
	 * @param value to be deposited
	 */
	public synchronized void put(int value) {
			
			
			while (full) { // buffer is full
			
				try {
					wait();
				}
				catch (InterruptedException e) {
					System.out.println("Error");
				}
			}
			circularArray[inIndex] = value; // store value
			inIndex = ((inIndex++) % capacity); // implement circular array
			count++; // update count
			empty = false; // update to false
			if(count == capacity) {
				full = true; // update false
			}
			notifyAll();
			}


	

	/**
	 * Retrieves a value from cubbyhole
	 *
	 * @return value retrieved
	 */
	public synchronized int get() {

		while(empty) { 

	try {
		wait();
	} catch (InterruptedException e) {
		System.err.println("Something all messed up in the get()");
	}
}
			
			int tmp = outIndex; // need to store temporary value
			outIndex = ((outIndex++) % capacity); // implement circular array
			count--; // update count
			if(count == 0) {
				empty = true;
			}
			notifyAll();
			return circularArray[tmp];
	}
}