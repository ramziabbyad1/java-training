package threads;

public class ThreadDemo {
	
	static class MyThread extends Thread{
		MyThread(){}
		MyThread(String name) {
			this.setName(name);
		}
		@Override
		public void run() {
			for(int count=1, row=1; row < 20; row++,count++) {
				for(int i = 0; i < count; i++) {
					System.out.print('*');
				}
				System.out.print('\n');
			}
		}
	}
	
/*	static class MyThread2 extends Thread {

		@Override
		public void run() {
			
		}
		
	}*/

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		while(mt.isAlive()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i = 0; i < 50; i++) {
			System.out.println("i = "+i + " i*i = "+ i*i);
		}
	}

}
