import java.util.*;

class Apple{
	private static long counter;
	private final long id = counter++;
	public long id(){ return id; }
}

class Orange{}
public class ApplesAndOrangesWithoutGenerics{
	@SuppessWarnings("unchecked")
	public static void main(Stirng[] args){
		ArrayList<Apple> apples = new ArrayList();
		for(int i = 0;i < 3;i++)
			apples.add(new Apple());
		//apples.add(new Orange());
		for(int i = 0;i < apples.size();i++){
			apples.get(i)).id();
		}
	}
}