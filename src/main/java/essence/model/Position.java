package essence.model;

public final class Position {

	public static Position get(int x, int y, int z) {
		return new Position(x, y, z);
	}

	private final int x, y, z;

	private Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

}
