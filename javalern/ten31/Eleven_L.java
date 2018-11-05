package eleone;


class Balance{
	String name;
	double bal;
	Balance(String n,double b){
		name = n;
		bal = b;
	}
	void show(){
		if(bal < 0)
			System.out.println("-->");
		System.out.println(name +": $"+ bal);
	}
} 
public class Eleven_L{
	public static void main(String[] args){
		Balance current[] = new Balance[3];
			current[0] = new Balance("K.J",123.23);
			current[1] = new Balance("W.T",157.02);
			current[2] = new Balance("T.J",-12.33);
			for(int i=0;i < 3;i++){
			current[i].show();
			}
	}
}

// public class Eleven_1{
	// public static void main(String []args){
		// System.out.println("3"+2);//b
		// //显示为32,若为3+2则显示5
	// }
// }	