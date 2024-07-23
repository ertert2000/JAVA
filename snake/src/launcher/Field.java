package launcher;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Field extends Frame implements WindowListener, MouseListener, MouseMotionListener{
	public static final int ACTIVE = 1;
	public static final int DEACTIVE = 2;
	protected int windowStatus = 0;
	protected int height, width;	
	protected int pixelSize;
	protected int boundSize = 10;
	protected int titleBarSize = 40;
	protected int crossThickness = 1;

	public static void main(String[] args) {
		new Field(30, 30, null, 10);
	}
	
	public Field(int width, int height, Point p, int pixelSize) {
		this.width = width;
		this.height = height;
		this.pixelSize = pixelSize;
		setSize(width*pixelSize + boundSize*2, height*pixelSize + boundSize + titleBarSize);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		if (p == null) p = new Point((d.width - getWidth())/2, (d.height - getHeight())/2);
		setLocation(p);
		setUndecorated(true); 
		setFont(new Font(Font.MONOSPACED, Font.PLAIN, titleBarSize-boundSize));
		setVisible(true); 
		setLocation(p);
		setListeners();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		paintExit(Color.black);
	}
	
	protected void setListeners() {
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(this);
	}
	
	public Point getRandomPoint() {
		Point p = new Point();
		p.setLocation((int)(Math.random() * width), (int)(Math.random() * height));
		return p;
	}
	
	public void paintExit(Color c) {
		double alfa = (double) titleBarSize / (titleBarSize + boundSize);
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.setColor(c);
		g2.setStroke(new BasicStroke(crossThickness));
		int x = getWidth() - (int)((titleBarSize+boundSize)*alfa);
		int y = (int)((titleBarSize+boundSize)*(1-alfa));
		int size = (int)((titleBarSize+boundSize) * (alfa-(1-alfa)));
		paintCross(x, y, size, g2);
	}
	
	public void paintCross(int x, int y, int size, Graphics2D g) {
		g.drawLine(x, y, x + size, y + size);
		g.drawLine(x, y + size, x + size, y);
	}
	
	public int getPixelHeight() {
		return height;
	}

	public int getPixelWidth() {
		return width;
	}

	public int getWindowStatus() {
		return windowStatus;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); 
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		windowStatus = DEACTIVE;
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		windowStatus = ACTIVE;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getY() < titleBarSize) {
			if (e.getX() > getWidth() - titleBarSize) {
				try {
					paintExit(Color.red);
					System.out.println("Closing app");
					Thread.sleep(100);
					System.exit(0);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} 
		}
	}

	int mouseX = 0, mouseY = 0;
	boolean moved = false;
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getY() < titleBarSize) {
			mouseX = e.getX();
			mouseY = e.getY();
			moved = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (moved) moved = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (moved) {
			setLocation(e.getXOnScreen() - mouseX, e.getYOnScreen() - mouseY);
			setVisible(true);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
