package Tutor3;
import utils.*;

/*
 * 
 */
public class Counter {
	// attributes
	protected int value;
	
	/*
	 * 
	 */
	public Counter() {
		this.value = 1;
	}
	
	/*
	 * 
	 */
	public int get() {
		return this.value;
	}
	
	public void incr() {
		this.value++;
	}
}
