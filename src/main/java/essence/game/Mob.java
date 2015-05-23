package essence.game;

public abstract class Mob extends Entity {

	private final UpdateFlags updateFlags = new UpdateFlags();

	protected Mob(Position position) {
		super(position);
	}

	public final UpdateFlags getUpdateFlags() {
		return updateFlags;
	}

}
