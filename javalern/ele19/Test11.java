import java.util.*;
public class Test11{
	public static void main(String[] args){
		CashierDesk c = new CashierDesk();
         c.start();
	}
} 
class CashierDesk{
	private Shop[] s;
	private int usedSize;
	
	public  CashierDesk(){
		this(10);
	}
	public CashierDesk(int size){
		this.s = new Shop[size];
        this.usedSize = 0;		
	}
	
	public void start(){
		useItForService();//服务操作
	}
	
	public void useItForService(){
		Scanner sn = new Scanner(System.in);
		while(true){
			faceMune();
			int chioce = sn.nextInt();
			if(chioce == 1){//开始使用
				if(this.usedSize == 0){
					System.out.println("没有货物上架");
				}else{
				shopList();
				}
			}else if(chioce == 2){//货物上架
				int key ;
				while(true){
					System.out.println();
					System.out.println();
					System.out.println("[1]添加商品,[2]移出商品,[3]返回,[4]修改商品");
					shopList();
					key = new Scanner(System.in).nextInt();
					if(key == 3){
						this.empty();
						break;
					}
					listChioce(key);
				}
			}else if(chioce == 3){
				System.out.println("谢谢使用!!");
				break;
			}else{
				System.out.println("请重新输入!!");
			}
			
		}
	}
	
	private void empty(){
		while(usedSize != 0){
			s[--usedSize] = null;
		}
	}
	
	private void listChioce(int key){
		if(key == 1){
			System.out.println("请输入商品id:");
			int id = new Scanner(System.in).nextInt();
			System.out.println("请输入商品姓名:");
			String shop = new Scanner(System.in).nextLine();
			System.out.println("请输入商品价格:");
			int price = new Scanner(System.in).nextInt();
			add(id,shop,price);
		}else if(key == 4){
			int id = new Scanner(System.in).nextInt();
			int property = 2;
			String  d ="chenge"; 
			chenge(id,property,d);
		}else if(key == 2){
			remove();
		}else if(key == 5){
			if(usedSize == 0){
				System.out.println("没有商品需要结算!!");
			}else{
				int sum = 0; 
				for(int i = 0;i < usedSize;i++){
					sum += s[i].getprice();
				}
			System.out.println("开始结算.....");
			System.out.println("总共为 "+ sum +"元");
			this.empty();
			}
		}else{
			System.out.println("输入有误");
		}
	} 
	
	private void faceMune(){
		System.out.println("========================================");
		System.out.println("               1.开始使用");
		System.out.println("	       2.设置");
		System.out.println("	       3.退出");
		System.out.println("========================================");
	}
	
	private void shopList(){
		System.out.println("========================================");
		System.out.println("编号             商品            价格($)");
		for(int i = 0 ;i < this.usedSize;i++){
			System.out.println(s[i]);
		}
		System.out.println("========================================");
	}
	
	private void add(Integer n,String shop,Integer p){//增
		if(n != null&& shop != null && p != null){
			if(this.usedSize == this.s.length){
				this.s = Arrays.copyOf(this.s,this.s.length*2);
			}
			this.s[usedSize] = new Shop(n,shop,p);
			this.usedSize++;
		}else{
			System.out.println("输入有误");
		}
	} 
	
	private void remove(){//删
		if(this.usedSize==0){
			System.out.println();
			System.out.println("已经没有商品了");
			System.out.println();
			return;
		}
		this.s[this.usedSize-1] = null;
		this.usedSize--;
	}
	
	private void chenge(Integer id,Integer property,Object si){//改
		if(id != null&& property != null && si != null){
			for(int i = 0;i < this.usedSize;i++){
				if(id == s[i].getNum()){
					if(property == 1){
						s[i].setNum((int)si);
					}else if(property == 2){
						s[i].setShop((String)si);
					}else if(property == 3){
						s[i].setprice((int)si);
					}else{
						System.out.println("输入有误");
					}
					break;
				}
			}
		}else{
			System.out.println("输入有误");
		}
	}
	
	private Shop chick(Integer id){//查
		if(id == null){
			System.out.println("输入有误");
			return null;
		}
		for(int i = 0; i < usedSize; i++){
			if(s[i].getNum() == id){
				return s[i];
			}
		}
		return null;
	}
	
}

class Waiter{
	private Shop[] s;
	private int canUse;
	public Waiter(){
		
	}
	public Waiter(Shop[] s, int c){
		this.s = s;
		this.canUse = c;
	}
	private void shopList(){
		System.out.println("========================================");
		System.out.println("编号             商品            价格($)");
		for(int i = 0 ;i < this.canUse;i++){
			System.out.println(s[i]);
		}
		System.out.println("========================================");
	}
}

class Shop{
	private int n ;
	private String shopping ;
	private int price ;
	
	public Shop(){
		
	}
	
	public Shop(int n,String shop,int p){
		this.n = n;
		this.shopping = shop;
		this.price = p;
	}
	
	public int getNum(){
		return this.n;
	}
	public String getShop(){
		return this.shopping;
	}
	public int getprice(){
		return this.price;
	}
	
	public void setNum( int n){
		this.n = n;
	}
	public void setShop(String s){
		this.shopping = s;
	}
	public void setprice(int p){
		this.price = p;
	}
	public String toString(){
		return "  "+this.n+"              "+this.shopping+"             "+this.price;
	}
}