package selenium3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {
	
	public void regular() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Ayu");
		names.add("Puji");
		names.add("Aria");
		names.add("Ghea");
		names.add("Ghozi");
		int count = 0;
		for (int i = 0; i < names.size() ; i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Ayu");
		names.add("Puji");
		names.add("Aria");
		names.add("Ghea");
		names.add("Ghozi");
		long count = names.stream().filter(n -> n.startsWith("G")).count();
		System.out.println(count);
		System.out.println("");
		
		long count2 = Stream.of("Ayu", "Puji", "Aria", "Ghea", "Ghozi").filter(n -> {
			n.startsWith("A");
			return true;
		}).count();
		System.out.println(count2); // kenapa ini 5?
		System.out.println("");
		
		names.stream().filter(n -> n.length() > 3).forEach(n -> System.out.println(n));
		System.out.println("");
		names.stream().filter(n -> n.length() > 3).limit(1).forEach(n -> System.out.println(n));
	}

	// 25.58
	
	public void streamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Intan");
		names.add("Ellen");
		names.add("Aeri");
		//System.out.println(names);
		//names.stream().forEach(n -> System.out.println(n));
		//System.out.println("");
		
		Stream.of("Enni", "Bellia", "Naya", "Khani", "Arsya").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));		
		System.out.println("");
		
		List<String> names1 = Arrays.asList("Anaya", "Awinda", "Almi", "Endah");
		names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("");
		
		Stream<String> mergeName = Stream.concat(names.stream(), names1.stream());
//		mergeName.sorted().forEach(s -> System.out.println(s));
//		System.out.println("");
		
		boolean flag = mergeName.anyMatch(s -> s.equalsIgnoreCase("Anaya"));
		System.out.println(flag); 
		System.out.println(""); 
		Assert.assertTrue(flag);
	}

	public void streamCollect() {
		List<String> ls = Stream.of("Ayu", "Puji", "Aria", "Ghea", "Ghozi").filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		System.out.println("");
		
		List<Integer> numbers = Arrays.asList(3,4,5,4,3,6,7,7,2,3,8,4);
		numbers.stream().distinct().sorted().forEach(s -> System.out.println(s));
		System.out.println("");
		
		List<Integer> list = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(list.get(4));
		System.out.println("");
	}
}
