package threads;

public class UserDaemonThread {
	
	static class MyThread extends Thread {

		@Override
		public void run() {
			System.out.println("Daemon is " + isDaemon());
			while(true);
		}
		
	}

	public static void main(String[] args){
		MyThread mt = new MyThread();
		mt.setDaemon(true);
		mt.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
