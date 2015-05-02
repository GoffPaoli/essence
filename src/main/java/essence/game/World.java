package essence.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class World {
	
	public static final int PLAYER_CAPACITY = 2000;

	private final List<Player> players = new ArrayList<>(PLAYER_CAPACITY);

	public Player getPlayer(UUID uuid) {
		for (Player player : players) {
			if (uuid.equals(player.getUUID())) {
				return player;
			}
		}
		return null;
	}

	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public int getNextAvailableIndex() {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i) == null) {
				return i + 1;
			}
		}
		return players.size();
	}

}
