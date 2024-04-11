package Tutor3;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		Counter3 counter = new Counter3(5);
		while(true) {
			counter.incr(5);
			System.out.println(counter.get());
			
			Thread.sleep(1000);
				
		}
	}
}
