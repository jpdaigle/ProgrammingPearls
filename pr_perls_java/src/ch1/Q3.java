package ch1;

import generators.NumLists;

import common.Stopwatch;

public class Q3 {

	public static class BitVector {
		public byte[] data;
		public int popCount = 0; // keep track of # of set bits

		public BitVector(final int size) {
			data = new byte[(int) Math.ceil((double) size / (double) 8)];
		}

		public void set(int i, boolean value) {
			int bytepos = (i / 8);
			int bit = i % 8;
			if (value) {
				// incr if bit not already set
				popCount += (get(i) ? 0 : 1);
				data[bytepos] = (byte) (data[bytepos] | (byte) (1 << bit));
			} else {
				// decr if bit was set
				popCount -= (get(i) ? 1 : 0);
				data[bytepos] = (byte) (data[bytepos] & ~(byte) (1 << bit));
			}
		}

		public boolean get(int i) {
			int bytepos = (i / 8);
			int bit = i % 8;
			return ((data[bytepos] & (1 << bit)) != 0);
		}

		public int[] sortedArray() {
			final int size = data.length * 8;
			int[] out = new int[popCount];
			int sz = 0;
			for (int i = 0; i < size; i++) {
				if (get(i)) {
					out[sz++] = i;
				}
			}
			return out;
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] data = NumLists.randomUniqueInts(2000000, 20000000);
		Stopwatch sw = new Stopwatch();
		sw.start();
		BitVector bv = new BitVector(data.length);
		for (int i = 0; i < data.length; i++) {
			bv.set(data[i], true);
		}
		int[] out_data = bv.sortedArray();
		sw.stop();
		// System.out.println(ListUtil.join(out_data));
		System.out.println(sw.getMillis() + " ms");
	}

}
