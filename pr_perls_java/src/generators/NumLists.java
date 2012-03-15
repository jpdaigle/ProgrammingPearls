package generators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumLists {
	public static int[] randomUniqueInts(int k_size, int n_maxnum) {
		if (k_size >= n_maxnum)
			throw new IllegalArgumentException("For simplicity, we are assuming k_size is <= than n");
		List<Integer> temp = new ArrayList<Integer>(k_size);
		for (int i = 0; i < k_size; i++)
			temp.add(i);
		Collections.shuffle(temp);
		int[] out = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++)
			out[i] = temp.get(i);
		return out;
	}
}
