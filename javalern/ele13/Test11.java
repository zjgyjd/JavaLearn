import static javalern.elesix.Print.*;
public class Test11{
	public static void main(String[] args){
		new Person().prints();
		new Student().hello();
		Person person = new Student();
		//person.hello();
		//person.getName();//erorr
		print(new Student().getName());
		print(new Student().getEName());
	}
}
class Person{
	public String name = "Jack";
	public void prints(){
		print("this is Person");
	}
	public void hello(){
		print("this is hello");
	}
}
class Student extends Person{
	private String name = "Tom";
	public void prints(){
		print("this is Student");
	}
	public void hello(){
		print("this is hello for Student");
	}
	public String getName(){
		return name;
	}
	public String getEName(){
		return super.name;
	}
}
