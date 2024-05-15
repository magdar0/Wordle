
import javax.swing.*;

import java.awt.*;

public class Alligators {

	private int x;
	private int y;
	private int width;
	private int height;
	private int dy;
	private Color c;
	private int score;

	public Alligators() {
		score = 0;
		x = 300;
		y = 300;
		width = 30;
		height = 30;

		dy = 0;

		c = Color.cyan;

	}

	public Alligators(int x1, int y1, int w, int h, Color c1) {
		x = x1;
		y = y1;
		score = 0;
		dy = 0;
		width = w;
		height = h;

		c = Color.cyan;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score += s;
	}

	public void move() {

		y += dy;
		if (y + width > 600)
			y = 600 - width;
	}

	public static boolean Collision(Alligators p) {
		// TODO Auto-generated method stub
		return false;
	}
}