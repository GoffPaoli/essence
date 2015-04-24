package essence.util.logging;

public enum Levels implements Level {

	OFF(Integer.MIN_VALUE),

	ERROR(100), WARNING(200), INFO(300), DEBUG(400), CONFIG(500),

	ALL(Integer.MAX_VALUE);

	private final int value;

	Levels(int value) {
		this.value = value;
	}

	@Override
	public String getName() {
		return name().replaceAll("_", " ");
	}

	@Override
	public int getValue() {
		return value;
	}

}
