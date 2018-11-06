import static javalern.elesix.Print.*;
public class App{
public static void main(String [] args){
		Person person = new Person();
		person.name="Jack";
		person.age=21;
		//person.secret;无法访问私有类
		person.setSec("haha");//使用方法获取
		print(person.getSec());
		
		}
}	
