package threads;

public class JoinDemo {
	
	static class MyThread extends Thread {
		boolean negative = true;
		double pi; //0 by default
		@Override
		public void run() {
			for(int i=3; i < 10000; i+=2) {
				if(negative) {
					pi -= (1.0/i);
				}
				else {
					pi += (1.0/i);
				}
				negative = !negative;
			}
			pi += 1.0;
			pi *= 4.0;
			System.out.println("Finished Calculating PI");
		}
		
	}

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		try {
			mt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("PI = " + mt.pi);
	}

}
