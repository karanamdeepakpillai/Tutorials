package stream;
import java.util.*;

public class Stream1 {
	static List<String> names = List.of("Alice", "Bob", "Charlie","Suresh","Adi","Hitler", "Charlie","Suresh","Adi","Curie");

	
	public static void main(String[] args) {
		
		terminalOperators();
		intermediateOperators();
		
	}
	
	public static void terminalOperators() {
		//forEach<Consumer<T>>() iterates thru all elements in streams. 
		System.out.println("####forEach()");
		names.stream().forEach(System.out::println);
		
		//reduce<BinaryOperator<T>>()
		System.out.println("####reduce()");
		names.stream().reduce((a,b)->a.concat(b+",")).ifPresent(System.out::println);
		
		//count()
		System.out.println("####count()");
		System.out.println(names.stream().count());
		
		//anyMatch();
		System.out.println("####anyMatch();\n"+names.stream().anyMatch(s->s.equals("Suresh")));
		
		//allMatch(); returns true if all match the criteria
		System.out.println("####allMatch();\n"+names.stream().allMatch(s->s.length()>2));
		
		//noneMatch(); returns true if none match the criteria
		System.out.println("####noneMatch();\n"+names.stream().noneMatch(s->s.length()>2));
		
		//findFirst(); returns first element of the sream as optional
		System.out.println("####findFirst();\n"+names.stream().findFirst().get());
		
		//findAny(); returns first element of the sream as optional
		System.out.println("####findAny();\n"+names.stream().findAny().get());
		
	}
	public static void intermediateOperators() {
				
		//map<Function<T,R>() transforms each element of the stream to another form. 
		System.out.println("####Stream.map()");
		names.stream().map((a)->a.length()).forEach(System.out::println);
		System.out.println("####Stream.map() using Scope resolution op");
		names.stream().map(String::length).forEach(System.out::println);
		System.out.println("####Stream.mapToInt() using Scope resolution op");
		names.stream().mapToInt(String::length).forEach(System.out::println);
		
		//boxed() transforms primitive stream back to object stream. 
		//Primitive streams don't have all the functions of streams 
		System.out.println("####Stream.boxed()");
		names.stream().mapToInt(String::length).boxed().toList().forEach(System.out::println);
		
		//onClose(Runnable), close() 
		System.out.println("####Stream.onClose().closed()");
		names.stream().mapToInt(String::length).boxed().onClose(()->System.out.println("cleanup activity performed!!")).close();
		
		//filter<Predicate<T>() filters based on the return if true or false
		System.out.println("####Stream.filter()");
		names.stream().filter(a->a.length()>3).forEach(System.out::println);
		
		//flatMap<Function<T,Stream<R>>() it will take a 2d collection and convert to a 1d collection, It is to return a stream which is later stitched
		// to get a 1d collection. 
		System.out.println("####Stream.flatMap()");
		List<List<String>> n2 = List.of(List.of("Alice", "Bob", "Charlie","Suresh","Adi","Hitler"),
				List.of("Alice1", "Bob1", "Charlie1","Suresh1","Adi1","Hitler1"),
				List.of("Alice2", "Bob2", "Charlie2","Suresh2","Adi2","Hitler2"));
		n2.stream().flatMap(a->a.stream()).forEach(System.out::println);
		
		//distinct() returns distinct objects in stream
		System.out.println("####Stream.distinct()");
		names.stream().distinct().forEach(System.out::println);
		
		//sorted() returns sorted stream. 
		System.out.println("####Stream.sorted()");
		names.stream().sorted().forEach(System.out::println);
		
		//limit(long n) returns first elements
		System.out.println("####Stream.limit()");
		names.stream().limit(5).forEach(System.out::println);

		//skip(long n) skips first elements
		System.out.println("####Stream.skip()");
		names.stream().skip(5).forEach(System.out::println);
		
		//peek(Consumer<T>) consumes elements of the stream but doesn't modify them. 
		System.out.println("####Strem.peek()");
		names.stream().peek(System.out::println).toList();
		
		//takeWhile() runs an iteration along the stream until the criteria is not met. and picks all iterated objects. 
		System.out.println("####Strem.takeWhile()");
		names.stream().takeWhile(s->!s.equals("Suresh")).forEach(System.out::println);
		
		//dropWhile() runs an iteration along the stream until the criteria is not met and drops all the iteratd objects. 
		System.out.println("####Strem.dropWhile()");
		names.stream().dropWhile(s->!s.equals("Suresh")).forEach(System.out::println);
		
		
	}

}
