//import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	private Horse horse;
	private int step;
	
	// to make warning go away
	private static final long serialVersionUID = 1L;
	
	// GUI stuff
	protected final int MARGIN_SIZE = 5;
    protected final int DOUBLE_MARGIN_SIZE = MARGIN_SIZE*2;
    protected int squareSize = 25;
    private int numRows = 15;
    private int numCols = 15;
    
    private int width = DOUBLE_MARGIN_SIZE + squareSize * numCols;    		
    private int height = DOUBLE_MARGIN_SIZE + squareSize * numRows;    		
    
    private JPanel canvas;
    
    private void drawHorse(int r, int c) {
    	
    }
    
    private void drawGrid(Graphics2D g) {
    	// TODO: refactor the copy-paste
    	int mid = numRows/2;
        for (int r = mid-1; r <= mid+1; r++) {
            for (int c = 0; c < numCols; c++) {
            	int x = c * squareSize + MARGIN_SIZE;
            	int y = r * squareSize + MARGIN_SIZE;
            	
                // TODO: draw horses from the board
            	Horse horse = board.getHorse(r, c);
            	if (horse != null) {
            		g.setColor(horse.getColor().toColor());
            		g.fillOval(x, y, squareSize, squareSize);
            	} else {
            		g.setColor(getBackground());
            		g.fillOval(x, y, squareSize, squareSize);
            	}
            	if(((c>0&&c<7)||(c>7&&c<14))&&r==7) {
            		g.setColor(java.awt.Color.BLACK);
            		g.drawOval(x, y, squareSize, squareSize);
            	} else {
            		g.setColor(java.awt.Color.BLACK);
                	g.drawRect(x, y, squareSize, squareSize); 
            	}
            }
        }
        
        for (int r = 0; r < numRows; r++) {
            for (int c = mid-1; c <= mid+1; c++) {
            	int x = c * squareSize + MARGIN_SIZE;
            	int y = r * squareSize + MARGIN_SIZE;
            	
                // TODO: draw horses from the board
            	Horse horse = board.getHorse(r, c);
            	if (horse != null) {
            		g.setColor(horse.getColor().toColor());
            		g.fillOval(x, y, squareSize, squareSize);
            	} else {
            		g.setColor(getBackground());
            		g.fillOval(x, y, squareSize, squareSize);
            	}
            	if(((r>0&&r<7)||(r>7&&r<14))&&c==7) {
            		g.setColor(java.awt.Color.BLACK);
            		g.drawOval(x, y, squareSize, squareSize);
            	} else {
            		g.setColor(java.awt.Color.BLACK);
                	g.drawRect(x, y, squareSize, squareSize); 
            	}
            }
        }
        
        
        
    }
	
	public JeuDesPetitsChevaux() {
		Horse r1 = new Horse(Color.RED,1);
		Horse r2 = new Horse(Color.RED,2);
		Horse r3 = new Horse(Color.RED,3);
		Horse r4 = new Horse(Color.RED,4);
		Horse g1 = new Horse(Color.GREEN,1);
		Horse g2 = new Horse(Color.GREEN,2);
		Horse g3 = new Horse(Color.GREEN,3);
		Horse g4 = new Horse(Color.GREEN,4);
		Horse b1 = new Horse(Color.BLUE,1);
		Horse b2 = new Horse(Color.BLUE,2);
		Horse b3 = new Horse(Color.BLUE,3);
		Horse b4 = new Horse(Color.BLUE,4);
		Horse y1 = new Horse(Color.YELLOW,1);
		Horse y2 = new Horse(Color.YELLOW,2);
		Horse y3 = new Horse(Color.YELLOW,3);
		Horse y4 = new Horse(Color.YELLOW,4);
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
		
		JFrame frame = this;
		
		canvas = new JPanel() {
			/* (non-Javadoc)
             * @see javax.swing.JComponent#getMinimumSize()
             */
            public Dimension getMinimumSize() {
                return new Dimension(width, height);
            }
            
            /* (non-Javadoc)
             * @see javax.swing.JComponent#getMaximumSize()
             */
            public Dimension getMaximumSize() {
                return new Dimension(width, height);
            }
            
            /* (non-Javadoc)
             * @see javax.swing.JComponent#getPreferredSize()
             */
            public Dimension getPreferredSize() {
                return new Dimension(width, height);
            }
            
            /* (non-Javadoc)
             * @see java.awt.Component#isFocusable()
             */
            public boolean isFocusable() {
                return true;
            }

			@Override
        	public void paint(Graphics graphics) {
        		Graphics2D g = (Graphics2D)graphics;

        		drawGrid(g);

        		//frame.setPreferredSize(new Dimension(numRows*squareSize + MARGIN_SIZE, numCols*squareSize + MARGIN_SIZE));
        		setPreferredSize(new Dimension((numCols+2)*squareSize + 2*MARGIN_SIZE, (numRows+2)*squareSize + 2*MARGIN_SIZE));
        		frame.pack();
        	}
		};
		
		this.getContentPane().add(canvas, BorderLayout.CENTER);
        this.setResizable(false);
        this.pack();
        this.setLocation(100,100);
        this.setFocusable(true);
	}
	
	public void play() {
		System.out.println(board);
		while(!board.checkWin()) {
			System.out.println("It's "+getTurn()+" turn!");
			if(getTurn()==Color.RED) {
				rollDice();
				if(dice1==dice2) {
					if(r.size()>0&&(board.getHorse(0, 6) instanceof Horse)){
						if(board.getHorse(0, 6).getColor()==Color.RED) {
							System.out.println("Can't spawn horse!");
						}
						if(board.getHorse(0, 6).getColor()==Color.GREEN) {
							G.remove(board.getHorse(0, 6));
							g.add(board.getHorse(0, 6));
							board.add(r.remove());
							R.add(board.getHorse(0, 6));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
						if(board.getHorse(0, 6).getColor()==Color.BLUE) {
							B.remove(board.getHorse(0, 6));
							b.add(board.getHorse(0, 6));
							board.add(r.remove());
							R.add(board.getHorse(0, 6));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
						if(board.getHorse(0, 6).getColor()==Color.YELLOW) {
							Y.remove(board.getHorse(0, 6));
							y.add(board.getHorse(0, 6));
							board.add(r.remove());
							R.add(board.getHorse(0, 6));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
					} else if(r.size()>0) {
						board.add(r.remove());
						R.add(board.getHorse(0, 6));
						System.out.println(board);
						canvas.repaint();
						continue;
					}
					if(r.size()==0||((board.getHorse(0, 6) instanceof Horse))&&board.getHorse(0, 6).getColor()==Color.RED) {
						
						Horse[] horseOptions = new Horse[R.size()];
						int i=0;
						for(Horse h:R) {
							horseOptions[i]=h;
							i++;
						}
						Horse h = (Horse) JOptionPane.showInputDialog(null,
								"Which Horse?", "Horse",
								JOptionPane.QUESTION_MESSAGE, null, horseOptions, horseOptions[0]);
						if(h==null) {
							System.exit(0);
						} else {
							horse = h;
						}
						
						if(horse.getRow()<7&&h.getRow()>0&&horse.getCol()==7) {
							board.moveInStack(horse, dice1, dice2);
							canvas.repaint();
						} else {
							String[] moveOptions = {""+dice1,""+(dice1+dice2)};
							String x = (String) JOptionPane.showInputDialog(null,
									"How Many Moves? ("+dice1+" or "+(dice1+dice2)+")", "Move",
									JOptionPane.QUESTION_MESSAGE, null, moveOptions, moveOptions[0]);
							if (x == null) {
								System.exit(0);
							} else {
								step = Integer.parseInt(x);
							}
							
							
							board.move(horse,step);
							canvas.repaint();
						}	
					}
					turn--;
				}
				if(dice1!=dice2) {
					if(R.size()==0) {
						turn++;
						continue;
					}
					Horse[] horseOptions = new Horse[R.size()];
					int i=0;
					for(Horse h:R) {
						horseOptions[i]=h;
						i++;
					}
					Horse h = (Horse) JOptionPane.showInputDialog(null,
							"Which Horse?", "Horse",
							JOptionPane.QUESTION_MESSAGE, null, horseOptions, horseOptions[0]);
					if(h==null) {
						turn++;
						System.out.println(board);
						canvas.repaint();
						continue;
					} else {
						horse = h;
					}
						if(horse.getRow()>0&&h.getRow()<7&&h.getCol()==7) {
							board.moveInStack(horse, dice1, dice2);
						} else {
							board.move(horse,(dice1+dice2));
							canvas.repaint();
						}
				}
			}
			else if(getTurn()==Color.GREEN) {
				rollDice();
				if(dice1==dice2) {
					if(g.size()>0&&(board.getHorse(8, 0) instanceof Horse)){
						if(board.getHorse(8, 0).getColor()==Color.GREEN) {
							System.out.println("Can't spawn horse!");
						}
						if(board.getHorse(8, 0).getColor()==Color.RED) {
							R.remove(board.getHorse(8, 0));
							r.add(board.getHorse(8, 0));
							board.add(g.remove());
							G.add(board.getHorse(8, 0));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
						if(board.getHorse(8, 0).getColor()==Color.BLUE) {
							B.remove(board.getHorse(8, 0));
							b.add(board.getHorse(8, 0));
							board.add(g.remove());
							G.add(board.getHorse(8, 0));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
						if(board.getHorse(8, 0).getColor()==Color.YELLOW) {
							Y.remove(board.getHorse(8, 0));
							y.add(board.getHorse(8, 0));
							board.add(g.remove());
							G.add(board.getHorse(8, 0));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
					} else if(g.size()>0) {
						board.add(g.remove());
						G.add(board.getHorse(8, 0));
						System.out.println(board);
						canvas.repaint();
						continue;
					}
					if(g.size()==0||((board.getHorse(8, 0) instanceof Horse))&&board.getHorse(8, 0).getColor()==Color.GREEN) {
						
						Horse[] horseOptions = new Horse[G.size()];
						int i=0;
						for(Horse h:G) {
							horseOptions[i]=h;
							i++;
						}
						Horse h = (Horse) JOptionPane.showInputDialog(null,
								"Which Horse?", "Horse",
								JOptionPane.QUESTION_MESSAGE, null, horseOptions, horseOptions[0]);
						if(h==null) {
							System.exit(0);
						} else {
							horse = h;
						}
						
						if(horse.getCol()<7&&h.getCol()>0&&horse.getRow()==7) {
							board.moveInStack(horse, dice1, dice2);
							canvas.repaint();
						} else {
							String[] moveOptions = {""+dice1,""+(dice1+dice2)};
							String x = (String) JOptionPane.showInputDialog(null,
									"How Many Moves? ("+dice1+" or "+(dice1+dice2)+")", "Move",
									JOptionPane.QUESTION_MESSAGE, null, moveOptions, moveOptions[0]);
							if (x == null) {
								System.exit(0);
							} else {
								step = Integer.parseInt(x);
							}
							
							
							board.move(horse,step);
							canvas.repaint();
						}	
					}
					turn--;
				}
				if(dice1!=dice2) {
					if(G.size()==0) {
						turn++;
						continue;
					}
					Horse[] horseOptions = new Horse[G.size()];
					int i=0;
					for(Horse h:G) {
						horseOptions[i]=h;
						i++;
					}
					Horse h = (Horse) JOptionPane.showInputDialog(null,
							"Which Horse?", "Horse",
							JOptionPane.QUESTION_MESSAGE, null, horseOptions, horseOptions[0]);
					if(h==null) {
						turn++;
						System.out.println(board);
						canvas.repaint();
						continue;
					} else {
						horse = h;
					}
						if(horse.getCol()>0&&h.getCol()<7&&h.getRow()==7) {
							board.moveInStack(horse, dice1, dice2);
						} else {
							board.move(horse,(dice1+dice2));
							canvas.repaint();
						}
				}
			}
			else if(getTurn()==Color.BLUE) {
				rollDice();
				if(dice1==dice2) {
					if(b.size()>0&&(board.getHorse(14, 8) instanceof Horse)){
						if(board.getHorse(14, 8).getColor()==Color.BLUE) {
							System.out.println("Can't spawn horse!");
						}
						if(board.getHorse(14, 8).getColor()==Color.GREEN) {
							G.remove(board.getHorse(14, 8));
							g.add(board.getHorse(14, 8));
							board.add(b.remove());
							B.add(board.getHorse(14, 8));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
						if(board.getHorse(14, 8).getColor()==Color.RED) {
							R.remove(board.getHorse(14, 8));
							r.add(board.getHorse(14, 8));
							board.add(b.remove());
							B.add(board.getHorse(14, 8));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
						if(board.getHorse(14, 8).getColor()==Color.YELLOW) {
							Y.remove(board.getHorse(14, 8));
							y.add(board.getHorse(14, 8));
							board.add(b.remove());
							B.add(board.getHorse(14, 8));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
					} else if(b.size()>0) {
						board.add(b.remove());
						B.add(board.getHorse(14, 8));
						System.out.println(board);
						canvas.repaint();
						continue;
					}
					if(b.size()==0||((board.getHorse(14, 8) instanceof Horse))&&board.getHorse(14, 8).getColor()==Color.BLUE) {
						
						Horse[] horseOptions = new Horse[B.size()];
						int i=0;
						for(Horse h:B) {
							horseOptions[i]=h;
							i++;
						}
						Horse h = (Horse) JOptionPane.showInputDialog(null,
								"Which Horse?", "Horse",
								JOptionPane.QUESTION_MESSAGE, null, horseOptions, horseOptions[0]);
						if(h==null) {
							System.exit(0);
						} else {
							horse = h;
						}
						
						if(horse.getRow()>7&&h.getRow()<14&&horse.getCol()==7) {
							board.moveInStack(horse, dice1, dice2);
							canvas.repaint();
						} else {
							String[] moveOptions = {""+dice1,""+(dice1+dice2)};
							String x = (String) JOptionPane.showInputDialog(null,
									"How Many Moves? ("+dice1+" or "+(dice1+dice2)+")", "Move",
									JOptionPane.QUESTION_MESSAGE, null, moveOptions, moveOptions[0]);
							if (x == null) {
								System.exit(0);
							} else {
								step = Integer.parseInt(x);
							}
							
							
							board.move(horse,step);
							canvas.repaint();
						}
					}
					turn--;
				}
				if(dice1!=dice2) {
					if(B.size()==0) {
						turn++;
						continue;
					}
					Horse[] horseOptions = new Horse[B.size()];
					int i=0;
					for(Horse h:B) {
						horseOptions[i]=h;
						i++;
					}
					Horse h = (Horse) JOptionPane.showInputDialog(null,
							"Which Horse?", "Horse",
							JOptionPane.QUESTION_MESSAGE, null, horseOptions, horseOptions[0]);
					if(h==null) {
						turn++;
						System.out.println(board);
						canvas.repaint();
						continue;
					} else {
						horse = h;
					}
						if(horse.getRow()>7&&h.getRow()<14&&h.getCol()==7) {
							board.moveInStack(horse, dice1, dice2);
						} else {
							board.move(horse,(dice1+dice2));
							canvas.repaint();
						}
				}
			}
			else if(getTurn()==Color.YELLOW) {
				rollDice();
				if(dice1==dice2) {
					if(y.size()>0&&(board.getHorse(6, 14) instanceof Horse)){
						if(board.getHorse(6, 14).getColor()==Color.YELLOW) {
							System.out.println("Can't spawn horse!");
						}
						if(board.getHorse(6, 14).getColor()==Color.RED) {
							R.remove(board.getHorse(6, 14));
							r.add(board.getHorse(6, 14));
							board.add(y.remove());
							Y.add(board.getHorse(6, 14));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
						if(board.getHorse(6, 14).getColor()==Color.BLUE) {
							B.remove(board.getHorse(6, 14));
							b.add(board.getHorse(6, 14));
							board.add(y.remove());
							Y.add(board.getHorse(6, 14));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
						if(board.getHorse(6, 14).getColor()==Color.GREEN) {
							G.remove(board.getHorse(6, 14));
							g.add(board.getHorse(6, 14));
							board.add(y.remove());
							Y.add(board.getHorse(6, 14));
							System.out.println(board);
							canvas.repaint();
							continue;
						}
					} else if(y.size()>0) {
						board.add(y.remove());
						Y.add(board.getHorse(6, 14));
						System.out.println(board);
						canvas.repaint();
						continue;
					}
					if(y.size()==0||((board.getHorse(6, 14) instanceof Horse))&&board.getHorse(6, 14).getColor()==Color.YELLOW) {
						
						Horse[] horseOptions = new Horse[Y.size()];
						int i=0;
						for(Horse h:Y) {
							horseOptions[i]=h;
							i++;
						}
						Horse h = (Horse) JOptionPane.showInputDialog(null,
								"Which Horse?", "Horse",
								JOptionPane.QUESTION_MESSAGE, null, horseOptions, horseOptions[0]);
						if(h==null) {
							System.exit(0);
						} else {
							horse = h;
						}
						
						if(horse.getCol()<14&&h.getCol()>7&&horse.getRow()==7) {
							board.moveInStack(horse, dice1, dice2);
							canvas.repaint();
						} else {
							String[] moveOptions = {""+dice1,""+(dice1+dice2)};
							String x = (String) JOptionPane.showInputDialog(null,
									"How Many Moves? ("+dice1+" or "+(dice1+dice2)+")", "Move",
									JOptionPane.QUESTION_MESSAGE, null, moveOptions, moveOptions[0]);
							if (x == null) {
								System.exit(0);
							} else {
								step = Integer.parseInt(x);
							}
							
							
							board.move(horse,step);
							canvas.repaint();
						}	
					}
					turn--;
				}
				if(dice1!=dice2) {
					if(Y.size()==0) {
						turn++;
						continue;
					}
					Horse[] horseOptions = new Horse[Y.size()];
					int i=0;
					for(Horse h:Y) {
						horseOptions[i]=h;
						i++;
					}
					Horse h = (Horse) JOptionPane.showInputDialog(null,
							"Which Horse?", "Horse",
							JOptionPane.QUESTION_MESSAGE, null, horseOptions, horseOptions[0]);
					if(h==null) {
						turn++;
						System.out.println(board);
						canvas.repaint();
						continue;
					} else {
						horse = h;
					}
						if(horse.getCol()>7&&h.getCol()<14&&h.getRow()==7) {
							board.moveInStack(horse, dice1, dice2);
						} else {
							board.move(horse,(dice1+dice2));
							canvas.repaint();
						}
				}
			}
			System.out.println(board);
			turn++;
			canvas.repaint();
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
		dice2 = roll.nextInt(6)+1;
		System.out.println("Rolled ("+dice1+" "+dice2+")");
		return dice1+dice2;
	}
	//TODO: add rolldice, and add/remove horse from the queue if horse is added or got kicked
}
