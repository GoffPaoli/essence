package essence.packet;

import java.io.ByteArrayInputStream;

public final class PacketReader extends ByteArrayInputStream {
	
	public static PacketReader get(PacketMessage message) {
		return get(message.getData());
	}

	public static PacketReader get(byte[] data) {
		return new PacketReader(data);
	}

	private PacketReader(byte[] data) {
		super(data);
	}

	public int readByteA() {
		return read() - 128;
	}

	public int readByteC() {
		return -read();
	}

	public int readUnsignedByte() {
		return read() & 0xFF;
	}

	public int readShort() {
		return (read() << 8) + read();
	}

	public int readShortA() {
		int i = (readUnsignedByte() << 8) + (read() - 128 & 0xFF);
		if (i > 0x7FFF)
			i -= 0x10000;
		return i;
	}

	public int readLEShortA() {
		int i = (read() - 128 & 0xFF) + (readUnsignedByte() << 8);
		if (i > 0x7FFF)
			i -= 0x10000;
		return i;
	}

	public int readUnsignedShort() {
		return (readUnsignedByte() << 8) + readUnsignedByte();
	}

	public int readInteger() {
		return (readShort() << 16) + readShort();
	}

	public long readUnsignedInteger() {
		return (readUnsignedShort() << 16) + readUnsignedShort();
	}

	public long readLong() {
		return (readInteger() << 24) + readInteger();
	}

	public String readString() {
		StringBuilder buffer = new StringBuilder();
		char read;
		while ('\n' != (read = (char) readUnsignedByte()) && available() != 0)
			buffer.append(read);
		return buffer.toString();
	}

}
