public class HelloWord{
	public static void main(String [] args){
System.out.println("Hello World");
System.out.println("Hello 比特!!");
System.out.println("jkj");//第三方第三方
// int[] i = new int[]{1,2,3,4,5};
// for(int j = 0;j < 5;j++){
	// System.out.println(" "+i[j]);
//int num = 10;
//int num = Integer.MAX_VALUE;
//System.out.println(num + 1);//此时加号还是赋值的意思 给最大加会溢出
System.out.println(1l+1l);//注意这里是1L + 1L结果为2
Long num = Integer.MAX_VALUE + 1L;//注意强制转换如果不写会报错
System.out.println(num );
}
}