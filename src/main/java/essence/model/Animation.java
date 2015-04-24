package essence.model;

public final class Animation {

	public static Animation get(int id, int delay) {
		return new Animation(id, delay);
	}

	private final int id, delay;

	private Animation(int id, int delay) {
		this.id = id;
		this.delay = delay;
	}

	public int getID() {
		return id;
	}

	public int getDelay() {
		return delay;
	}

}
