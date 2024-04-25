import javax.swing.*;
import java.awt.*;

public class Paddle {
	private int x;
	private int y;
	private int width;
	private int height;
	private int dx;
	private int dy;
	private Color c;
	private int score;

public Paddle() {
	x=200;
	y=200;
	width=30;
	height=30;
	dy=0;
	c=Color.magenta;
	score=0;
}

public Paddle(int x1, int y1, int w, int h, Color c1) {
	x=x1;
	y=y1;
	score=0;
	dy=0;
	width=w;
	height=h;
	c=Color.magenta;
}

public int getX() {
	return x;
}

public int getY() {
	return y;
}

public int getW() {
	return width;
}

public int getH() {
	return height;
}

public void setH(int e) {
	height = e;
}

public void setdy(int e) {
	dy=e;
}

public Color getC() {
	return c;
}

public void setC(Color e) {
	c=e;
}

public int getScore() {
	return score;
}

public void setScore(int f) {
	score+=f;
}

public void move() {
	y+=dy;
	if(y+height>560)
		y=560-height;
	
	if(y<0)
		y=0;
}
}