package essence.packet.incoming;

import essence.packet.AbstractIncomingPacket;
import essence.packet.PacketClient;

public final class LoginPacket extends AbstractIncomingPacket {

	public static LoginPacket get(PacketClient client, int magic, int clientVersion, boolean highDetail,
			int[] fileChecksums, int blockLength, int blockID, int[] sessionKeys, int uid, String username,
			String password) {
		return new LoginPacket(client, magic, clientVersion, highDetail, fileChecksums, blockLength, blockID,
				sessionKeys, uid, username, password);
	}

	private final int magic;
	private final int clientVersion;
	private final boolean highDetail;
	private final int[] fileChecksums;
	private final int blockLength, blockID;
	private final int[] sessionKeys;
	private final int uid;
	private final String username, password;

	private LoginPacket(PacketClient client, int magic, int clientVersion, boolean highDetail, int[] fileChecksums,
			int blockLength, int blockID, int[] sessionKeys, int uid, String username, String password) {
		super(client);
		this.magic = magic;
		this.clientVersion = clientVersion;
		this.highDetail = highDetail;
		this.fileChecksums = fileChecksums;
		this.blockLength = blockLength;
		this.blockID = blockID;
		this.sessionKeys = sessionKeys;
		this.uid = uid;
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

	public int getUID() {
		return uid;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
