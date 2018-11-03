class Callme{
	//synchronized void call(String msg){//控制一个线程进入时其他挂起(写法一)
	void call(String msg){
		System.out.print("["+msg);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}
class Caller implements Runnable{
	String msg;
	Callme target;
	Thread t;
	public Caller(Callme targ,String s){
		target = targ;
		msg = s;
		t = new Thread(this);
		t.start();
	}
	public void run(){
		synchronized(target){//方法二
		target.call(msg);
		}
	}
}
class Synch{
	public static void main(String [] args){
		Callme target = new Callme();
		Caller ob1 = new Caller(target,"Hello");
		//System.out.println("Creat ob1");
		Caller ob2 = new Caller(target,"World");
		//System.out.println("Creat ob2");
		Caller ob3 = new Caller(target,"Synchronized");
		//System.out.println("Creat ob3");
		Caller ob4 = new Caller(target,"Synchronized tow");
		//System.out.println("Creat ob4");
		try{
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
			ob4.t.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
	}
}