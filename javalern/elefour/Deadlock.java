class A{
	synchronized void foo(B b){
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered A.foo");
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("A Interrupted");
		}
		System.out.println(name + "try to call B.last()");
		b.last();
	}
	synchronized void last(){
		System.out.println("Inside B.last");
	}
}
class B{
	synchronized void bar(A a){
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered B.bar");
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("B Interrupted");
		}
			System.out.println(name + "try to call A.last()");
			a.last();
	}
	synchronized void last(){
		System.out.println("Inside A.last");
	}
}
class Deadlock implements Runnable{
	A a = new A();
	B b = new B();
	Deadlock(){
		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this,"RacingThread");
		t.start();
		a.foo(b);
		System.out.println("Back in main thread");
	}
	public void run(){
		b.bar(a);
		System.out.println("Back in other thread");
	}
	public static void main(String [] args){
		new Deadlock();
	}
}