//Figure改进
abstract class Figure{
	double dim1;
	double dim2;
	Figure(double a,double b){
		dim1 = a;
		dim2 = b;
	}
	abstract double area();
	
}
class Rectangle extends Figure{
	Rectangle(double a,double b){
		super(a,b);
	}
	double area(){
		System.out.println("Inside Area for Rectangle.");
		return dim1 * dim2;
	}
}
class Triangle extends Figure{
	Triangle(double a,double b){
		super(a,b);
	}
	double area(){
		System.out.println("Inside Area for Triangle.");
		return dim1 * dim2 / 2;
	}
}
public class Ten_31{
	public static void main(String[] args){
		Rectangle r = new Rectangle(9,5);
		Triangle t = new Triangle(10,8);
		Figure figref;//只能引用其变量,不能创建抽象类的对象
		
		figref = r;
		System.out.println("Area is " + figref.area());
		
		figref = t;
		System.out.println("Area is " + figref.area());	
	}
}

// //抽象类
// abstract class A{
	// abstract void callme();
	// void callmetoo(){
		// System.out.println("This is a concrete method.");
	// }
// }
// class B extends A{
	// void callme(){
		// System.out.println("B's implementation of callme.");
	// }
// } 
// public class Ten_31{
	// public static void main(String []args){
		// B b = new B();
		
		// b.callme();
		// b.callmetoo();
	// }
// }

// //计算对象面积
// class Figure{
	// double dim1;
	// double dim2;
	// Figure(double a,double b){
		// dim1 = a;
		// dim2 = b;
	// }
	// double area(){
		// System.out.println("Area for Figure is undefined.");
		// return 0;
	// }
// }
// class Rectangle extends Figure{
	// Rectangle(double a,double b){
		// super( a , b);//继承超类
	// }
	// double area(){
		// System.out.println("Inside Area for Rectangle.");
		// return dim1 * dim2;
	// }
// }
// class Triangle extends Figure{
	// Triangle(double a, double b){
		// super(a,b);//继承超类
	// }
	// double area(){
		// System.out.println("Inside Area for Triangle.");
		// return dim1 * dim2 / 2;
	// }
// }
// public class Ten_31{
	// public static void main(String []args){
		// Figure f = new Figure(10,10);
		// Rectangle r = new Rectangle(9,5);
		// Triangle t = new Triangle(10,8);
		// Figure figref;
		
		// figref = r;
		// System.out.println("Area is " + figref.area());
		
		// figref = t;
		// System.out.println("Area is " + figref.area());
		
		// figref = f;
		// System.out.println("Area is " + figref.area());
	// }
// }


// class A{
	// void callme(){
		// System.out.println("Inside A's callme method");
	// }
// }
// class B extends A{
	// void callme(){
		// System.out.println("Inside B's callme method");
	// }
// }
// class C extends A{
	// void callme(){
		// System.out.println("Inside C's callme method");
	// }
// }
// public class Ten_31{
	// // public static void main(string []args){
		// // a a = new a();
		// // b b = new b();
		// // c c = new c();
		// // a r;
		
		// // r = a;//用超类引用可以指向子类
		// // r.callme();
		// // r = c;//重载方法由被指向的子类决定,类似虚函数
		// // r.callme();
	// }
// }