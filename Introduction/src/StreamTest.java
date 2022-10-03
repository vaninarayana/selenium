import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("Ajay");
		nameList.add("Bajay");
		nameList.add("Lajay");
		nameList.add("Amit");
		nameList.add("Camit");
		nameList.add("Samit");
		nameList.add("Anu");
		nameList.add("Janu");
		nameList.add("Manu");
		
		//find the couunt of names starting with 'A'
		Long c = nameList.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		//find and print all names with length less than 5
		nameList.stream().filter(names->names.length()<5).forEach(name->System.out.println(name));
		
		//find all names with length less than 5 and print the first name found.
		nameList.stream().filter(names->names.length()<5).limit(1).forEach(name->System.out.println(name));
		
		//using 'map' method, print filtered strings in uppercase
		Stream.of("Aarav","Ahaan","Anuvind","Anya","Rushil","Rishi","Rohan","Shreyansh","Arjun","Gatik").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//find names starting with 'V', sort them alphabetically [use 'sorted' method], print in uppercase
		List<String> arrNames = Arrays.asList("Vani","Revati","Akshata","Hareesh","Praveen","Amit","Padma","Prajna","Litu","Fami","Latha","Victor");
		
		arrNames.stream().filter(s->s.startsWith("P")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//find names that start with V or P and then concatenate,sort and print.
		Stream<String> concatStr = Stream.concat(arrNames.stream().filter(s->s.startsWith("V")), arrNames.stream().filter(s->s.startsWith("P")));
		//concatStr.sorted().forEach(s->System.out.println(s));
		
		//see if the new string has a match for name 'vani'
		System.out.println(concatStr.anyMatch(s->s.equalsIgnoreCase("vani"))); 
		
		//Find distinct elements of a list, sort , convert to List and get the value at index 2. 
		
		List<Integer> numList = Arrays.asList(3,2,3,2,7,5,9,7);
		int i = numList.stream().distinct().sorted().collect(Collectors.toList()).get(2);
		
		System.out.println("i is "+i);
		
	}

}
