package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {

	int threadNumber;
	ThreadedGreeter(int threadNumber){
		this.threadNumber = threadNumber;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from the thread number: " + threadNumber);
		if(threadNumber<=50) {
			Thread nextThread = new Thread(new ThreadedGreeter(threadNumber+1));
			nextThread.start();
			try {
				nextThread.join();
			}
			catch(Exception e) {
				
			}
		}
		
	}

}
