package essence.game;

import essence.util.attribute.Attributes;

public abstract class Entity extends Attributes {
	
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
