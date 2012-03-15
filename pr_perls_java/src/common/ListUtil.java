package common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListUtil {

	public static List<Integer> array2list(int[] arr) {
		List<Integer> out = new ArrayList<Integer>(arr.length);
		for (int elem : arr) {
			out.add(elem);
		}
		return out;
	}

	public static int[] list2array(List<Integer> ls) {
		int[] out = new int[ls.size()];
		int i = 0;
		for (Integer val : ls) {
			out[i++] = val;
		}
		return out;
	}

	public static String join(int[] arr) {
		return join(array2list(arr));
	}

	public static String join(List<?> c) {
		StringBuilder sb = new StringBuilder();
		Iterator<?> iter = c.iterator();
		while (iter.hasNext()) {
			Object o = iter.next();
			sb.append(o.toString());
			if (iter.hasNext())
				sb.append(", ");
		}
		return sb.toString();
	}
}
