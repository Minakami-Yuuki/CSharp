import java.util.*;

public class TestArgsWords {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		for(int i = 0; i < args.length; i++) {
			int freq = m.get(args[i]);
			//int freq = (Integer) m.get(args[i]) == null ? 0 : (Integer) m.get(args[i]);
			m.put(args[i], (freq == 0 ? 1 : (freq) + 1));
		}
		
		System.out.println(m.size() + " distinct words detected: ");
		System.out.println(m);
	}
}