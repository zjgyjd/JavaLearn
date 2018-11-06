import static javalern.elesix.Print.*;
public class Person{
	String name;
	int age;
	Person(){
		
	}
	private String secret;
	//getxxx()
	String getSec(){
		return secret; 
	}
	void setSec(String sec){
		secret = sec;
	}
	String personInfo(){
		return "The man:"+name+",Age:"+age;
	}
	public static void main(String [] args){
		Person person = new Person();
		person.name="Jack";
		person.age=21;
		print(person.personInfo());
		}
} 