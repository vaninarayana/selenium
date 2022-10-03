import java.util.ArrayList;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int myNum=5;
		String website="Grubhub Eats";
		char letter = 'r';
		double dec = 5.99;
		boolean myCard = true;
		
		System.out.println(myNum+" is the value stored in the nyNum variable");
		System.out.println(website);
		
		// integer Arrays
		
		int[] arr = new int[5];
		arr[0] = 1; arr[1] = 1; arr[2] = 2; arr[3] = 3; arr[4] = 5; 
		
		int[] arr2 = {8,13,21,34,55,89};
		System.out.println(arr2[2]);
		
		//for loop for arr
		for(int i=0;i<arr.length;i++)
		{
			//System.out.println(arr[i]);
		}
		
		//for loop for arr2
		for(int i=0;i<arr2.length;i++)
		{
			//System.out.println(arr2[i]);
		}
		
		//string array
		String[] name = {"vani","narayana","java", "testing","selenium"};
		
		//for loop for string array
		for(int i=0;i<name.length;i++)
		{
			//System.out.println(name[i]);
		}	
		
		//advanced for loop for String array. Can be applied to all data types.
		for(String s: name)
		{
				//System.out.println(s);
		}
				
		//Check for all the multiples of 2 in the array using advanced for loop
		for(int s: arr)
		{
			if(s%2 == 0)
				System.out.println(s);
			else
				System.out.println(s+" is not completely divisible by 2. Sorry buddy!");
		}
		
		//Check if there are any multiples of 2 in the array using advanced for loop. if yes, break.
		for(int s: arr)
		{
			if(s%2 == 0)
			{
				System.out.println("Found it!The first mutlple of 2 in the array is "+s);
				break;
			}
			else
				System.out.println("No multiples of 2 here. Sorry buddy!");
		}		
		
		//ArrayLists
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Aarav");
		a.add("Shejekan");
		a.add("Awesome");
		a.add("Amazing");
		System.out.println(a.get(1));

	}

}
