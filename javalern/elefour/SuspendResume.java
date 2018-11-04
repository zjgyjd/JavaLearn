class NewThreadss implements Runnable{
	String name;
	Thread t;
	boolean suspendFlag; 
	NewThreadss(String threadname){
		name = threadname;
		t = new Thread(this,name);
		System.out.println("New Thread: "+t);
		suspendFlag = false;
		t.start();
	}

public void run(){
	try{
		for(int i = 15;i > 0;i++){
			System.out.println(name + ": "+i);
			Thread.sleep(200);
			synchronized(this){
				while(suspendFlag){
					wait();
				}
			}
		}
	}catch(InterruptedException e){
		System.out.println(name+" interrupted");
	}
	System.out.println(name + " exciting.");
   }
   void mysuspend(){
	   suspendFlag = true;
   }
   synchronized void myresume(){
	   suspendFlag = false;
	   notify();
   }
}
class SuspendResume{
	public static void main(String [] args){
		NewThreadss ob1 = new NewThreadss("One");
		NewThreadss ob2 = new NewThreadss("Two");
		try{
			Thread.sleep(1000);
			ob1.mysuspend();
			System.out.println("Suspending thread one");
			Thread.sleep(1000);
			ob1.myresume();
			System.out.println("Resumint thread One");
			ob2.mysuspend();
			System.out.println("Suspending thread two");
			Thread.sleep(1000);
			ob2.myresume();
			System.out.println("Resumint thread two");
		}catch(InterruptedException e){
			System.out.println("Main thread interrupted");	
		}
		try{
			System.out.println("wait for thread Interrupted");
			ob1.t.join();
			ob2.t.join();
		}catch(InterruptedException e){
			System.out.println("Main thread interrupted");
		}
		System.out.println("Exiting Main thread");
			
	}
}