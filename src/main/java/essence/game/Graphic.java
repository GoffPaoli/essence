package essence.game;

public final class Graphic {

	private final int id, delay, height;

	private Graphic(int id, int delay, int height) {
		this.id = id;
		this.delay = delay;
		this.height = height;
	}

	public int getID() {
		return id;
	}

	public int getDelay() {
		return delay;
	}

	public int getHeight() {
		return height;
	}

}
