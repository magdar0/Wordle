import javax.swing.*;
import java.awt.*;

public class Ball {
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

public Ball() {
	x=300;
	y=300;
	width=30;
	height=30;
	dx=0;
	dy=0;
	movert=false;
	movedn=false;
	c=Color.cyan;
}

public Ball(int x1, int y1, int w, int h, int dx1, int dy1, Color c1) {
	x=x1;
	y=y1;
	dx=dx1;
	dy=dy1;
	width=w;
	height=h;
	movert=false;
	movedn=false;
	c=Color.cyan;
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

public void setdx(int e) {
	dx=e;
}

public void setdy(int e) {
	dy=e;
}

public Color getC() {
	return c;
}

public void setmovert() {
	movert=!(movert);
}
public void setX(int s) {
	x=s;
}

public int getScore() {
	return score;
}

public void setScore(int s) {
	score+=s;
}

public void bounce() {
	if(movert) {
		x+=dx;
	}
	else {
		x-=dx;
	}
	if (movedn){
		y+=dy;
	}
	else {
		y-=dy;
	}
	

	if(y<0) {
		movedn=true;
		
	}
	if(y+height>600)	{
		movedn=false;
	}
	
	}


public boolean Collision(Paddle b) {
	if ((getX()+getW()>=b.getX()&&getX()<=b.getX()+b.getW()&&getY()+getH()>=b.getY() &&getY()<=b.getY()+b.getH())){
		setmovert();
		return true;
	}
		return false;
		
	//return getX()+getW()>=b.getX()&&getX()<=b.getX()+b.getW()&&
		//	getY()+getH()>=b.getY()&&getY()<=b.getY()+b.getH();
}

}