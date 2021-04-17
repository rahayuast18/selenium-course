package selenium3;

import java.util.ArrayList;
import org.testng.annotations.Test;

public class ssssssssss {

	@Test
	public void main() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Ayu");
		names.add("Puji");
		names.add("Aria");
		names.add("Ghea");
		names.add("Ghozi");
		int count = 0;
		for (int i = 0; i <= names.size() ; i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}
}
