package essence.game;

public final class Graphic {

	public static Graphic get(int id, int height, int delay) {
		return new Graphic(id, height, delay);
	}

	public static Graphic get(int id, int height) {
		return get(id, height, 0);
	}

	public static Graphic get(int id) {
		return get(id, 0);
	}

	private final int id, height, delay;

	private Graphic(int id, int height, int delay) {
		this.id = id;
		this.height = height;
		this.delay = delay;
	}

	public int getID() {
		return id;
	}

	public int getHeight() {
		return height;
	}

	public int getDelay() {
		return delay;
	}

}
