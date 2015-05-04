package essence.packet.game;

import essence.packet.Packet;

public final class LoginPacket implements Packet {

	public static LoginPacket get(int magic, int clientVersion, boolean highDetail, int[] fileChecksums,
			int blockLength, int blockID, int[] sessionKeys, int userID, String username, String password) {
		return new LoginPacket(magic, clientVersion, highDetail, fileChecksums, blockLength, blockID, sessionKeys,
				userID, username, password);
	}

	private final int magic;
	private final int clientVersion;
	private final boolean highDetail;
	private final int[] fileChecksums;
	private final int blockLength, blockID;
	private final int[] sessionKeys;
	private final int userID;
	private final String username, password;

	private LoginPacket(int magic, int clientVersion, boolean highDetail, int[] fileChecksums, int blockLength,
			int blockID, int[] sessionKeys, int userID, String username, String password) {
		this.magic = magic;
		this.clientVersion = clientVersion;
		this.highDetail = highDetail;
		this.fileChecksums = fileChecksums;
		this.blockLength = blockLength;
		this.blockID = blockID;
		this.sessionKeys = sessionKeys;
		this.userID = userID;
		this.username = username;
		this.password = password;
	}

	public int getMagic() {
		return magic;
	}

	public int getClientVersion() {
		return clientVersion;
	}

	public boolean isHighDetail() {
		return highDetail;
	}

	public int[] getFileChecksums() {
		return fileChecksums;
	}

	public int getBlockLength() {
		return blockLength;
	}

	public int getBlockID() {
		return blockID;
	}

	public int[] getSessionKeys() {
		return sessionKeys;
	}

	public int getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
