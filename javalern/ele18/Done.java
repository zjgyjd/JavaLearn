public class Done{
	public static void main(String[] args){
		GiveFollwer xiaoli = new Cosumer("小李","李四");
		xiaoli.giveFollwer();
		GiveFollwer numOne = new ProxyGive();
		numOne.giveFollwer();
	}
}
interface GiveFollwer{
	void giveFollwer();
}
class Cosumer implements GiveFollwer{
	private String name1;
	private String name2;
	Cosumer(String name1,String name2){
		this.name1 = name1;
		this.name2 = name2;
	}
	public void giveFollwer(){
		System.out.println(name1+"送花给"+name2);
	}
}
class ProxyGive implements GiveFollwer{
	private final Cosumer target;
	public ProxyGive(Cosumer target){
		this.target = target;
	}
	private String name3 = "快递员";
	public void call(){
		System.out.println(name3+"打电话");
	}
	public void giveFollwer(){
		this.call();
		System.out.println("送花");
		this.leave();
	}
	public void leave(){
		System.out.println(name3+"离开目的地");
	}
}