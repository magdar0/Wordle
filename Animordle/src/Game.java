import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.*;

public class Game extends JPanel implements Runnable, KeyListener {
	private BufferedImage back;

	private int key;

	private Alligators p;
	private boolean start;
	private double time;
	private double curtime;
	private Fish fish;

	public Game() {
		back = null;
		new Thread(this).start();
		this.addKeyListener(this);
		p = new Alligators(0, 0, 50, 200, Color.magenta);
		fish = new Fish(300, 0, 100, 100, 3, 1, Color.black);
		Sound p = new Sound();
		p.playmusic("dram.wav");

		time = System.currentTimeMillis();
		curtime = 0;
		start = false;
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		} catch (Exception e) {
		}
	}

	public void paint(Graphics g) {
		Graphics2D twoDgraph = (Graphics2D) g;
		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		if (back == null) {
			back = (BufferedImage) (createImage(getWidth(), getHeight()));
		}
		// create a graphics reference to the back ground image
		// we will draw all changes on tbhe background image
		Graphics g2d = back.createGraphics();
		// this clears the old image, like an EtchASketch. If you see the old

		g2d.clearRect(0, 0, getSize().width, getSize().height);

		// START CODING GRAPHICS HERE
		if (start == false) {
			g2d.setFont(new Font("Apotos Black", Font.BOLD, 28));
			g2d.setColor(Color.white);
			g2d.drawString("Press Space to Start", 300, 400);
		}

		g2d.setFont(new Font("chiller", Font.BOLD, 54));
		g2d.setColor(Color.white);
		g2d.setFont(new Font("Apotos Black", Font.BOLD, 28));
		g2d.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
		g2d.setColor(Color.black);
		g2d.fillOval(fish.getX(), fish.getY(), fish.getWidth(), fish.getHeight());
		g2d.drawString("score " + p.getScore(), 20, 20);

		if (fish.Collision(p)) {
			p.setScore(1);
			move();
//	ball.setX(p.getX()+p.getWidth()+3);
		} else if (fish.getX() < p.getX()) {
			g2d.drawString("Game Over", 400, 300);
			Sound p = new Sound();
			p.playmusic("booom.wav");

		} else if (p.getScore() >= 11)

			g2d.drawString("You win", 400, 300);

		else if (start)
			move();

		// This line tells the program to draw everything above. If you delete
		twoDgraph.drawImage(back, 0, 0, null);
	}

// key method 
	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		System.out.println(key);

		if (key == 38)
			p.setDy(-2);

		if (key == 40)
			p.setDy(2);

		if (key == 32)
			start = true;
	}

	public void keyReleased(KeyEvent e) {
		key = e.getKeyCode();
		System.out.println(key);

		if (key == 38)
			p.setDy(0);
		if (key == 40)
			p.setDy(0);
	}

	public void move() {
		fish.bounce();
		p.move();
	}

}
