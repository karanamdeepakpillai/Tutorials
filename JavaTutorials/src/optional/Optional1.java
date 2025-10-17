package optional;
import java.util.*;

public class Optional1 {

	public static void main(String[] args) {
		
		//createOptionalInstances();
		handleOptionalInstances();
	}
	
	public static void createOptionalInstances() {
		Optional<String> opt1 = Optional.of("Hey value!");
		Optional<String> opt2 = Optional.ofNullable(null);
		Optional<String> opt3 = Optional.empty();
		
		System.out.println("output: "+opt1.toString()+opt2.toString()+opt3.toString());
		
	}
	
	public static void handleOptionalInstances() {
		Optional<String> opt1 = Optional.of("Hey value!");
		if(opt1.isPresent()) {
			System.out.println(opt1.get());
		}
		System.out.println(opt1.isEmpty());
		
		//returns the optional obj if criteria is satisfied
		System.out.println(opt1.filter(s->s.equals("Hey value!")));
		//returns empty optional obj if the criteria is not satisfied
		System.out.println(opt1.filter(s->s.equals("Hey!")));
		//maps the object to output of the lambda function
		System.out.println(opt1.map(String::length).get());
		
		Optional<List<List<Integer>>> opt2 = Optional.of(List.of(List.of(1,2,3,4,5),List.of(6,7),List.of(8,9,0)));
		System.out.println(opt1.flatMap(a->Optional.of(a)).get()); // flattens the optional
		System.out.println(opt1.map(a->Optional.of(a)).get()); // doesn't flatten the optional.
		
		System.out.println(opt1.or(()->Optional.of("Here!")).get()); // returns the provided optional object in case opt1 is empty
		System.out.println(opt1.orElse("Here!"));
		System.out.println(opt1.orElseGet(()->"Here")); //executes a supplier if the opt1 is empty
		System.out.println(opt1.orElseThrow());// throws no such element exception
		System.out.println(opt1.orElseThrow(()->new NoSuchElementException())); // throws the provided exception. 
		
		
	}
}
