package essence.packet.outgoing;

import essence.packet.OutgoingPacket;

public final class SetInterfacePacket implements OutgoingPacket {

	public static SetInterfacePacket get(int interfaceID, int sidebarID) {
		return new SetInterfacePacket(interfaceID, sidebarID);
	}

	private final int interfaceID;
	private final int sidebarID;

	private SetInterfacePacket(int interfaceID, int sidebarID) {
		this.interfaceID = interfaceID;
		this.sidebarID = sidebarID;
	}

	public int getInterfaceID() {
		return interfaceID;
	}

	public int getSidebarID() {
		return sidebarID;
	}

}
