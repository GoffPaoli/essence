package essence.game;

public final class Animation {

	public static Animation get(int id, int delay) {
		return new Animation(id, delay);
	}

	public static Animation get(int id) {
		return get(id, 0);
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
