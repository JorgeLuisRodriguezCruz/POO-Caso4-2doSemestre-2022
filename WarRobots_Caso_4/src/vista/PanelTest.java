package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelTest extends JPanel implements ActionListener, KeyListener{
	   final int PANEL_WIDTH = 600;
	   final int PANEL_HEIGHT = 400;
	   //java.awt
	   private Image robot;
	   private Image fireTrap;
	   private Timer timer;
	   private double xVelocity = 0;
	   private double yVelocity = 0;
	   private double xVelocityBall = 2;
	   private double yVelocityBall = 1;
	   private double xCoordBall = 500;
	   private double yCoordBall = 300;
	   private double x = 0;
	   private double y = 200;

	   public void moveX(int pX){
	       this.x += pX;
	   }

	   public void moveY(int pY){
	       this.y += pY;
	   }
	   public PanelTest(){
	       this.addKeyListener(this);
	       setFocusable(true);
	       setFocusTraversalKeysEnabled(false);

	       //Background of this panel
	       this.setBackground(Color.GREEN);
	       //To create an image->This makes an image out of the image icon
	       this.robot = new ImageIcon("src/main/java/images/robotRock.png").getImage();
	       Image modRobot = robot.getScaledInstance(90,90, Image.SCALE_SMOOTH);
	       this.robot = new ImageIcon(modRobot).getImage();

	       //this.setOpaque(true);
	   }

	   public void paint(Graphics g){
	       super.paintComponent(g);
	       Graphics2D g2D = (Graphics2D) g;//Conversion a graphics 2D
	
	       g2D.drawImage(robot, (int) x,(int) y,null);
	   }
/*
	    @Override
	    public void actionPerformed(ActionEvent e) {

	       x += xVelocity;
	       y += yVelocity;
	       repaint();
	   }*/

	    public void up(){
	       yVelocity = -1.5;
	       xVelocity = 0;
	    }

	    public void down(){
	        yVelocity = 1.5;
	        xVelocity = 0;
	    }

	    public void left(){
	        xVelocity = -2.5;
	        yVelocity = 0;
	    }

	    public void right(){
	        xVelocity = 2.5;
	        yVelocity = 0;
	    }
/*
	    @Override
	    public void keyTyped(KeyEvent e) {
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {

	       int code = e.getKeyCode();

	       if (code == KeyEvent.VK_UP)
	           up();
	       if (code == KeyEvent.VK_DOWN)
	           down();
	       if (code == KeyEvent.VK_LEFT)
	           left();
	       if (code == KeyEvent.VK_RIGHT)
	           right();
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
	       int code = e.getKeyCode();

	       if(code == KeyEvent.VK_UP)
	           yVelocity=0;
	       if(code == KeyEvent.VK_DOWN)
	           yVelocity=0;
	       if(code == KeyEvent.VK_LEFT)
	           xVelocity=0;
	       if(code == KeyEvent.VK_RIGHT)
	           xVelocity=0;
	    }*/

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			 int code = e.getKeyCode();

		       if(code == KeyEvent.VK_UP)
		           yVelocity=0;
		       if(code == KeyEvent.VK_DOWN)
		           yVelocity=0;
		       if(code == KeyEvent.VK_LEFT)
		           xVelocity=0;
		       if(code == KeyEvent.VK_RIGHT)
		           xVelocity=0;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {

		       x += xVelocity;
		       y += yVelocity;
		       repaint();
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();

		       if (code == KeyEvent.VK_UP)
		           up();
		       if (code == KeyEvent.VK_DOWN)
		           down();
		       if (code == KeyEvent.VK_LEFT)
		           left();
		       if (code == KeyEvent.VK_RIGHT)
		           right();
			
		}
}
