class cliker implements Runnable{
	int click = 0;
	Thread t;
	private volatile boolean running = true;
	public cliker(int p ){
		t = new Thread(this);
		t.setPriority(p);
	}
	public void run(){
		while(running){
			click++;
		}
	}
	public void stop(){
		running = false;
	}
	public void start(){
		t.start();
	}
}
class HiLoPri{
	public static void main(String [] args){
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		cliker hi = new cliker(Thread.NORM_PRIORITY +2);
		cliker lo = new cliker(Thread.NORM_PRIORITY -2);
		lo.start();
		hi.start();
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("Main thread interrupted!");
		}
		lo.stop();
		hi.stop();
		try{
			hi.t.join();
			lo.t.join();
		}catch(InterruptedException e){
			System.out.println("InterruptedException caught");
		}
		System.out.println("Low-priority thread: "+lo.click);
		System.out.println("High-priority thread: "+hi.click);
	}
}