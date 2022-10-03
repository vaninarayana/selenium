
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//access method in this class.
		MethodsDemo a = new MethodsDemo();
		String gift = a.printData();
		System.out.println("Here's some "+gift+" for you!");
		
		//access method in a different class.
		MethodsDemo2 a2 = new MethodsDemo2();
		String gift2 = a2.printDemoData();
		System.out.println("Here's some "+gift2+" for you!");
		
		//accessing static method within this class, without creating any object
		String gift3 = printData2();
		System.out.println(gift3);		

	}
	
	public String printData()
	{
		System.out.println("Hello beautiful people");
		return "Kaju Barfi";
	}
	
	//static keyword changed method to class level. No need to create any object to call the method.
	public static String printData2()
	{
		System.out.println("Hi there");
		return "Well. I come with VIP access!";
	}	

}
