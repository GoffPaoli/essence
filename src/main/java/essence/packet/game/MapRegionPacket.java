package essence.packet.game;

import essence.packet.Packet;

public final class MapRegionPacket implements Packet {

	public static MapRegionPacket get(int regionX, int regionY) {
		return new MapRegionPacket(regionX, regionY);
	}

	private final int regionX, regionY;

	private MapRegionPacket(int regionX, int regionY) {
		this.regionX = regionX;
		this.regionY = regionY;
	}

	public int getRegionX() {
		return regionX;
	}

	public int getRegionY() {
		return regionY;
	}

}
