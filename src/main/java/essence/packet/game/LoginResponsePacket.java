package essence.packet.game;

import essence.packet.Packet;

public final class LoginResponsePacket implements Packet {

	public static LoginResponsePacket get(int response, int userStatus, int flagged) {
		return new LoginResponsePacket(response, userStatus, flagged);
	}

	private final int response;
	private final int userStatus;
	private final int flagged;

	private LoginResponsePacket(int response, int userStatus, int flagged) {
		this.response = response;
		this.userStatus = userStatus;
		this.flagged = flagged;
	}

	public int getResponse() {
		return response;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public int getFlagged() {
		return flagged;
	}

}
