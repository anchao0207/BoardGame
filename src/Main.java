
public class Main {

	public static void main(String[] args) {
//		Board board = new Board();
//		System.out.println(board);
//		Horse r1 = new Horse(Color.RED,1);
//		Horse g2 = new Horse(Color.GREEN,2);
//		board.add(r1);
//		board.add(g2);
//		board.move(r1,14);
//		board.move(r1,6);
//		board.add(r2);
//		board.move(r2,3);
//		board.move(y1,6);
//		board.move(y1,1);
//		board.move(h1, 6);
//		board.move(h1,6);
//		
//		System.out.println(board);
		JeuDesPetitsChevaux j =new JeuDesPetitsChevaux();
		j.setVisible(true);
		j.repaint();
		j.play();
	}

}
