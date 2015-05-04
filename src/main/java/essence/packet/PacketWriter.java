package essence.packet;

import java.io.ByteArrayOutputStream;

public final class PacketWriter extends ByteArrayOutputStream {

	public static PacketWriter get() {
		return new PacketWriter();
	}

	private PacketWriter() {
	}

	public void writeByte(int b) {
		write(b);
	}

	public void writeBytes(byte[] b) {
		write(b, 0, b.length);
	}

	public void writeByteA(int b) {
		write(b + 128);
	}

	public void writeByteC(int b) {
		write(-b);
	}

	public void writeShort(int s) {
		write(s >> 8);
		write(s);
	}

	public void writeShortA(int s) {
		write(s >> 8);
		write(s + 128);
	}

	public void writeLEShort(int s) {
		write(s);
		write(s >> 8);
	}

	public void writeLEShortA(int s) {
		write(s + 128);
		write(s >> 8);
	}

	public void writeInteger(int i) {
		writeShort(i >> 16);
		writeShort(i);
	}

	public void writeMiddleEndianInt(int i) {
		write(i >> 8);
		write(i);
		write(i >> 24);
		write(i >> 16);
	}

	public void writeLong(long l) {
		writeInteger((int) l >> 32);
		writeInteger((int) l);
	}

	public void writeString(String s) {
		writeBytes(s.getBytes());
		write('\n');
	}

}
