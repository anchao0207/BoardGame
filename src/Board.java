import javax.swing.JPanel;

public class Board extends JPanel{
	private static Horse[][] board = new Horse[15][15];
	public int die1;
	public int die2;
//	int blueHorses;
//	int redHorses;
//	int greenHorses;
//	int yellowHorses;
	public Board() {
		
	}
	
	public void add(Horse horse) {
		if(horse==Horse.RED) {
			if(board[0][6] instanceof Horse)
				System.out.println(board[0][6]+" have been kicked");
			board[0][6]=Horse.RED;
			System.out.println(Horse.RED+" spawn at (0, 6)");
		}
		if(horse==Horse.GREEN) {
			if(board[8][0] instanceof Horse)
				System.out.println(board[8][0]+" have been kicked");
			board[8][0]=Horse.GREEN;
			System.out.println(Horse.GREEN+" spawn at (8, 0)");
		}
		if(horse==Horse.BLUE) {
			if(board[14][8] instanceof Horse)
				System.out.println(board[14][8]+" have been kicked");
			board[14][8]=Horse.BLUE;
			System.out.println(Horse.BLUE+" spawn at (14, 8)");
		}
		if(horse==Horse.YELLOW) {
			if(board[6][14] instanceof Horse)
				System.out.println(board[6][14]+" have been kicked");
			board[6][14]=Horse.YELLOW;
			System.out.println(Horse.YELLOW+" spawn at (6, 14)");
		}
	}
	
	public void move(Horse horse, int dice) {
		int c=getCol(horse);
		int r=getRow(horse);
		if(c<0||r<0){
			System.out.println("Horse is not avaible");
			return;
		}
		for(int i=0;i<dice-1;i++) {
			boolean result= move(horse);
			if(result==false) {
				System.out.println(horse+" can't move");
				board[getRow(horse)][getCol(horse)]=null;
				board[r][c]=horse;
				return;
			}
		}
		c=getCol(horse);
		r=getRow(horse);
		if(horse==Horse.RED) {
			if((c==6&&((r<6)||(r>7&&r<14)))||(c==0&&r<8)||(c==7&&r<6)) {
				if(board[r+1][c] instanceof Horse)
					if(board[r+1][c]!=Horse.RED) {
						System.out.println(board[r+1][c]+" have been kicked at ("+(r+1)+", "+c+")");
					}
					else return;
				board[r+1][c]=horse;
				board[r][c]=null;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(c==8&&r==0)) {
				if(board[r][c-1] instanceof Horse)
					if(board[r][c-1]!=Horse.RED)
						System.out.println(board[r][c-1]+" have been kicked at ("+r+", "+(c-1)+")");
					else return;
				board[r][c-1]=horse;
				board[r][c]=null;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)) {
				if(board[r][c+1] instanceof Horse)
					if(board[r][c+1]!=Horse.RED)
						System.out.println(board[r][c+1]+" have been kicked at ("+r+", "+(c+1)+")");
					else return;
				board[r][c+1]=horse;
				board[r][c]=null;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)) {
				if(board[r-1][c] instanceof Horse)
					if(board[r-1][c]!=Horse.RED)
						System.out.println(board[r-1][c]+" have been kicked at ("+(r-1)+", "+c+")");
					else return;
				board[r-1][c]=horse;
				board[r][c]=null;
			}
		}
		if(horse==Horse.GREEN) {
			if((c==6&&((r<6)||(r>7&&r<14)))||(r==6&&c==0)) {
				if(board[r+1][c] instanceof Horse)
					if(board[r+1][c]!=Horse.GREEN)
						System.out.println(board[r+1][c]+" have been kicked at ("+(r+1)+", "+c+")");
					else return;
				board[r+1][c]=horse;
				board[r][c]=null;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)) {
				if(board[r][c-1] instanceof Horse)
					if(board[r][c-1]!=Horse.GREEN)
						System.out.println(board[r][c-1]+" have been kicked ("+(r)+", "+(c-1)+")");
					else return;
				board[r][c-1]=horse;
				board[r][c]=null;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)||r==7&&c<6) {
				if(board[r][c+1] instanceof Horse)
					if(board[r][c+1]!=Horse.GREEN)
						System.out.println(board[r][c+1]+" have been kicked at ("+r+", "+(c+1)+")");
					else return;
				board[r][c+1]=horse;
				board[r][c]=null;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)) {
				if(board[r-1][c] instanceof Horse)
					if(board[r-1][c]!=Horse.GREEN)
						System.out.println(board[r-1][c]+" have been kicked at ("+(r-1)+", "+c+")");
					else return;
				board[r-1][c]=horse;
				board[r][c]=null;
			}
		}
		if(horse==Horse.BLUE) {
			if((c==6&&((r<6)||(r>7&&r<14)))||(r<8&&c==0)) {
				if(board[r+1][c] instanceof Horse)
					if(board[r+1][c]!=Horse.BLUE)
						System.out.println(board[r+1][c]+" have been kicked at ("+(r+1)+", "+c+")");
					else return;
				board[r+1][c]=horse;
				board[r][c]=null;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)) {
				if(board[r][c-1] instanceof Horse)
					if(board[r][c-1]!=Horse.BLUE)
						System.out.println(board[r][c-1]+" have been kicked ("+(r)+", "+(c-1)+")");
					else return;
				board[r][c-1]=horse;
				board[r][c]=null;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c==6)) {
				if(board[r][c+1] instanceof Horse)
					if(board[r][c+1]!=Horse.BLUE)
						System.out.println(board[r][c+1]+" have been kicked at ("+r+", "+(c+1)+")");
					else return;
				board[r][c+1]=horse;
				board[r][c]=null;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)||(c==7&&r>8)) {
				if(board[r-1][c] instanceof Horse)
					if(board[r-1][c]!=Horse.BLUE)
						System.out.println(board[r-1][c]+" have been kicked at ("+(r-1)+", "+c+")");
					else return;
				board[r-1][c]=horse;
				board[r][c]=null;
			}
		}
		if(horse==Horse.YELLOW) {
			if((c==6&&((r<6)||(r>7&&r<14))||(c==0&&r<8))) {
				if(board[r+1][c] instanceof Horse)
					if(board[r+1][c]!=Horse.YELLOW)
						System.out.println(board[r+1][c]+" have been kicked at ("+(r+1)+", "+c+")");
					else return;
				board[r+1][c]=horse;
				board[r][c]=null;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)||r==7&&c>8) {
				if(board[r][c-1] instanceof Horse)
					if(board[r][c-1]!=Horse.YELLOW)
						System.out.println(board[r][c-1]+" have been kicked ("+(r)+", "+(c-1)+")");
					else return;
				board[r][c-1]=horse;
				board[r][c]=null;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)) {
				if(board[r][c+1] instanceof Horse)
					if(board[r][c+1]!=Horse.YELLOW)
						System.out.println(board[r][c+1]+" have been kicked at ("+r+", "+(c+1)+")");
					else return;
				board[r][c+1]=horse;
				board[r][c]=null;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(r==8&&c==14)) {
				if(board[r-1][c] instanceof Horse)
					if(board[r-1][c]!=Horse.YELLOW)
						System.out.println(board[r-1][c]+" have been kicke at ("+(r-1)+", "+c+")");
					else return;
				board[r-1][c]=horse;
				board[r][c]=null;
			}
		}
		System.out.println(horse+" move "+ dice+" step!");
	}
	
	public boolean move(Horse horse) {
		int c=getCol(horse);
		int r=getRow(horse);
		if(horse==Horse.RED) {
			if((c==6&&((r<6)||(r>7&&r<14)))||(c==0&&r<8)||(c==7&&r<6)) {
				if(board[r+1][c] instanceof Horse)
					return false;
				board[r+1][c]=horse;
				board[r][c]=null;
				return true;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(c==8&&r==0)) {
				if(board[r][c-1] instanceof Horse)
					return false;
				board[r][c-1]=horse;
				board[r][c]=null;
				return true;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)) {
				if(board[r][c+1] instanceof Horse)
					return false;
				board[r][c+1]=horse;
				board[r][c]=null;
				return true;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)) {
				if(board[r-1][c] instanceof Horse)
					return false;
				board[r-1][c]=horse;
				board[r][c]=null;
				return true;
			}
		}
		if(horse==Horse.GREEN) {
			if((c==6&&((r<6)||(r>7&&r<14)))||(r==6&&c==0)) {
				if(board[r+1][c] instanceof Horse)
					return false;
				board[r+1][c]=horse;
				board[r][c]=null;
				return true;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)) {
				if(board[r][c-1] instanceof Horse)
					return false;
				board[r][c-1]=horse;
				board[r][c]=null;
				return true;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)||r==7&&c<6) {
				if(board[r][c+1] instanceof Horse)
					return false;
				board[r][c+1]=horse;
				board[r][c]=null;
				return true;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)) {
				if(board[r-1][c] instanceof Horse)
					return false;
				board[r-1][c]=horse;
				board[r][c]=null;
				return true;
			}
		}
		if(horse==Horse.BLUE) {
			if((c==6&&((r<6)||(r>7&&r<14)))||(r<8&&c==0)) {
				if(board[r+1][c] instanceof Horse)
					return false;
				board[r+1][c]=horse;
				board[r][c]=null;
				return true;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)) {
				if(board[r][c-1] instanceof Horse)
					return false;
				board[r][c-1]=horse;
				board[r][c]=null;
				return true;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c==6)) {
				if(board[r][c+1] instanceof Horse)
					return false;
				board[r][c+1]=horse;
				board[r][c]=null;
				return true;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)||(c==7&&r>8)) {
				if(board[r-1][c] instanceof Horse)
					return false;
				board[r-1][c]=horse;
				board[r][c]=null;
				return true;
			}
		}
		if(horse==Horse.YELLOW) {
			if((c==6&&((r<6)||(r>7&&r<14))||(c==0&&r<8))) {
				if(board[r+1][c] instanceof Horse)
					return false;
				board[r+1][c]=horse;
				board[r][c]=null;
				return true;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)||r==7&&c>8) {
				if(board[r][c-1] instanceof Horse)
					return false;
				board[r][c-1]=horse;
				board[r][c]=null;
				return true;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)) {
				if(board[r][c+1] instanceof Horse)
					return false;
				board[r][c+1]=horse;
				board[r][c]=null;
				return true;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(r==8&&c==14)) {
				if(board[r-1][c] instanceof Horse)
					return false;
				board[r-1][c]=horse;
				board[r][c]=null;
				return true;
			}
		}
		throw new IllegalStateException("Should not be happen");
	}
	
	public boolean checkWin() {
		if(board[6][7]==Horse.RED) {
			System.out.println(Horse.RED+" is the winner!");
			return true;
		}
		if(board[7][6]==Horse.GREEN) {
			System.out.println(Horse.GREEN+" is the winner!");
			return true;
		}
		if(board[8][7]==Horse.BLUE) {
			System.out.println(Horse.BLUE+" is the winner!");
			return true;
		}
		if(board[7][8]==Horse.YELLOW) {
			System.out.println(Horse.YELLOW+" is the winner!");
			return true;
		}
		return false;
	}
	
	public int getRow(Horse horse){
		for(int c=0;c<15;c++) {
			for(int r=0;r<15;r++) {
				if(board[r][c]==(horse))
					return r;
			}
		}
		return -1;
	}
	
	public int getCol(Horse horse){
		for(int r=0;r<15;r++) {
			for(int c=0;c<15;c++) {
				if(board[r][c]==(horse))
					return c;
			}
		}
		return -1;
	}
	
	public int rollDice() {
		die1= ((int) (Math.random()*(7-1)))+1;
		die2= ((int) (Math.random()*(7-1)))+1;
		System.out.println(die1+", "+ die2);
		return die1+die2;
	}
	
	public String toString() {
		String result ="";
		for(int r=0;r<15;r++) {
			for(int c=0;c<15;c++) {
				if(board[r][c] instanceof Horse) {
					result+=board[r][c].toString()+" ";
				}
				else if((r!=0 && r!=14 && r!=7 && c==7)||(c!=0 && c!=14 && c!=7 && r==7))
					result+="* ";
				else if(((r==0||r==14)&&(c==6||c==7||c==8))||(c==0||c==14)&&(r==6||r==7||r==8))
					result+="o ";
				else if((r!=0&&r!=14&&r!=7&&(c==6||c==8))||(c!=0&&c!=14&&c!=7&&(r==6||r==8)))
					result+="o ";
				else if(r==7&&c==7)
					result+="W ";
				else
					result+="  ";
			}
			result+="\r";
		}
		return result;
	}
	
}
