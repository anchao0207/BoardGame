import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JFrame;

public class JeuDesPetitsChevaux extends JFrame{
	private Board board = new Board();
	Queue<Horse> r = new LinkedList<>();
	Queue<Horse> g = new LinkedList<>();
	Queue<Horse> b = new LinkedList<>();
	Queue<Horse> y = new LinkedList<>();
	
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
	}
	//TODO: add rolldice, and add/remove horse from the queue if horse is added or got kicked
}
