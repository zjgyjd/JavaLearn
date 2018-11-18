public class DesignPattern{
	// public static void simpleF(){
				// Client c = new Client();
	// if(args.length > 0){
		// String type = args[0];
		// Computer computer = SimpleComputer.getInstance(type);
		// if(computer == null){
			// System.out.println("error");
		// }else{
			// c.buy(computer);
		// }
	// }else{
		// System.out.println("no find");
	// }
		// //c.buy(new SimpleComputer.getInstance("mac"));
	// }
	public static void main(String[] args){
		Client c = new Client();
		ComputerFactory co = new MacComputerFactory();
		Computer computer = co.creatComputer();
		c.buy(computer);
	}
}
class Client{
	public void buy(Computer computer){
		 computer.prtComouter();
	}
}
interface Computer{
	public void prtComouter();
}

interface OpreatorSystem{
	void printSystem();
}

class SimpleComputer{
	public static Computer getInstance(String type){
		switch(type){
			case "mac":
				return new MacComputer();
			case "surface":
				return new SurfaceComputer();
			default:
				System.out.println("Undefined!!!");
				return null;
		}
	}
}

interface ComputerFactory{
	Computer creatComputer();
}

interface ProductFactory{
	Computer creatComputer();
	OpreatorSystem printSystem();
	
}

class MacComputer implements Computer{
	public void prtComouter(){
		System.out.println("Mac");
	}
}

class MacOs implements OpreatorSystem{
	public void printSystem(){
		System.out.println("Mac");
	}
}

class MacComputerFactory implements ComputerFactory{
	public Computer creatComputer(){
		return new MacComputer();
	}
	public OpreatorSystem(){
		return new MacOs();
	}
}

class AppleProductFactory implements ProductFactory{
	public Computer creatComputer(){
		return new MacComputer();
	}
}

class SurfaceComputer implements Computer{
	public void prtComouter(){
		System.out.println("Sur");
	}
}


class SurfaceOs implements OpreatorSystem{
	public void printSystem(){
		System.out.println("Surface");
	}
}

class SurfaceComputerFactory implements ComputerFactory{
	public Computer creatComputer(){
		return new SurfaceComputer();
	}
}
