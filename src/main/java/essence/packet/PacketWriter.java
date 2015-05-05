package essence.packet;

import java.io.ByteArrayOutputStream;

public final class PacketWriter extends ByteArrayOutputStream {

	public static PacketWriter get() {
		return new PacketWriter();
	}

	private PacketWriter() {
	}

	public void writeByte(int value) {
		write(value);
	}

	public void writeBytes(byte[] values) {
		write(values, 0, values.length);
	}

	public void writeByteA(int value) {
		write(value + 128);
	}

	public void writeByteC(int value) {
		write(-value);
	}

	public void writeBoolean(boolean value) {
		write(value ? 1 : 0);
	}

	public void writeShort(int value) {
		write(value >> 8);
		write(value);
	}

	public void writeShortA(int value) {
		write(value >> 8);
		write(value + 128);
	}

	public void writeLEShort(int value) {
		write(value);
		write(value >> 8);
	}

	public void writeLEShortA(int value) {
		write(value + 128);
		write(value >> 8);
	}

	public void writeMedium(int value) {
		write(value >> 16);
		write(value >> 8);
		write(value);
	}

	public void writeInteger(int value) {
		writeShort(value >> 16);
		writeShort(value);
	}

	public void writeMEInt(int value) {
		write(value >> 8);
		write(value);
		write(value >> 24);
		write(value >> 16);
	}

	public void writeLong(long value) {
		writeInteger((int) value >> 32);
		writeInteger((int) value);
	}

	public void writeString(String value) {
		writeBytes(value.getBytes());
		write('\n');
	}

}
