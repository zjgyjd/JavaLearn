class NewThread implements Runnable{
	String name;//name of thread
	Thread t;
	NewThread(String threadname){
		name = threadname;
		t = new Thread(this,name);
		System.out.println("New thread: "+t);
		t.start();
	}
	public void run(){
		try{
			for(int i = 5;i >0;i--){
				System.out.println(name + ": "+ i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println(name + "Interrupted");
		}
		System.out.println("Exiting"+name);
	}
} 
class MultiThreadDemo{
	public static void main(String [] args){
		new NewThread("One");
		new NewThread("Tow");
		new NewThread("Three");
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			System.out.println("Main thread Interrupted");
		}
		System.out.println("Exting Main Thread");
	}
}