
public class Horse {
	
	private Color color;
	private int r;
	private int c;
	
	public Horse(Color color) {
		this.color=color;
		if(this.color==Color.RED) {
			this.r=0;
			this.c=6;
		}
		if(this.color==Color.GREEN) {
			this.r=8;
			this.c=0;
		}
		if(this.color==Color.BLUE) {
			this.r=14;
			this.c=8;
		}
		if(this.color==Color.YELLOW) {
			this.r=6;
			this.c=14;
		}
	}
	
	public Color getColor() {
		return this.color;
	}
	public int getRow() {
		return r;
	}
	public int getCol() {
		return c;
	}
	
	public void setCoordinate(int x, int y) {
		r=x;
		c=y;
	}
	
	public String toString() {
		if(this.color==Color.RED)
			return "R";
		if(this.color==Color.GREEN)
			return "G";
		if(this.color==Color.BLUE)
			return "B";
		if(this.color==Color.YELLOW)
			return "Y";
		throw new IllegalStateException("Should not be possible");
	}
}
