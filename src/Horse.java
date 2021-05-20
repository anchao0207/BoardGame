
public enum Horse {
	RED,
	GREEN,
	BLUE,
	YELLOW;
	

	public String toString() {
		if(this==RED)
			return "R";
		if(this==GREEN)
			return "G";
		if(this==BLUE)
			return "B";
		if(this==YELLOW)
			return "Y";
		throw new IllegalStateException("Should not be possible");
	}
}
