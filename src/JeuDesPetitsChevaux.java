import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import javax.swing.JFrame;

public class JeuDesPetitsChevaux extends JFrame{
	private Board board = new Board();
	public static Queue<Horse> r = new LinkedList<>();
	public static Queue<Horse> g = new LinkedList<>();
	public static Queue<Horse> b = new LinkedList<>();
	public static Queue<Horse> y = new LinkedList<>();
	public static List<Horse> R = new LinkedList<>();
	public static List<Horse> G = new LinkedList<>();
	public static List<Horse> B = new LinkedList<>();
	public static List<Horse> Y = new LinkedList<>();
	private int dice1;
	private int dice2;
	private int turn;
	
	public JeuDesPetitsChevaux() {
		Horse r1 = new Horse(Color.RED);
		Horse r2 = new Horse(Color.RED);
		Horse r3 = new Horse(Color.RED);
		Horse r4 = new Horse(Color.RED);
		Horse g1 = new Horse(Color.GREEN);
		Horse g2 = new Horse(Color.GREEN);
		Horse g3 = new Horse(Color.GREEN);
		Horse g4 = new Horse(Color.GREEN);
		Horse b1 = new Horse(Color.BLUE);
		Horse b2 = new Horse(Color.BLUE);
		Horse b3 = new Horse(Color.BLUE);
		Horse b4 = new Horse(Color.BLUE);
		Horse y1 = new Horse(Color.YELLOW);
		Horse y2 = new Horse(Color.YELLOW);
		Horse y3 = new Horse(Color.YELLOW);
		Horse y4 = new Horse(Color.YELLOW);
		r.add(r1);
		r.add(r2);
		r.add(r3);
		r.add(r4);
		g.add(g1);
		g.add(g2);
		g.add(g3);
		g.add(g4);
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
		y.add(y1);
		y.add(y2);
		y.add(y3);
		y.add(y4);
		turn =0;
		System.out.println(board);
		while(!board.checkWin()) {
			System.out.println("It's "+getTurn()+" turn!");
			if(getTurn()==Color.RED) {
				rollDice();
				if(dice1==dice2) {
					if((r.size()>0&&(board.getHorse(0, 6) instanceof Horse)&&board.getHorse(0, 6).getColor()==Color.RED)||r.size()==0) {
						//choose 1 horse from R to move
						for(Horse h:R) {
							if(h.getRow()<7&&h.getRow()>0&&h.getCol()==7) {
								if(!board.moveInStack(h, dice1, dice2))
									continue;
								else 
									break;
							}
							if(!board.move(h,(dice1+dice2))) 
								continue;
							break;
						}
					}
					if(r.size()>0) {
						if(board.getHorse(0, 6)==null) {
							board.add(r.remove());
							R.add(board.getHorse(0, 6));
						}
						if(board.getHorse(0, 6).getColor()==Color.GREEN) {
							G.remove(board.getHorse(0, 6));
							g.add(board.getHorse(0, 6));
							board.add(r.remove());
							R.add(board.getHorse(0, 6));
						}
						if(board.getHorse(0, 6).getColor()==Color.BLUE) {
							B.remove(board.getHorse(0, 6));
							b.add(board.getHorse(0, 6));
							board.add(r.remove());
							R.add(board.getHorse(0, 6));
						}
						if(board.getHorse(0, 6).getColor()==Color.YELLOW) {
							Y.remove(board.getHorse(0, 6));
							y.add(board.getHorse(0, 6));
							board.add(r.remove());
							R.add(board.getHorse(0, 6));
						}
						
					}
					
					turn--;
				}
				if(dice1!=dice2) {
					//choose 1 horse from R to move
					for(Horse h:R) {
						if(h.getRow()>0&&h.getRow()<7&&h.getCol()==7) {
							if(board.moveInStack(h, dice1, dice2))
								break;
							else
								continue;
						}
						if(!board.move(h,(dice1+dice2))) {
							continue;
						} else
							break;
					}
				}
			}
			else if(getTurn()==Color.GREEN) {
					rollDice();
					if(dice1==dice2) {
						if((g.size()>0&&(board.getHorse(8, 0) instanceof Horse)&&board.getHorse(8, 0).getColor()==Color.GREEN)||g.size()==0) {
							//choose 1 horse from R to move
							for(Horse h:G) {
								if(h.getRow()==7&&h.getCol()<7&&h.getCol()>0) {
									if(board.moveInStack(h, dice1, dice2))
										break;
									else
										continue;
								}
								if(!board.move(h,(dice1+dice2))) {
									continue;
								} else
									break;
							}
						}
						if(g.size()>0) {
							if(board.getHorse(8, 0)==null) {
								board.add(g.remove());
								G.add(board.getHorse(8, 0));
							}
							if(board.getHorse(8, 0).getColor()==Color.RED) {
								R.remove(board.getHorse(8, 0));
								r.add(board.getHorse(8, 0));
								board.add(g.remove());
								G.add(board.getHorse(8, 0));
							}
							if(board.getHorse(8, 0).getColor()==Color.BLUE) {
								B.remove(board.getHorse(8, 0));
								b.add(board.getHorse(8, 0));
								board.add(g.remove());
								G.add(board.getHorse(8, 0));
							}
							if(board.getHorse(8, 0).getColor()==Color.YELLOW) {
								Y.remove(board.getHorse(8, 0));
								y.add(board.getHorse(8, 0));
								board.add(g.remove());
								G.add(board.getHorse(8, 0));
							}
							
						}
						
						turn--;
					}
					if(dice1!=dice2) {
							//choose 1 horse from R to move
						for(Horse h:G) {
							if(h.getRow()==7&&h.getCol()<7&&h.getCol()>0) {
								if(board.moveInStack(h, dice1, dice2))
									break;
								else
									continue;
							}
							if(!board.move(h,(dice1+dice2))) {
								continue;
							} else
								break;
						}
					}
			}
			else if(getTurn()==Color.BLUE) {
					rollDice();
					if(dice1==dice2) {
						if((b.size()>0&&(board.getHorse(14, 8) instanceof Horse)&&board.getHorse(14, 8).getColor()==Color.BLUE)||b.size()==0) {
							//choose 1 horse from B to move
							for(Horse h:B) {
								if(h.getRow()>7&&h.getRow()<14&&h.getCol()==7) {
									board.moveInStack(h, dice1, dice2);
									break;
								}
								if(!board.move(h,(dice1+dice2))) {
									continue;
								} else
									break;
							}
						}
						if(b.size()>0) {
							if(board.getHorse(14, 8)==null) {
								board.add(b.remove());
								B.add(board.getHorse(14, 8));
							}
							if(board.getHorse(14, 8).getColor()==Color.RED) {
								R.remove(board.getHorse(14, 8));
								r.add(board.getHorse(14, 8));
								board.add(b.remove());
								B.add(board.getHorse(14, 8));
							}
							if(board.getHorse(14, 8).getColor()==Color.GREEN) {
								G.remove(board.getHorse(14, 8));
								g.add(board.getHorse(14, 8));
								board.add(b.remove());
								B.add(board.getHorse(14, 8));
							}
							if(board.getHorse(14, 8).getColor()==Color.YELLOW) {
								Y.remove(board.getHorse(14, 8));
								y.add(board.getHorse(14, 8));
								board.add(g.remove());
								B.add(board.getHorse(14, 8));
							}
							
						}
						
						turn--;
					}
					if(dice1!=dice2) {
							//choose 1 horse from B to move
						for(Horse h:B) {
							if(h.getRow()>7&&h.getRow()<14&&h.getCol()==7) {
								if(board.moveInStack(h, dice1, dice2))
									break;
								else
									continue;
							}
							if(!board.move(h,(dice1+dice2))) {
								continue;
							} else
								break;
						}
					}
			}
			else if(getTurn()==Color.YELLOW) {
					rollDice();
					if(dice1==dice2) {
						if((y.size()>0&&(board.getHorse(6,14) instanceof Horse)&&board.getHorse(6, 14).getColor()==Color.YELLOW)||y.size()==0) {
							//choose 1 horse from R to move
							for(Horse h:Y) {
								if(h.getCol()>7&&h.getCol()<14&&h.getRow()==7) {
									if(board.moveInStack(h, dice1, dice2))
										break;
									else
										continue;
								}
								if(!board.move(h,(dice1+dice2))) {
									continue;
								} else
									break;
							}
						}
						if(y.size()>0) {
							if(board.getHorse(6, 14)==null) {
								board.add(y.remove());
								Y.add(board.getHorse(6, 14));
							}
							if(board.getHorse(6, 14).getColor()==Color.RED) {
								R.remove(board.getHorse(6, 14));
								r.add(board.getHorse(6, 14));
								board.add(y.remove());
								Y.add(board.getHorse(6, 14));
							}
							if(board.getHorse(6, 14).getColor()==Color.BLUE) {
								B.remove(board.getHorse(6, 14));
								b.add(board.getHorse(6, 14));
								board.add(y.remove());
								Y.add(board.getHorse(6, 14));
							}
							if(board.getHorse(6, 14).getColor()==Color.GREEN) {
								G.remove(board.getHorse(6, 14));
								g.add(board.getHorse(6, 14));
								board.add(y.remove());
								Y.add(board.getHorse(6, 14));
							}
							if(board.getHorse(6, 14)==null) {
								board.add(y.remove());
								Y.add(board.getHorse(6, 14));
							}
						}
						
						turn--;
					}
					if(dice1!=dice2) {
							//choose 1 horse from R to move
						for(Horse h:Y) {
							if(h.getCol()>7&&h.getCol()<14&&h.getRow()==7) {
								if(board.moveInStack(h, dice1, dice2))
									break;
								else
									continue;
							}
							if(!board.move(h,(dice1+dice2))) {
								continue;
							} else
								break;
						}
					}
				}
			System.out.println(board);
			turn++;
		}
		
	}
	
	public Color getTurn() {
		if(turn%4==0) {
			return Color.RED;
		}
		if(turn%4==1) {
			return Color.GREEN;
		}
		if(turn%4==2) {
			return Color.BLUE;
		}
		if(turn%4==3) {
			return Color.YELLOW;
		}
		throw new IllegalStateException("This should not happen");
	}

	
	public int rollDice() {
		Random roll = new Random();
		dice1 = roll.nextInt(6)+1;
		dice2 = roll.nextInt(6)+2;
		System.out.println("Rolled ("+dice1+" "+dice2+")");
		return dice1+dice2;
	}
	//TODO: add rolldice, and add/remove horse from the queue if horse is added or got kicked
}
