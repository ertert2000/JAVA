package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TreeMap;

public class SnakeManager implements Runnable {
	private static SnakeManager manager;
	private static TreeMap<String, Integer> args; 
	private SnakeField field;
	private Snake snake;

	public static void main(String[] args) {
		SnakeManager.args = new TreeMap<>();
		for (int i = 0; i < args.length; i+=2) {
			SnakeManager.args.put(args[i], Integer.parseInt(args[i+1]));
		}
		manager = new SnakeManager();
	}
	/**
	 * -w <int> - width
	 * -h <int> - heigth
	 * -ps <int> - pixel size
	 * -tps <int> - first TPS
	 */

	public SnakeManager() {
		System.out.println("Creating manager");
		new Thread(this).start();
	}

	public static Snake getSnake() {
		return manager.snake;
	}

	@Override
	public void run() {	
		field = new SnakeField(
			args.getOrDefault("-w", 30), 
			args.getOrDefault("-h", 30), field == null ? null : field.getLocation(), 
			args.getOrDefault("-ps", 10), 
			args.getOrDefault("-tps", 5));
		snake = new Snake(field);
		while (snake.step()) {
			try {
				Thread.sleep(1000 / field.getTiks());
				while (field.getWindowStatus() == SnakeField.DEACTIVE) {
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		snake.fill(30, SnakeField.MOD_DRAW);	
		field.paintRetry();
		field.addKeyListener(new RetryKeyListener());
	}
	
	class RetryKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyPressed(KeyEvent e) {
			field.setVisible(false);
			new Thread(SnakeManager.this).start();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
}

