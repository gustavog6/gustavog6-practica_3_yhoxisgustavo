package practica3yhoxisgustavo;

import org.jgroups.util.Streamable;

import java.io.DataInput;
import java.io.DataOutput;

public class DrawCommand implements Streamable {
	static final byte DRAW = 1;
	static final byte CLEAR = 2;
	byte mode;
	int x;
	int y;
	int rgb;

	public DrawCommand() {
	}

	DrawCommand(byte mode) {
		this.mode = mode;
	}

	DrawCommand(byte mode, int x, int y, int rgb) {
		this.mode = mode;
		this.x = x;
		this.y = y;
		this.rgb = rgb;
	}

	public void writeTo(DataOutput out) throws Exception {
		out.writeByte(mode);
		out.writeInt(x);
		out.writeInt(y);
		out.writeInt(rgb);
	}

	public void readFrom(DataInput in) throws Exception {
		mode = in.readByte();
		x = in.readInt();
		y = in.readInt();
		rgb = in.readInt();
	}

	public String toString() {
		StringBuilder ret = new StringBuilder();
		switch (mode) {
		case DRAW:
			ret.append("DRAW(" + x + ", " + y + ") [" + rgb + "]");
			break;
		case CLEAR:
			ret.append("CLEAR");
			break;
		default:
			return "<undefined>";
		}
		return ret.toString();
	}

}