
public enum Color {
	RED,
	GREEN,
	BLUE,
	YELLOW;
	public String toString() {
		if(this==Color.RED)
			return "R";
		if(this==Color.GREEN)
			return "G";
		if(this==Color.BLUE)
			return "B";
		if(this==Color.YELLOW)
			return "Y";
		throw new IllegalStateException("Should not be possible");
	}
	public java.awt.Color toColor() {
		if (this == RED) {
			return java.awt.Color.RED;
		}
		if (this == GREEN) {
			return java.awt.Color.GREEN;
		}
		if (this == BLUE) {
			return java.awt.Color.BLUE;
		}
		return java.awt.Color.YELLOW;
	}
}
