package essence.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public final class World {

	public static final int PLAYER_CAPACITY = 2_000;

	private final List<Player> players = new ArrayList<>(PLAYER_CAPACITY);

	public Optional<Player> getPlayer(UUID uuid) {
		for (Player player : players)
			if (uuid.equals(player.getUUID()))
				return Optional.of(player);
		return Optional.empty();
	}

	public Optional<Player> getPlayer(String username) {
		for (Player player : players)
			if (username.equalsIgnoreCase(player.getUsername()))
				return Optional.of(player);
		return Optional.empty();
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
		for (int i = 0; i < players.size(); i++)
			if (players.get(i) == null)
				return i + 1;
		return players.size();
	}

	public void process() {
		for (Player player : players)
			player.process();
	}

}
