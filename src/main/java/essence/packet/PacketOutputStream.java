package essence.packet;

public final class PacketOutputStream {

	private static final int DEFAULT_CAPACITY = 64;

	public static PacketOutputStream get(byte[] data) {
		return new PacketOutputStream(data);
	}

	public static PacketOutputStream get(int initialCapacity) {
		return get(new byte[initialCapacity]);
	}

	public static PacketOutputStream get() {
		return get(DEFAULT_CAPACITY);
	}

	private static final int bitmasks[] = {
		0, 0x1, 0x3, 0x7,
		0xf, 0x1f, 0x3f, 0x7f,
		0xff, 0x1ff, 0x3ff, 0x7ff,
		0xfff, 0x1fff, 0x3fff, 0x7fff,
		0xffff, 0x1ffff, 0x3ffff, 0x7ffff,
		0xfffff, 0x1fffff, 0x3fffff, 0x7fffff,
		0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff,
		0xfffffff, 0x1fffffff, 0x3fffffff, 0x7fffffff,
		-1
	};

	private byte[] data;
	private int position = 0;
	private int bitPosition = 0;

	private PacketOutputStream(byte[] data) {
		this.data = data;
	}

	private void writeUnsafe(int b) {
		data[position++] = (byte) b;
	}

	public void write(int b) {
		expand(1);
		writeUnsafe(b);
	}

	public void writeByteA(int b) {
		expand(1);
		writeUnsafe(b + 128);
	}

	public void writeByteC(int b) {
		expand(1);
		writeUnsafe(-b);
	}

	public void writeShort(int s) {
		expand(2);
		writeUnsafe(s >> 8);
		writeUnsafe(s);
	}

	public void writeShortA(int s) {
		expand(2);
		writeUnsafe(s >> 8);
		writeUnsafe(s + 128);
	}

	public void writeLEShort(int s) {
		expand(2);
		writeUnsafe(s);
		writeUnsafe(s >> 8);
	}

	public void writeLEShortA(int s) {
		expand(2);
		writeUnsafe(s + 128);
		writeUnsafe(s >> 8);
	}

	public void writeInteger(int i) {
		expand(4);
		writeUnsafe(i >> 24);
		writeUnsafe(i >> 16);
		writeUnsafe(i >> 8);
		writeUnsafe(i);
	}

	public void writeInteger1(int i) {
		expand(4);
		writeUnsafe(i >> 8);
		writeUnsafe(i);
		writeUnsafe(i >> 24);
		writeUnsafe(i >> 16);
	}

	public void writeLong(long l) {
		expand(8);
		writeUnsafe((int) (l >> 56));
		writeUnsafe((int) (l >> 48));
		writeUnsafe((int) (l >> 40));
		writeUnsafe((int) (l >> 32));
		writeUnsafe((int) (l >> 24));
		writeUnsafe((int) (l >> 16));
		writeUnsafe((int) (l >> 8));
		writeUnsafe((int) l);
	}

	public void writeString(String s) {
		expand(s.length() + 1);
		writeBytes(s.getBytes());
		writeUnsafe(10);
	}

	public void writeBytes(byte[] bs) {
		expand(bs.length);
		System.arraycopy(bs, 0, data, position, bs.length);
		position += bs.length;
	}

	public void writeBits(int numBits, int value) {
		int bytePos = bitPosition >> 3;
		int bitOffset = 8 - (bitPosition & 7);
		bitPosition += numBits;
		position = (bitPosition + 7) / 8;
		for (; numBits > bitOffset; bitOffset = 8) {
			expand(1);
			data[bytePos] &= ~bitmasks[bitOffset]; // mask out the desired area
			data[bytePos++] |= value >> numBits - bitOffset & bitmasks[bitOffset];

			numBits -= bitOffset;
		}
		if (numBits == bitOffset) {
			data[bytePos] &= ~bitmasks[bitOffset];
			data[bytePos] |= value & bitmasks[bitOffset];
		} else {
			data[bytePos] &= ~(bitmasks[numBits] << bitOffset - numBits);
			data[bytePos] |= (value & bitmasks[numBits]) << bitOffset - numBits;
		}
	}

	public int getLength() {
		return position;
	}

	public byte[] getData() {
		byte[] data = new byte[position];
		System.arraycopy(this.data, 0, data, 0, position);
		return data;
	}

	private void expand(int i) {
		if (position + i < data.length)
			return;
		byte[] newbuf = new byte[(position + i) * 2];
		System.arraycopy(data, 0, newbuf, 0, position);
		data = newbuf;
	}

}
