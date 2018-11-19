import java.util.*;
public class Customer{
	public static void main(String[] args){
		OnlieShopping taoCustomer = new TaoBao();
		OnlieShopping tianCustomer = new TianMao();
		taoCustomer.onlieTemplate();
		System.out.println("==================");
		tianCustomer.onlieTemplate();
	}
}
abstract class OnlieShopping{
	public final void onlieTemplate(){
		scanApp();
		chengeOne();
		if(answer()){
		customerService();
		}
		senderService();
		account();
		chickOrder();
	}
	abstract void scanApp();
	private void chengeOne(){
		System.out.println("选择一件商品;");
	}
	abstract void customerService();
	abstract void senderService();
	private void account(){
		System.out.println("正在为您结算.....");
	}
	private void chickOrder(){
		System.out.println("正在查看您的订单;");
	}
	private boolean answer(){
		System.out.println("是否启用客服?Y/N");
		String answer = "Y";
		Scanner s = new Scanner(System.in);
		answer = s.nextLine();
		return answer.equals("Y");
	}
}
class TianMao extends OnlieShopping{
	public void scanApp(){
		System.out.println("正在使用天猫浏览商品");
	}
	public void customerService(){
		System.out.println("天猫客服团队为您服务");
	}
	public void senderService(){
		System.out.println("天猫物流为您服务!");
	}
}
class TaoBao extends OnlieShopping{
	public void scanApp(){
		System.out.println("正在使用淘宝浏览商品");
	}
	public void customerService(){
		System.out.println("淘宝客服团队为您服务");
	}
	public void senderService(){
		System.out.println("淘宝物流为您服务!");
	}
}