import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.*;

public class Game extends JPanel implements Runnable,KeyListener{
	private BufferedImage back;
	private Background_Image bi;
	public int key;
	private Paddle p1;
	private Paddle p2;
	private Ball ball;  
	private double time;
	private double curtime;
	private Sound s;
	private boolean start;
	private boolean playSound;
	private boolean cheat;

	
	public Game() {
		back=null;
		new Thread(this).start();
		this.addKeyListener(this);
		bi=new Background_Image();
		p1=new Paddle (0,0,40,150, Color.green);
		p2=new Paddle (745,0,40,150, Color.blue);
		ball=new Ball(300,300,50,50,5,0,Color.WHITE);
		key=-1;
		s = new Sound();
		time=System.currentTimeMillis();
		curtime=0;
		start=true;
		playSound=true;
		cheat=false;
		resetGame();
	}
	//to do list: 2 player, collision, score, timer, cheat code, paddle off screen
	public void run() {
		try {
			while(true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		}
		catch(Exception e) {}
	}
	
	public void paint (Graphics g)
	{
		Graphics2D twoDgraph = (Graphics2D)g;
	//take a snap shop of the current screen and same it as an image
	//that is the exact same width and height as the current screen
		if (back==null) {
			back =(BufferedImage) (createImage(getWidth(), getHeight()));
				}

	//create a graphics reference to the back ground image
	//we will draw all changes on the background image
		Graphics g2d = back.createGraphics();
		
		//this clears the old image, like an EtchASketch. If you see the old image when we learn motion, you deleted this line.
		g2d.clearRect(0, 0, getSize().width, getSize().height); 
		
		g2d.drawImage(new ImageIcon(bi.getBackground()).getImage(),0,0, getWidth(),getHeight(),this);

		if(start==true) {
			g2d.setColor(Color.CYAN);
			g2d.setFont(new Font("Times New Roman", Font.PLAIN, 50));
			if(p1.getScore()<5 && p2.getScore()<5)
			g2d.drawString("Press Space to Start", 100, 200);
	
		}
		else {
			curtime=(System.currentTimeMillis()-time)/1000;	
		}
		
		
		g2d.setFont(new Font("chiller", Font.BOLD,54));
		g2d.setFont(new Font ("Apotos Black", Font.BOLD, 28));
		g2d.setColor(p1.getC());
		g2d.fillRect(p1.getX(), p1.getY(),p1.getW() , p1.getH());
		g2d.setColor(Color.WHITE);
		g2d.drawString("Score = "+p1.getScore(),20,60);
		g2d.setColor(p2.getC());
		g2d.fillRect(p2.getX(), p2.getY(),p2.getW() , p2.getH());
		g2d.setColor(Color.WHITE);
		g2d.drawString("Score = "+p2.getScore(),600,60);
		g2d.setColor(ball.getC());
		g2d.fillOval(ball.getX(), ball.getY(),ball.getW(),ball.getH());
		g2d.drawString(new DecimalFormat("#0.00").format(curtime),20,30);
		g2d.drawString("Player 1", 20, 550);
		g2d.drawString("Player 2", 600, 550);

		if (cheat==true) {
			g2d.setFont(new Font("chiller",Font.BOLD,34));
			g2d.drawString("WINNER is player that pressed backspace or 6 key!", 100, 300);
		}			
	
		if(ball.Collision(p1)) {
			
			s.playmusic("boopy.wav");
			
		}
		else  if (ball.getX()<p1.getX()+p1.getW()) {
			p2.setScore(1);
			resetBall();
			 if (playSound) {
				playSound=false;
				s.playmusic("lose.wav");
				}
		
		}
	
		
		if(ball.Collision(p2)) { 
			s.playmusic("boopy.wav");
			
		}
		
		else if (ball.getX()>p2.getX()) {
			p1.setScore(1);
			resetBall();
			if (playSound) {
				playSound=false;
				s.playmusic("lose.wav");
				}
		}

			
		
		

		if(p1.getScore()>=5) {
			g2d.setFont(new Font("chiller",Font.BOLD,54));
			g2d.drawString("PLAYER 1 WINS", 250, 300);
			ball.setdx(0);
			ball.setdy(0);
			start=true;
			}
		else	if(p2.getScore()>=5) {
			g2d.setFont(new Font("chiller",Font.BOLD,54));
			g2d.drawString("PLAYER 2 WINS", 250, 300);
			ball.setdx(0);
			ball.setdy(0);
			start=true;
		}
		else {

		move();
		}
		
		
		//This line tells the program to draw everything above. If you delete this, nothing will show up.
		twoDgraph.drawImage(back, 0, 0, null);
	}
	
	public void move() {
		
		p1.move();
		p2.move();
		ball.bounce();
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		key=e.getKeyCode();
		System.out.println(key);
		
		if(key==38)
			p2.setdy(-2);
		if(key==40)
			p2.setdy(2);
		if(key==87)
			p1.setdy(-2);
		if(key==83)
			p1.setdy(2);
		//Start Game = space key
		if(key==32) {
			ball.setdx(2);
			ball.setdy(2);
			start=false;
		}
		//resetGame = enter key
		if(key==10) {
			resetGame();
		}
	
		if(key==89) {
			ball.setdx(6);
			ball.setdy(6);
		}
	
		if(key==8 || key == 54) {
			
			cheat=true;
			ball.setdx(0);
			ball.setdy(0);
		}
	}
	
//create boolean to display, and add true to key press
	
	public void keyReleased(KeyEvent e) {
		
		key=e.getKeyCode();
		if (key==38||key==40)
			p2.setdy(0);
		if (key==87||key==83)
			p1.setdy(0);
			
	}
	
	public void resetGame() {
		p1.setScore(0-p1.getScore());
		p2.setScore(0-p2.getScore());
		ball.setX(300);
		ball.setdx(0);
		ball.setdy(0);
		
		key=-1;
		s = new Sound();
		
		curtime=0;
		start=true;
		playSound=true;
	}
	
	public void resetBall() {
		ball=new Ball(300,300,50,50,0,0,Color.WHITE);
	}
	
}
	
	
	
	



