package common;

public class Stopwatch {
	private long start, stop;

	public Stopwatch() {

	}

	public void start() {
		stop = 0;
		start = System.nanoTime();
	}

	public void stop() {
		stop = System.nanoTime();
	}

	public long getNanos() {
		return (stop - start);
	}

	public long getMillis() {
		return (stop - start) / 1000000;
	}
}
