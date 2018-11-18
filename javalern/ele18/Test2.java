class Test2{
	private int a;
	private int b;
	public void chenge1(){
		a = a + b;
		b = a - b;
		a = a - b;
	}
	public String toString{
		return "The a is "+a+" The b is "+b;
	}
	public static void main(String[] args){
		Test2 a = new Test2(10,20);
		System.out.println(a);
		a.chenge1();
		System.out.println(a);
	}
}