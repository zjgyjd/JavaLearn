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
			if(chioce == 2){//开始使用
				if(this.usedSize == 0){
					System.out.println("请管理员先上架货物");
				}else{
				waiterUse();
				}
			}else if(chioce == 1){//货物上架
				int key ;
				while(true){
					System.out.println();
					System.out.println();
					System.out.println("[1]添加商品,[2]移出商品,[3]返回,[4]修改商品,[5]清空货架");
					shopList();
					if(this.usedSize == 0){
						System.out.println("目前还没有商品上架,请添加商品");
					}
					key = new Scanner(System.in).nextInt();
					if(key == 3){
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
	
	
	
	private void waiterUse(){
		Scanner sn = new Scanner(System.in);
		while(true){
			onlieList();
			System.out.println();
			System.out.println("===========================");
			System.out.println("[1]进行下单,[2]查看,[3]返回");
			System.out.println("===========================");
			int chioce = sn.nextInt();
			if(chioce == 1){
				shopDown();
			}else if(chioce == 2){
				check();
			}else if(chioce == 3){
				break;
			}else{
			System.out.println("输入有误haha");
			}
		}
	}
	
	private void check(){
		Scanner sn = new Scanner(System.in);
		System.out.println("请输入商品编号:");
		int num = sn.nextInt();
		if( num <= usedSize){
			System.out.println("=================================");
			System.out.println("商品编号: "+ num);
			System.out.println(" 商品id :"+s[num - 1].getNum());
			System.out.println("商品名称:"+s[num - 1].getShop());
			System.out.println("商品价格:"+s[num - 1].getprice());
			System.out.println("=================================");
		}else{
			System.out.println("请输入已有货物!!");
		}
	}
	
	private void shopList(){
		System.out.println("==================================================");
		System.out.println("商品id\t\t       商品\t\t      价格($)");
		for(int i = 0 ;i < this.usedSize;i++){
			System.out.println(s[i]);
		}
		System.out.println("==================================================");
	}
	
	private void shopDown(){
		Scanner sn = new Scanner(System.in);
		System.out.println("请使用商品编号进行选择:");
		int num = sn.nextInt();
		if( num <= usedSize){
			System.out.println("请输入数量:");
			int n = sn.nextInt();
			System.out.println("总价为" +n* s[num -1].getprice()+"元");
		}else{
			System.out.println("请输入已有货物!!");
		} 
	}
	
	private void empty(){
		while(usedSize != 0){
			s[--usedSize] = null;
		}
	}
	
	private void listChioce(int key){
		Scanner sn = new Scanner(System.in);
		if(key == 1){
			System.out.println("请输入商品id:");
			int id = new Scanner(System.in).nextInt();
			if(checkId(id)){
				return;
			}
			System.out.println("请输入商品姓名:");
			String shop = new Scanner(System.in).nextLine();
			System.out.println("请输入商品价格:");
			int price = new Scanner(System.in).nextInt();
			add(id,shop,price);
		}else if(key == 4){
			System.out.println("请输入商品id:");
			int id = sn.nextInt();
			for(int i = 0 ;i <usedSize;i++){
				if(id == s[i].getNum()){
					System.out.println("请输入想要修改的内容:");
					System.out.println("[1]商品编号");
					System.out.println("[2]商品名称");
					System.out.println("[3]商品价格");
					int property = sn.nextInt();
					move(property,id);
					break;
				}else{
					System.out.println("输入的编号不正确!!");
				}
			}
		}else if(key == 2){
			remove();
		}else if(key == 5){
			if(usedSize == 0){
				System.out.println("没有商品,请添加商品");
			}else{
			System.out.println("已为您清空货架");
			this.empty();
			}
		}else{
			System.out.println("输入有误");
		}
	} 
	
	private boolean checkId(int num){
			for(int i = 0;i < usedSize;i++){
				if(s[i].getNum()==num){
					System.out.println("不予许输入重复id");
					return true;
				}
			}
			return false;
		
	}
	
	private void move( int property, int id){
		Scanner sn = new Scanner(System.in);
		if(property == 1){
			System.out.println("开始修改商品编号....");
			System.out.println("请输入要修改的编号:");
			int num = sn.nextInt();
			if(checkId(num)){
				return;
			}//id 不予许重复
			chenge(id , property , num);
		}else if(property == 2){
			System.out.println("开始修改商品名称....");
			System.out.println("请输入要修改的名称:");
			String shopping = sn.nextLine();
			chenge(id , property, shopping);
		}else if(property == 3){
			System.out.println("开始修改商品价格....");
			System.out.println("请输入要修改的价格:");
			int price = sn.nextInt();
			chenge(id , property , price);
		}else{
			System.out.println("请输入正确选项");
		}
	}
	
	private void faceMune(){
		System.out.println("========================================");
		System.out.println("               1.货物上架");
		System.out.println("	       2.开始使用");
		System.out.println("	       3.退出");
		System.out.println("========================================");
	}
	
	private void onlieList(){
		System.out.println("==================================================");
		System.out.println("编号\t\t       商品\t\t      价格($)");
		for(int i = 0 ;i < this.usedSize;i++){
			System.out.println(" "+(i+1)+"\t\t\t"+s[i].getShop()+"\t\t\t"+s[i].getprice());
		}
		System.out.println("==================================================");
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
		return " "+this.n+"\t\t\t"+this.shopping+"\t\t\t"+this.price;
	} 
}