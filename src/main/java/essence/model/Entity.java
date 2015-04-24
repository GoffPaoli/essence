package essence.model;

public abstract class Entity {

	private Position position;

	protected Entity(Position position) {
		this.position = position;
	}

	public final Position getPosition() {
		return position;
	}

	public final void setPosition(Position position) {
		this.position = position;
	}

}
