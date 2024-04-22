import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class Game extends JPanel implements Runnable, KeyListener{
	private BufferedImage back;
	private int key;
	private int lives;
	private boolean winner;
//	private boolean gameover;
	private Words w, answer, displayWord;
	private boolean start;
	public boolean cheat;
	
	public Game() {
		new Thread(this).start();
		this.addKeyListener(this);
		w = new Words();
		key = -1;
		lives = 6;
//		gameover = false;
		winner = true;
		start=true;
		cheat=false;
	}
		
	public void run() {  
		try {
			while(true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		}
		catch(Exception e) {}
	}
	
	public void drawLives (Graphics g2d) {
		switch (lives) {
		
		case 6:
			Color green = new Color(47, 252, 31);
			g2d.setColor(green);
			g2d.fillRect(600,  300,  80,  80);
		
		case 5:
			Color limegreen = new Color(91, 234, 111);
			g2d.setColor(limegreen);
		//	g2d.drawRect(500, 300, 75, 75);
			g2d.fillRect(500, 300, 80, 80);
		case 4:
			Color yellowgreen = new Color(191, 239, 81);
			g2d.setColor(yellowgreen);
		//	g2d.drawRect(400, 300, 75, 75);
			g2d.fillRect(400, 300, 80, 80);
			//break;
		case 3:
			Color yellow = new Color(246, 222, 50);
			g2d.setColor(yellow);
			g2d.fillRect(300, 300, 80, 80);
			//break;		
		case 2:
			Color orange = new Color(249, 158, 49);
			g2d.setColor(orange);
		//	g2d.drawRect(200, 300, 75, 75);
			g2d.fillRect(200, 300, 80, 80);
		//	g2d.fillRect(100, 300, 75, 75);

			//break;
		case 1:
			Color red = new Color(249, 58, 49);
			g2d.setColor(red);
			//g2d.drawRect(100, 300, 75, 75);
			g2d.fillRect(100, 300, 80, 80);
			break;
		case 0:
			g2d.clearRect(0, 0, getSize().width, getSize().height); 
			g2d.drawString("You Lose", 100, 100);
			g2d.drawString("Correct answer is: " + w.getAnswer(), 100, 200);
		
		}
	}
	
	
	public void paint (Graphics g)
	{
		Graphics2D twoDgraph = (Graphics2D)g;
		if (back==null) {
			back =(BufferedImage) (createImage(getWidth(), getHeight()));
				}

	//create a graphics reference to the back ground image
	//we will draw all changes on the background image
		Graphics g2d = back.createGraphics();
		
		//this clears the old image, like an EtchASketch. If you see the old image when we learn motion, you deleted this line.
		g2d.clearRect(0, 0, getSize().width, getSize().height); 
		
		//START CODING GRAPHICS HERE
		
		Color mynewcolor = new Color(139,53,153);
		
		g2d.setColor(mynewcolor);
		
		g2d.setFont(new Font ("Vladmir Script", Font.PLAIN, 36));
		g2d.drawString(w.disWord(), 50, 50);
		
		if(start) {
			g2d.clearRect(0, 0, getSize().width, getSize().height); 
			g2d.drawString("Press the SPACE key to start", 150, 300);
			
		}
		if(!winner) {
		drawLives(g2d);
		}
		g2d.setFont(new Font ("Corbel", Font.BOLD, 36));
		g2d.drawString("Lives Remaining:", 240, 250);
		g2d.setColor(Color.blue);
		g2d.setFont(new Font ("Corbel", Font.BOLD, 50));
		g2d.drawString("ANIMORDLE", 250, 100);
		
		
		if(!w.disWord().contains("-")) {
			g2d.clearRect(0,0,getSize().width, getSize().height);
			g2d.drawString("You Win!", 150, 350);
			g2d.drawString("Press the SPACE key to Restart", 150, 650);
		}
		
		if (cheat==true) {
			g2d.clearRect(0,0,getSize().width, getSize().height);
			g2d.setFont(new Font("chiller",Font.BOLD,54));
			g2d.drawString("Automatic Win! You found the cheat!", 100, 300);
		}
		
		//This line tells the program to draw everything above. If you delete this, nothing will show up.
		twoDgraph.drawImage(back, 0, 0, null);}
	
	
	public void resetGame() { 
//		gameover=false;
		lives=6;
		start=true;
	}		
		
    public void keyTyped(KeyEvent e) {
		
	}	
	
	
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		System.out.println(key);
//		if (key==32) {
//			lives--;
//		}
		char c = e.getKeyChar();
		if (key==32) {
			lives = 6;
//			gameover = false;
			winner = false;
			start=false;
//			resetGame();
			lives++;
			w.restart();
		}
		if(key==8) {
			cheat=true;
		}
		if(!w.checkGuess(c))	
			{
			lives--;
			if(lives == 0) {
//				winner = false;
	//			gameover = true;
//				w.showAnswer();
			}
			
			}
	}
	

	public void keyReleased(KeyEvent e) {
		key=e.getKeyCode();
	} 
	
	}



