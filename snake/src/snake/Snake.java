package snake;

import java.awt.Color;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

public class Snake {
	private LinkedList<Point> body;
	private SnakeField field;

	public Snake(SnakeField field) {
		System.out.println("Creating snake");
		this.field = field;
		body = new LinkedList<>();
		body.add(field.getRandomPoint());
		field.createApple();
	}

	public boolean collision(Point p) {
		Iterator<Point> iter = body.iterator();
		while (iter.hasNext())
			if (p.equals(iter.next())) return true;
		return false;
	}

	public boolean step() {
		Point head = new Point(body.getFirst());
		switch (field.getDirection()) {
		case SnakeField.DIRECTION_UP: head.y--; break;
		case SnakeField.DIRECTION_LEFT: head.x--; break;
		case SnakeField.DIRECTION_RIGHT: head.x++; break;
		case SnakeField.DIRECTION_DOWN: head.y++; break;
		}
		head.x = (head.x + field.getPixelWidth()) % field.getPixelWidth();
		head.y = (head.y + field.getPixelHeight()) % field.getPixelHeight();
		
		field.paintPixel(head, Color.black);
		if (collision(head)) return false;
		
		if (field.getApple().equals(head)) {
			field.setTiks(field.getTiks() + 1);
			field.paintScore();
			field.createApple();
		} else if (!body.isEmpty()) field.clearPixel(body.pollLast());
		
		body.addFirst(head);
		
		return true;
	}

	public void fill(int delay, int MOD) {
		for (Point p : body) {
			field.clearPixel(p);
			field.paintPixel(p, Color.black, MOD);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
