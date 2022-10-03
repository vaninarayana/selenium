
public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String literal. String is an object
		String s = "Vani Narayana Selenium";
		
		//String s1 = "Vani Narayana Selenium"; //String value is same as s. So no new memory will be allocated. 
		
		String s2 = new String("test");
		String s3 = new String("test"); // Even though string values of s2 and s3 are same, new memory is allocated here.
		
		String[] splitStr = s.split(" ");
		System.out .println(splitStr[1]);
		
		String[] splitStr2 = s.split("Narayana");
		System.out.println(splitStr2[0]);
		System.out.println(splitStr2[1].trim());
		
		//Iterate a string object
		
		for(int i=0;i<s.length();i++)
		{
			System.out.println(s.charAt(i));
		}
		
		for(int i=(s.length()-1);i>=0;i--)
		{
			System.out.println(s.charAt(i));
		}		
		

	}

}
