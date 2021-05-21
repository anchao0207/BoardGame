import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JPanel;

public class Board extends JPanel{
	private static Horse[][] board = new Horse[15][15];
//	public int die1;
//	public int die2;
	Queue<Horse> r = new LinkedList<>();
	Queue<Horse> g = new LinkedList<>();
	Queue<Horse> b = new LinkedList<>();
	Queue<Horse> y = new LinkedList<>();
//	int blueHorses;
//	int redHorses;
//	int greenHorses;
//	int yellowHorses;
	public Board() {
		
	}
	
	public void add(Color color) {
		if(color==Color.RED) {
			if(r.size()>0) {
				if(board[0][6] instanceof Horse &&board[0][6].getColor()!=Color.RED) {
					System.out.println(board[0][6]+" have been kicked");
					if(board[0][6].getColor()==Color.GREEN) 
						g.add(board[0][6]);
					if(board[0][6].getColor()==Color.BLUE) 
						b.add(board[0][6]);
					if(board[0][6].getColor()==Color.YELLOW) 
						y.add(board[0][6]);
				}
				if(board[0][6] instanceof Horse &&board[0][6].getColor()==Color.RED)
					return;
				board[0][6]=r.remove();
				board[0][6].setCoordinate(0, 6);
				System.out.println(color+" spawn at (0, 6)");
			}
		}
		if(color==Color.GREEN) {
			if(g.size()>0) {
				if(board[8][0] instanceof Horse&&board[8][0].getColor()!=Color.GREEN) {
					System.out.println(board[8][0]+" have been kicked");
					if(board[8][0].getColor()==Color.RED) 
						r.add(board[8][0]);
					if(board[8][0].getColor()==Color.BLUE) 
						b.add(board[8][0]);
					if(board[8][0].getColor()==Color.YELLOW) 
						y.add(board[8][0]);
				}
				if(board[8][0] instanceof Horse&&board[8][0].getColor()==Color.GREEN)
					return;
				board[8][0]=g.remove();
				board[8][0].setCoordinate(8, 0);
				System.out.println(color+" spawn at (8, 0)");
			}
		}
		if(color==Color.BLUE) {
			if(b.size()>0) {
				if(board[14][8] instanceof Horse&&board[14][8].getColor()!=Color.BLUE) {
					System.out.println(board[14][8]+" have been kicked");
					if(board[14][8].getColor()==Color.RED) 
						r.add(board[8][0]);
					if(board[14][8].getColor()==Color.GREEN) 
						g.add(board[8][0]);
					if(board[14][8].getColor()==Color.YELLOW) 
						y.add(board[8][0]);
				}
				if(board[14][8] instanceof Horse&&board[14][8].getColor()==Color.BLUE)
					return;
				board[14][8]=b.remove();
				board[14][8].setCoordinate(14, 8);
				System.out.println(color+" spawn at (14, 8)");
			}
		}
		if(color==Color.YELLOW) {
			if(y.size()>0) {
				if(board[6][14] instanceof Horse&&board[6][14].getColor()!=Color.YELLOW) {
					System.out.println(board[6][14]+" have been kicked");
					if(board[6][14].getColor()==Color.RED) 
						r.add(board[6][14]);
					if(board[6][14].getColor()==Color.GREEN) 
						g.add(board[6][14]);
					if(board[6][14].getColor()==Color.BLUE) 
						b.add(board[6][14]);
				}
				if(board[6][14] instanceof Horse&&board[6][14].getColor()==Color.YELLOW)
					return;
				board[6][14]=y.remove();
				System.out.println(color+" spawn at (6, 14)");
			}
		}
	}
	
	public void move(Horse horse, int dice) {
		int Or= horse.getRow();
		int Oc=horse.getCol();
		
		if(board[Or][Oc] instanceof Horse){
			if(board[Or][Oc].getColor()!=horse.getColor())
				throw new IllegalStateException("Not your horses!");
			for(int i=0;i<dice-1;i++) {
				boolean result= move(horse);
				if(result==false) {
					System.out.println(horse+" can't move");
					board[horse.getRow()][horse.getCol()]=null;
					board[Or][Oc]=horse;
					horse.setCoordinate(Or, Oc);
					return;
				}
			}
			int r=horse.getRow();
			int c=horse.getCol();
			if(horse.getColor()==Color.RED) {
				if((c==6&&((r<6)||(r>7&&r<14)))||(c==0&&r<8)||(c==7&&r<6)) {
					if(board[r+1][c] instanceof Horse)
						if(board[r+1][c].getColor()!=Color.RED) {
							System.out.println(board[r+1][c]+" have been kicked at ("+(r+1)+", "+c+")");
						}
						else {
							System.out.println(horse+" can't move");
							board[r][c]=null;
							board[Or][Oc]=horse;
							horse.setCoordinate(Or, Oc);
							return;
						}
					board[r+1][c]=horse;
					horse.setCoordinate(r+1, c);
					board[r][c]=null;
				}
				if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(c==8&&r==0)) {
					if(board[r][c-1] instanceof Horse)
						if(board[r][c-1].getColor()!=Color.RED)
							System.out.println(board[r][c-1]+" have been kicked at ("+r+", "+(c-1)+")");
						else {
							System.out.println(horse+" can't move");
							board[r][c]=null;
							board[Or][Oc]=horse;
							horse.setCoordinate(Or, Oc);
							return;
						}
					board[r][c-1]=horse;
					horse.setCoordinate(r, c-1);
					board[r][c]=null;
				}
				
				if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)) {
					if(board[r][c+1] instanceof Horse)
						if(board[r][c+1].getColor()!=Color.RED)
							System.out.println(board[r][c+1]+" have been kicked at ("+r+", "+(c+1)+")");
						else {
							System.out.println(horse+" can't move");
							board[r][c]=null;
							board[Or][Oc]=horse;
							horse.setCoordinate(Or, Oc);
							return;
						}
					board[r][c+1]=horse;
					horse.setCoordinate(r, c+1);
					board[r][c]=null;
				}
				if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)) {
					if(board[r-1][c] instanceof Horse)
						if(board[r-1][c].getColor()!=Color.RED)
							System.out.println(board[r-1][c]+" have been kicked at ("+(r-1)+", "+c+")");
						else {
							System.out.println(horse+" can't move");
							board[r][c]=null;
							board[Or][Oc]=horse;
							horse.setCoordinate(Or, Oc);
							return;
						}
					board[r-1][c]=horse;
					horse.setCoordinate(r-1, c);
					board[r][c]=null;
				}
				if(horse.getColor()==Color.GREEN) {
					if((c==6&&((r<6)||(r>7&&r<14)))||(r==6&&c==0)) {
						if(board[r+1][c] instanceof Horse)
							if(board[r+1][c].getColor()!=Color.GREEN) {
								System.out.println(board[r+1][c]+" have been kicked at ("+(r+1)+", "+c+")");
							} else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r+1][c]=horse;
						horse.setCoordinate(r+1, c);
						board[r][c]=null;
					}
					if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)) {
						if(board[r][c-1] instanceof Horse)
							if(board[r][c-1].getColor()!=Color.GREEN)
								System.out.println(board[r][c-1]+" have been kicked at ("+r+", "+(c-1)+")");
							else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r][c-1]=horse;
						horse.setCoordinate(r, c-1);
						board[r][c]=null;
					}
					
					if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)||r==7&&c<6) {
						if(board[r][c+1] instanceof Horse)
							if(board[r][c+1].getColor()!=Color.GREEN)
								System.out.println(board[r][c+1]+" have been kicked at ("+r+", "+(c+1)+")");
							else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r][c+1]=horse;
						horse.setCoordinate(r, c+1);
						board[r][c]=null;
					}
					if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)) {
						if(board[r-1][c] instanceof Horse)
							if(board[r-1][c].getColor()!=Color.GREEN)
								System.out.println(board[r-1][c]+" have been kicked at ("+(r-1)+", "+c+")");
							else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r-1][c]=horse;
						horse.setCoordinate(r-1, c);
						board[r][c]=null;
					}
				}
				if(horse.getColor()==Color.BLUE) {
					if((c==6&&((r<6)||(r>7&&r<14)))||(r<8&&c==0)) {
						if(board[r+1][c] instanceof Horse)
							if(board[r+1][c].getColor()!=Color.BLUE) {
								System.out.println(board[r+1][c]+" have been kicked at ("+(r+1)+", "+c+")");
							} else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r+1][c]=horse;
						horse.setCoordinate(r+1, c);
						board[r][c]=null;
					}
					if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)) {
						if(board[r][c-1] instanceof Horse)
							if(board[r][c-1].getColor()!=Color.BLUE)
								System.out.println(board[r][c-1]+" have been kicked at ("+r+", "+(c-1)+")");
							else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r][c-1]=horse;
						horse.setCoordinate(r, c-1);
						board[r][c]=null;
					}
					
					if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c==6)) {
						if(board[r][c+1] instanceof Horse)
							if(board[r][c+1].getColor()!=Color.BLUE)
								System.out.println(board[r][c+1]+" have been kicked at ("+r+", "+(c+1)+")");
							else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r][c+1]=horse;
						horse.setCoordinate(r, c+1);
						board[r][c]=null;
					}
					if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)||(c==7&&r>8)) {
						if(board[r-1][c] instanceof Horse)
							if(board[r-1][c].getColor()!=Color.BLUE)
								System.out.println(board[r-1][c]+" have been kicked at ("+(r-1)+", "+c+")");
							else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r-1][c]=horse;
						horse.setCoordinate(r-1, c);
						board[r][c]=null;
					}
				}
				if(horse.getColor()==Color.YELLOW) {
					if((c==6&&((r<6)||(r>7&&r<14))||(c==0&&r<8))) {
						if(board[r+1][c] instanceof Horse)
							if(board[r+1][c].getColor()!=Color.YELLOW) {
								System.out.println(board[r+1][c]+" have been kicked at ("+(r+1)+", "+c+")");
							} else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r+1][c]=horse;
						horse.setCoordinate(r+1, c);
						board[r][c]=null;
					}
					if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)||r==7&&c>8) {
						if(board[r][c-1] instanceof Horse)
							if(board[r][c-1].getColor()!=Color.YELLOW)
								System.out.println(board[r][c-1]+" have been kicked at ("+r+", "+(c-1)+")");
							else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r][c-1]=horse;
						horse.setCoordinate(r, c-1);
						board[r][c]=null;
					}
					
					if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)) {
						if(board[r][c+1] instanceof Horse)
							if(board[r][c+1].getColor()!=Color.YELLOW)
								System.out.println(board[r][c+1]+" have been kicked at ("+r+", "+(c+1)+")");
							else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r][c+1]=horse;
						horse.setCoordinate(r, c+1);
						board[r][c]=null;
					}
					if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(r==8&&c==14)) {
						if(board[r-1][c] instanceof Horse)
							if(board[r-1][c].getColor()!=Color.YELLOW)
								System.out.println(board[r-1][c]+" have been kicked at ("+(r-1)+", "+c+")");
							else {
								System.out.println(horse+" can't move");
								board[r][c]=null;
								board[Or][Oc]=horse;
								horse.setCoordinate(Or, Oc);
								return;
							}
						board[r-1][c]=horse;
						horse.setCoordinate(r-1, c);
						board[r][c]=null;
					}
				}
			
			}
			System.out.println(horse+" move "+ dice+" step!");
		} else
			throw new IllegalStateException("Not a horse");
	}
	
	public void moveInStack(Horse horse, int dice1, int dice2) {
		int r=horse.getRow();
		if(dice1==dice2)
			move(horse);
		if(dice1+dice2==r+1) {
			move(horse);
		}
	}
	
	public boolean move(Horse horse) {
		int c=horse.getCol();
		int r=horse.getRow();
		if(horse.getColor()==Color.RED) {
			if((c==6&&((r<6)||(r>7&&r<14)))||(c==0&&r<8)||(c==7&&r<6)) {
				if(board[r+1][c] instanceof Horse)
					return false;
				board[r+1][c]=horse;
				horse.setCoordinate(r+1, c);
				board[r][c]=null;
				return true;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(c==8&&r==0)) {
				if(board[r][c-1] instanceof Horse)
					return false;
				board[r][c-1]=horse;
				horse.setCoordinate(r, c-1);
				board[r][c]=null;
				return true;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)) {
				if(board[r][c+1] instanceof Horse)
					return false;
				board[r][c+1]=horse;
				horse.setCoordinate(r,c+1);
				board[r][c]=null;
				return true;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)) {
				if(board[r-1][c] instanceof Horse)
					return false;
				board[r-1][c]=horse;
				horse.setCoordinate(r-1, c);
				board[r][c]=null;
				return true;
			}
		}
		if(horse.getColor()==Color.GREEN) {
			if((c==6&&((r<6)||(r>7&&r<14)))||(r==6&&c==0)) {
				if(board[r+1][c] instanceof Horse)
					return false;
				board[r+1][c]=horse;
				horse.setCoordinate(r+1, c);
				board[r][c]=null;
				return true;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)) {
				if(board[r][c-1] instanceof Horse)
					return false;
				board[r][c-1]=horse;
				horse.setCoordinate(r, c-1);
				board[r][c]=null;
				return true;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)||r==7&&c<6) {
				if(board[r][c+1] instanceof Horse)
					return false;
				board[r][c+1]=horse;
				horse.setCoordinate(r, c+1);
				board[r][c]=null;
				return true;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)) {
				if(board[r-1][c] instanceof Horse)
					return false;
				board[r-1][c]=horse;
				horse.setCoordinate(r-1, c);
				board[r][c]=null;
				return true;
			}
		}
		if(horse.getColor()==Color.BLUE) {
			if((c==6&&((r<6)||(r>7&&r<14)))||(r<8&&c==0)) {
				if(board[r+1][c] instanceof Horse)
					return false;
				board[r+1][c]=horse;
				horse.setCoordinate(r+1, c);
				board[r][c]=null;
				return true;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)) {
				if(board[r][c-1] instanceof Horse)
					return false;
				board[r][c-1]=horse;
				horse.setCoordinate(r, c-1);
				board[r][c]=null;
				return true;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c==6)) {
				if(board[r][c+1] instanceof Horse)
					return false;
				board[r][c+1]=horse;
				horse.setCoordinate(r, c+1);
				board[r][c]=null;
				return true;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(c==14&&r>6)||(c==7&&r>8)) {
				if(board[r-1][c] instanceof Horse)
					return false;
				board[r-1][c]=horse;
				horse.setCoordinate(r-1, c);
				board[r][c]=null;
				return true;
			}
		}
		if(horse.getColor()==Color.YELLOW) {
			if((c==6&&((r<6)||(r>7&&r<14))||(c==0&&r<8))) {
				if(board[r+1][c] instanceof Horse)
					return false;
				board[r+1][c]=horse;
				horse.setCoordinate(r+1, c);
				board[r][c]=null;
				return true;
			}
			if((((c<7&&c>0)||(c>8&&c<15))&&r==6)||(r==0&&c>6)||r==7&&c>8) {
				if(board[r][c-1] instanceof Horse)
					return false;
				board[r][c-1]=horse;
				horse.setCoordinate(r, c-1);
				board[r][c]=null;
				return true;
			}
			
			if(((c<6||(c>7&&c<14))&&r==8)||(r==14&&c<8)) {
				if(board[r][c+1] instanceof Horse)
					return false;
				board[r][c+1]=horse;
				horse.setCoordinate(r, c+1);
				board[r][c]=null;
				return true;
			}
			if((c==8&&((r<15&&r>8)||(r>0&&r<7)))||(r==8&&c==14)) {
				if(board[r-1][c] instanceof Horse)
					return false;
				board[r-1][c]=horse;
				horse.setCoordinate(r-1, c);
				board[r][c]=null;
				return true;
			}
		}
		throw new IllegalStateException("Not a horse");
	}
	
	public boolean checkWin() {
		if(board[6][7] instanceof Horse&&board[5][7] instanceof Horse&&board[4][7] instanceof Horse&& board[3][7] instanceof Horse) {
			System.out.println("Red is the winner!");
			return true;
		}
		if(board[7][3] instanceof Horse&&board[7][4] instanceof Horse&&board[7][5] instanceof Horse&& board[7][6] instanceof Horse) {
			System.out.println("Green is the winner!");
			return true;
		}
		if(board[8][7] instanceof Horse&&board[9][7] instanceof Horse&&board[10][7] instanceof Horse&& board[11][7] instanceof Horse) {
			System.out.println("Blue is the winner!");
			return true;
		}
		if(board[7][8] instanceof Horse&&board[7][9] instanceof Horse&&board[7][10] instanceof Horse&& board[7][11] instanceof Horse) {
			System.out.println("Yellow is the winner!");
			return true;
		}
		return false;
	}
	
//	public int rollDice() {
//		die1= ((int) (Math.random()*(7-1)))+1;
//		die2= ((int) (Math.random()*(7-1)))+1;
//		System.out.println(die1+", "+ die2);
//		return die1+die2;
//	}
	
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
