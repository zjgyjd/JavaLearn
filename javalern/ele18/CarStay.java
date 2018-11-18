public class CarStay{
	private static final int standarLength = 1;
	private static final int standarWidth = 2;
	public static void carStay(Car c){
		c.prtLong();
		c.prtBrath();
		System.out.println("The car is stay there");
	}
	public static void main(String[] args){
		Car c = new MotorCar(10,5);
		carStay(c);
		carStay(new BusCar(20,10));
	}
}
interface Car{
	
	void prtLong();
	void prtBrath();
}
class MotorCar implements Car{
	private int l;
	private int b;
	
	MotorCar(int l,int b){
		this.l = l;
		this.b = b;
	}
	public void prtLong(){
		System.out.println("The Long of MotorCar " + this.l);
	}
	public void prtBrath(){
		System.out.println("The Long of MotorCar " + this.b);
	}
}
class BusCar implements Car{
	private int l;
	private int b;
	
	BusCar(int l,int b){
		this.l = l;
		this.b = b;
	}
	public void prtLong(){
		System.out.println("The Long of BusCar " + this.l);
	}
	public void prtBrath(){
		System.out.println("The Long of BusCar " + this.b);
	}
}