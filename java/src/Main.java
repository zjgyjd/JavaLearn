import java.sql.SQLOutput;

class Box {
    private double width;
    private double height;
    private double depth;

    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    Box(double len) {
        width = height = depth = len;
    }

    double volume() {
        return width * height * depth;
    }
}

class BoxWeight extends Box {
    double weight;

    BoxWeight(BoxWeight ob) {
        super(ob);
        weight = ob.weight;
    }

    BoxWeight(double w, double h, double d, double m) {
        super(w, h, d);
        weight = m;
    }

    BoxWeight() {
        super();
        weight = -1;
    }

    BoxWeight(double len, double m) {
        super(len);
        weight = m;
    }
}

class Shipment extends BoxWeight {//小票
    double cost;

    Shipment(Shipment ob) {
        super(ob);
        cost = ob.cost;
    }

    Shipment(double w, double h, double d, double m, double c) {
        super(w, h, d,m);
        cost = c;
    }

    Shipment() {
        super();
        cost = -1;
    }

    Shipment(double len, double m, double c) {
        super(len, m);
        cost = c;
    }
}
class DemoShipment{
    public static void main(String[] args) {
        Shipment shipment1=new Shipment(10,20,15,10,3.14);
        Shipment shipment2=new Shipment(2,3,4,0.76,1.28);
        double vol;
        vol=shipment1.volume();
        System.out.println("Volume of shipment1 is "+vol);
        System.out.println("Weight of shipment is "+ shipment1.weight);
        System.out.println("Shipping cost: $"+shipment1.cost);
        System.out.println();
        vol=shipment2.volume();
        System.out.println("Volume of shipment2 is "+vol);
        System.out.println("Weight of shipment2 is "+ shipment2.weight);
        System.out.println("Shipping cost: $"+shipment2.cost);
    }
}

//class Box {
//    double width;
//    double height;
//    double depth;
//
//    Box(Box ob) {
//        width = ob.width;
//        height = ob.height;
//        depth = ob.depth;
//    }
//
//    Box(double w, double h, double d) {
//        width = w;
//        height = h;
//        depth = d;
//    }
//
//    Box() {
//        width = -1;
//        height = -1;
//        depth = -1;
//    }
//
//    Box(double len) {
//        width = depth = height = len;
//    }
//
//    double volume() {
//        return width * depth * height;
//    }
//}
//
//class BoxWeight extends Box {
//    double weight;
//
//    BoxWeight(double w, double h, double d, double m) {
//        width = w;
//        height = h;
//        depth = d;
//        weight = m;
//    }
//}
//class DemoBoxWeight{
//    public static void main(String[] args) {
//        BoxWeight mybox1=new BoxWeight(10,20,15,34.3);
//        BoxWeight mybox2=new BoxWeight(2,3,4,0.076);
//        double vol;
//        vol=mybox1.volume();
//        System.out.println("Volume of mybox1 is "+vol);
//        System.out.println("Weight of mybox1 is "+mybox1.weight);
//        System.out.println();
//        vol=mybox2.volume();
//        System.out.println("Volume of mybox2 is "+vol);
//        System.out.println("Weight of mybox1 is "+mybox2.weight);
//    }
//}

//class A {
//    int i, j;
//
//    void showij() {
//        System.out.println("i and j :" + i + " " + j);
//    }
//}
//
//class B extends A {
//    int k;
//
//    void showk() {
//        System.out.println("k : " + k);
//    }
//
//    void sum() {
//        System.out.println("i+j+k: " + (i + j + k));
//    }
//}
//
//class SimpleInheritance {
//    public static void main(String[] args) {
//        A superOb = new A();
//        B subob = new B();
//
//        superOb.i = 10;
//        superOb.j = 20;
//        System.out.println("Contents of superOb: ");
//        superOb.showij();
//        System.out.println();
//
//        subob.i = 7;
//        subob.j = 8;
//        subob.k = 9;
//        System.out.println("Contents of subob: ");
//        subob.showij();
//        subob.showk();
//        System.out.println();
//        System.out.println("Sum of i,j and k in subOb:");
//        subob.sum();
//    }
//}

//class CommandLine {
//    public static void main(String[] args) {
//        for (int i = 0; i < args.length; i++) {
//            System.out.println("args[" + i + "] : " +
//                    args[i]);
//        }
//    }
//}
//class StringDemo2 {
//    public static void main(String arg[]) {
//        String strob1 = "First String";
//        String strob2 = "Second String";
//        String strob3 = strob1;
//        System.out.println("Length of strob1: " +
//                strob1.length());
//        System.out.println("Char at index 3 in strob1: " +
//                strob1.charAt(3));//相当于数组的第四个元素
//        if (strob1.equals(strob2))
//            System.out.println("strob1 == strob2");
//        else
//            System.out.println("strob1 != strob2");
//        if(strob1.equals(strob3))
//            System.out.println("strob1 == strob3");
//        else
//            System.out.println("strob1 != strob3");
//    }
//}

//class Outer {
//    int outer_x = 100;
//    void test(){
//        Inner inner=new Inner();//嵌套类可以使用包含类里面的成员
//        inner.display();
//    }
//    class Inner{
//        void display(){
//            System.out.println("display : outre_x = "+ outer_x);
//        }
//    }
//}
//class InnerClassDemo{
//    public static void main(String args[]){
//        Outer outer=new Outer();
//        outer.test();
//    }
//}

// class Example {
//
//     public static void main(String[] args) {
//         System.out.println("Hello World!");
//     }
// }

//class Example2{
//    public static void main(String[] args){
//        int num;
//        num = 100;
//        System.out.println("This is num: " + num);
//        num = num * 2;
//        System.out.print("The value of num * 2 is " + num);//print 不会进行换行
//        System.out.println(num);//每次输出都会换行
//    }
//}

//class BitLogic {
//    public static void main(String args[]) {
//        String binary[] = {
//                "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000",
//                "1001", "1010", "1011", "1100", "1101", "1110", "1111"
//        };
//        int a = 3;//0011
//        int b = 6;//0110
//        int c = a | b;//按位或//0111
//        int d = a & b;//0010
//        int e = a ^ b;//0101
//        int f = (~a & b) | (a & ~b);//~a:1100 ~b:1001//0100 | 0001//0101
//        int g = ~a & 0x0f;//十六位的15 即二进制1111//1100
//        System.out.println(" a = " + binary[a]);
//        System.out.println(" b = " + binary[b]);
//        System.out.println(" a | b = " + binary[c]);
//        System.out.println(" a & b = " + binary[d]);
//        System.out.println(" a ^ b = " + binary[e]);
//        System.out.println(" (~a & b) | (a & ~b) = " + binary[f]);
//        System.out.println(" ~a & 0x0f = " + binary[g]);
//    }
//}

