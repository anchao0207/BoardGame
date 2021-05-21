
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
}
