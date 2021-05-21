
public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		System.out.println(board);
		board.add(Color.GREEN);
		board.add(Color.RED);
		board.add(Color.BLUE);
		board.add(Color.YELLOW);
		Horse h1 = new Horse(Color.RED);
		board.move(h1, 6);
		board.move(h1,6);
		board.add(Color.RED);
		Horse h2 = new Horse(Color.RED);
		board.move(h2,11);
//		board.move(h1);
//		board.move(Color.RED,board.getRow(Horse.RED),board.getCol(Horse.RED),12);
//		board.add(Color.RED);
//		System.out.println(board);
//		board.move(Color.RED,0,6,2);
//		board.move(Horse.RED,board.rollDice());
//		board.move(Horse.GREEN,board.rollDice());
//		board.move(Horse.RED,board.rollDice());
//		board.move(Horse.BLUE,board.rollDice());
//		board.move(Horse.YELLOW,board.rollDice());
		
		System.out.println(board);
	}

}
