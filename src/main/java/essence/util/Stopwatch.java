package essence.util;

import static java.lang.System.nanoTime;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.concurrent.TimeUnit;

public final class Stopwatch {

	public static Stopwatch start() {
		return new Stopwatch(nanoTime());
	}

	private final long time;

	private Stopwatch(long time) {
		this.time = time;
	}

	public long elapsed() {
		return nanoTime() - time;
	}

	public long elapsed(TimeUnit desiredUnit) {
		return desiredUnit.convert(elapsed(), NANOSECONDS);
	}

}
