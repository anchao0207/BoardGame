
public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		System.out.println(board);
		board.add(Horse.BLUE);
		board.add(Horse.GREEN);
		board.add(Horse.RED);
		board.add(Horse.YELLOW);
		board.move(Horse.RED,board.rollDice());
		board.move(Horse.RED,board.rollDice());
		board.move(Horse.GREEN,board.rollDice());
		board.move(Horse.RED,board.rollDice());
		board.move(Horse.BLUE,board.rollDice());
		board.move(Horse.YELLOW,board.rollDice());
		
		System.out.println(board);
	}

}
