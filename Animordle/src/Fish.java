
import javax.swing.*;

import java.awt.*;

public class Fish {
	private int x;
	private int y;
	private int width;
	private int height;
	private int dx;
	private int dy;
	private boolean movert;
	private boolean movedn;
	private Color c;
	private int score;

	public Fish() {
		x = 300;
		y = 300;
		width = 30;
		height = 30;
		dx = 0;
		dy = 0;
		movert = false;
		movedn = false;
		c = Color.cyan;

	}

	public Fish(int x1, int y1, int w, int h, int dx1, int dy1, Color c1) {
		x = x1;
		y = y1;
		dx = dx1;
		dy = dy1;
		width = w;
		height = h;
		movert = false;
		movedn = false;
		c = Color.cyan;

	}

	public int getScore() {
		return score;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Color getC() {
		return c;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public int getX() {
		return x;

	}

	public int getY() {
		return y;

	}

	public void bounce() {
		if (movert) {
			x += dx;
		} else {
			x -= dx;
		}
		if (movedn) {
			y += dy;
		} else {
			y -= dy;
		}

		if (x + width > 800) {
			movert = false;
		}

		if (y < 0) {
			movedn = true;

		}
		if (y + height > 600) {
			movedn = false;
		}

	}

	public void setmovert() {
		movert = !(movert);
	}

	public void setX(int s) {
		x = s;
	}

	public void setScore(int s) {
		score += s;
	}

	public boolean Collision(Alligators p) {
		if ((getX() + getWidth() >= p.getX() && getX() <= p.getX() + p.getWidth() && getY() + getHeight() >= p.getY()
				&& getY() <= p.getY() + p.getHeight())) {
			setmovert();
			return true;
		}
		return false;
	}

}
