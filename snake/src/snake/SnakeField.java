package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import launcher.Field;

public class SnakeField extends Field implements KeyListener {
	public static final int MOD_DRAW = 1;
	public static final int MOD_FILL = 2;
	public static final int MOD_CLEAR = 4;
	final static public int DIRECTION_LEFT = 0;
	final static public int DIRECTION_UP = 1;
	final static public int DIRECTION_RIGHT = 2;
	final static public int DIRECTION_DOWN = 3;
	private int direction = (int) Math.random() * 4;
	private int tiks = 5;
	private int initTiks = tiks;
	private Point apple;

	public SnakeField(int width, int height, Point p, int pointSize, int initTiks) {
		super(width, height, p, pointSize);
		System.out.println("Creating field");
		System.out.println(pointSize);
		this.initTiks = tiks = initTiks;
	}
	
	public static void main(String[] args) {
		new SnakeField(30, 30, null, 10, 5);
	}
	
	@Override
	protected void setListeners() {
		super.setListeners();
		addKeyListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawString("SCORE:", boundSize, titleBarSize-boundSize);
		g.drawRect(boundSize-1, titleBarSize - 1, getWidth() - boundSize*2 + 2, getHeight() - boundSize - titleBarSize + 2);
		paintScore();
		
		paintPixel(new Point(width - 1, height - 1), Color.black);
		paintPixel(new Point(width - 1, 0), Color.black);
		paintPixel(new Point(0, height - 1), Color.black);
		paintPixel(new Point(0, 0), Color.black);
	}

	public void paintPixel(Point p, Color c, int MOD) {
		Graphics g = getGraphics();
		if (c != null) g.setColor(c);
		int score = (tiks - initTiks) * 10;
		int x = (int)p.getX()*pixelSize + boundSize, y = (int)p.getY()*pixelSize + titleBarSize;
		if ((MOD & MOD_DRAW) == MOD_DRAW)
			g.drawRoundRect(x, y, pixelSize, pixelSize, pixelSize/(10 - score/500), pixelSize/(10 - score/500)); // max - 500
		if ((MOD & MOD_FILL) == MOD_FILL)
			g.fillRoundRect(x, y, pixelSize, pixelSize, pixelSize/(10 - score/500), pixelSize/(10 - score/500));
		if ((MOD & MOD_CLEAR) == MOD_CLEAR)
			g.clearRect(x, y, pixelSize, pixelSize);
	}

	public void paintPixel(Point p, Color c) {
		paintPixel(p, c, MOD_FILL);
	}

	public void clearPixel(Point p) {
		paintPixel(p, null, MOD_CLEAR);
	}

	public void paintScore() {
		Graphics g = getGraphics();
		int score = (tiks - initTiks) * 10;
		int size1 = g.getFontMetrics().stringWidth("SCORE:");
		int size2 = g.getFontMetrics().stringWidth("000");
		g.clearRect(boundSize + size1, 0, size2, titleBarSize-2);
		g.drawString(score + "", boundSize + size1, titleBarSize-boundSize);
	}
	
	public void paintRetry() {
		Graphics g = getGraphics();
		String[] text = new String[] {"press any key", "to retry"};
		for (int i = 0; i < text.length; i++) {
			int x = boundSize + (width * pixelSize - g.getFontMetrics().stringWidth(text[i])) / 2;
			int y = titleBarSize + boundSize + (height * pixelSize - titleBarSize * text.length) / 2 + titleBarSize * i;
			g.drawString(text[i], x, y);
		}
	}
	
	public void createApple() {
		do apple = getRandomPoint();
		while (SnakeManager.getSnake() != null && SnakeManager.getSnake().collision(apple));
		paintPixel(apple, Color.red);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 65: case 37: direction = DIRECTION_LEFT; break;
		case 87: case 38: direction = DIRECTION_UP; break;
		case 68: case 39: direction = DIRECTION_RIGHT; break;
		case 83: case 40: direction = DIRECTION_DOWN; break;
		case 61: setTiks(tiks + 1); break;
		case 45: setTiks(tiks - 1); break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public int getTiks() {
		return tiks;
	}

	public int getDirection() {
		return direction;
	}

	public void setTiks(int tiks) {
		this.tiks = tiks;
		paintScore();
	}
	
	public Point getApple() {
		return apple;
	}
}