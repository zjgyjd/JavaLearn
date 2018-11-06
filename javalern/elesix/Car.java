public class Car{
	private String num;//车牌
	private String brand;//商标
	private String color;//颜色
	private String maxspeed;//最高速度
	public Car(String bra){
		this.brand = bra;
	}
	public Car(String bra,String n){
		this(bra);
		this.num = n;
	}
	public Car(String bra,String n,String col){
		this(bra,n);
		this.color = col;
	}
	public Car(String bra,String n,String col,String max){
		this(bra,n,col);
		this.maxspeed = max;
	}
	public void setSpeed(String s){
		this.maxspeed = s;
	}
	String carRunning(){
		return "车牌为: "+num+"商标为: "+brand+"正在启动"+"最高时速为: "+maxspeed;
	}
	String carStop(){
		return "车牌为: "+num+"停止前进";
	}
	public static void main(String []args){
		Car benz = new Car("benz","A-6623");
		Car toyoto = new Car("toyoto","B-2256","Red");
		benz. setSpeed( "120km/h");
		toyoto.setSpeed ("160km/h");
		System.out.println(benz.carRunning());
		System.out.println(toyoto.carRunning());
		System.out.println(benz.carStop());
		System.out.println(toyoto.carStop());
	}
}