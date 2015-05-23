package essence.game;

import java.util.UUID;

public final class Player extends Mob {

	private final UUID uuid;
	private final String username;

	private Player(Position position, UUID uuid, String username) {
		super(position);
		this.uuid = uuid;
		this.username = username;
	}

	public UUID getUUID() {
		return uuid;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public void process() {

	}

}
