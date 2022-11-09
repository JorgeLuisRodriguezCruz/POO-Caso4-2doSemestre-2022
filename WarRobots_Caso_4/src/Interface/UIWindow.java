package Interface;

import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import common.IConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
ImagenRobot
ImagenTrampa1
ImagenTrampa2
  
*/

public class UIWindow  implements KeyListener, IConstants{
	
	
	public static String rutaImagenes = "C:\\Users\\Usuario\\Desktop\\Poo\\Caso #4\\POO-Caso4-2doSemestre-2022\\WarRobots_Caso_4\\src\\Imagenes\\";
	public int dir = 0;
	public boolean dirIzq = false;
	public boolean dirDer = false;
	public boolean dirArriba = false;
	public boolean dirAbajo = false;
	public boolean fire= false;
	private int angle;
	
	public void Simular() {
		JFrame frame = new JFrame("Guerra de Robots");  
	    JPanel panel1 = new JPanel();
	    panel1.setSize(ARENA_WIDTH, ARENA_HEIGTH);

	    frame.addKeyListener(this);
	    
	    
	    //Lectura de imagenes
	    BufferedImage myPicture = null;
	    BufferedImage myPicture2 = null;
	    BufferedImage myPicture3 = null;
		try {
			
			myPicture = ImageIO.read(new File(rutaImagenes + "Robot1.png"));
			myPicture=resize(myPicture,125,125);
			myPicture2 = ImageIO.read(new File(rutaImagenes + "Dano1.png"));
			myPicture2=resize(myPicture2,125,125);
			myPicture3 = ImageIO.read(new File(rutaImagenes + "LanzaLlamas.png"));
			myPicture3=resize(myPicture3,300,125);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
		JLabel picLabel3= new JLabel(new ImageIcon(myPicture3));
		//JLabel picLabel3 = new JLabel(new ImageIcon(myPicture3));
		
		Interfaz(frame, panel1);
		mostrarTrampas(panel1); 
		Background(panel1); //Se activa el background del panel

		boolean simulacion = true;
		int s = 0;
		int x = (int)(Math.random()*(ARENA_WIDTH-0+1)+0);
		int y = (int)(Math.random()*(ARENA_HEIGTH-0+1)+0);
		
		int x2=x;
		int y2=y;
					
		while(simulacion == true) {
			//panel1.removeAll();
			panel1.remove(picLabel);
			panel1.remove(picLabel2);
			panel1.remove(picLabel3);
			s++;
			
			if(dirIzq == true) {
				angle= 180;
				if(x<=-100) {
					x = x;
					y = y;
				}
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x -= 20;//25;//50;//75;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x -= 20;//25;//50;//75;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x -= 20;//25;//50;//75;
				}
				else {
					x -= 20;//25;//50;//75;
				}
			}
			else if(dirDer == true) {
				angle= 0;
				if(x>=ARENA_WIDTH) {
					x = x;
					y = y;
				}
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x += 20;//25;//50;//75;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x += 20;//25;//50;//75;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x += 20;//25;//50;//75;
				}
				else {
					x += 20;//25;//50;//75;
				}
			}
			else if(dirArriba == true) {
				angle= 270;
				if(y<=-200) {
					x = x;
					y = y;
				}
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y -= 20;//25;//50;//75;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y -= 20;//25;//50;//75;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y -= 20;//25;//50;//75;
				}
				else {
					y -= 20;//25;//50;//75;
				}
			}
			else if(dirAbajo == true) {
				angle= 90;
				if(y>=ARENA_HEIGTH-200) {
					x = x;
					y = y;
				}
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y += 20;//25;//50;//75;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y += 20;//25;//50;//75;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y += 20;//25;//50;//75;
				}
				else {
					y += 20;//25;//50;//75;
				}
			}
			if(fire) {
				picLabel3 = new JLabel(new ImageIcon(myPicture3)) {
					
					protected void paintComponent(Graphics grafico) {

			            Graphics2D graficoNuevo = (Graphics2D) grafico;
			
			            graficoNuevo.setRenderingHint(
			                    RenderingHints.KEY_ANTIALIASING,
			                    RenderingHints.VALUE_ANTIALIAS_ON
			            );
			
			            AffineTransform at = graficoNuevo.getTransform();
			            Shape figura = graficoNuevo.getClip();
			
			            double X = getWidth() / 2.0;
			            double Y = getHeight() / 2.0;
			
			            at.rotate(Math.toRadians(angle), X, Y);
			
			            graficoNuevo.setTransform(at);
			            graficoNuevo.setClip(figura);
			
			            super.paintComponent(grafico);
					}
				};
				if(dirIzq){
					x2=x-200;
					y2=y;
				}else if(dirDer) {
					x2=x;
					y2=y;
				}else if(dirArriba) {
					x2=x-80;
					y2=y-125;
				}else if(dirAbajo) {
					x2=x-80;
					y2=y+125;
				}
				fire(panel1,x2,y2, picLabel3);
			}
			
			
			
			System.out.println("--------------------------------");
			try {
				System.out.println(s);
				//System.out.println("izquierda: " + dirIzq);
				//System.out.println("derecha: " + dirDer);
				//System.out.println("arriba: " + dirArriba);
				//System.out.println("abajo: " + dirAbajo);
				mostrarImagen(panel1, x, y, picLabel);
				//Background(panel1);
				
				System.out.println("--------------------------------");
				Thread.sleep(50);
				//Thread.sleep(500);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
	        panel1.revalidate();
			panel1.repaint();
		}
	}
	


	public void Interfaz(JFrame frame, JPanel panel1) {
		  
	    			
		//JPanel mainPanel = new JPanel();
		//BorderLayout mainLayout = new BorderLayout();
		//mainPanel.setLayout(mainLayout);	
		
		panel1.setLayout(null);
		panel1.setBackground(Color.GRAY);
		frame.getContentPane();
		frame.add(panel1);
		
		
		//FlowLayout f1 = new FlowLayout();
	    //panel1.setLayout(f1);
        
				    		
	    frame.setSize(ARENA_WIDTH, ARENA_HEIGTH);  
	    frame.setLocationRelativeTo(null);  
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    frame.setVisible(true); 
	    
	}
	

	void Background(JPanel panel) {
			
		try {
			BufferedImage myPicture = null;
			myPicture = ImageIO.read(new File(rutaImagenes + "Piso1.jpg"));
			myPicture = resize(myPicture,ARENA_WIDTH,ARENA_HEIGTH);
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			//picLabel.setLocation(100, 500);
			panel.add(picLabel);
			Dimension size = picLabel.getPreferredSize();
	        picLabel.setBounds(-25, -50, size.width, size.height);
	        //panel.setComponentZOrder(picLabel, 3);
		} catch (IOException e) {
			System.out.println("Error cargando imagen ");
			e.printStackTrace();
		}
        
    }
	
	
	void mostrarTrampas(JPanel panel) {
		
		try { // muestra las trampas
			BufferedImage myPicture = null;
			myPicture = ImageIO.read(new File(rutaImagenes + "RuedaSierra.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			panel.add(picLabel);
			Dimension size = picLabel.getPreferredSize();
	        picLabel.setBounds(1000, 0, size.width, size.height);
	        
	        /*
	        BufferedImage myPicture2 = null;
			myPicture2 = ImageIO.read(new File(rutaImagenes + "Trampa2.png"));
			JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
			panel.add(picLabel2);
			Dimension size2 = picLabel2.getPreferredSize();
	        picLabel2.setBounds(350, 565, size2.width, size2.height);
	        
	       
	        BufferedImage myPicture3 = null;
			myPicture3 = ImageIO.read(new File(rutaImagenes + "Trampa3.png"));
			JLabel picLabel3 = new JLabel(new ImageIcon(myPicture3));
			panel.add(picLabel3, 2);
			Dimension size3 = picLabel3.getPreferredSize();
	        picLabel3.setBounds(-400, 115, size3.width, size3.height);
	        */
		} catch (IOException e) {
			System.out.println("Error cargando imagen ");
			e.printStackTrace();
		}
        
    }
	
	
	//void mostrarImagen(JPanel panel, int x, int y) {
	void mostrarImagen(JPanel panel, int x, int y, JLabel picLabel) {	
		/*try {
			BufferedImage myPicture = null;
			myPicture = ImageIO.read(new File(rutaImagenes + "Bicho2.gif"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			//picLabel.setLocation(100, 500);*/
			panel.add(picLabel, 0);
			//panel.add(picLabel);
			Dimension size = picLabel.getPreferredSize();
	        picLabel.setBounds(x, y, size.width, size.height);
		/*} catch (IOException e) {
			System.out.println("Error cargando imagen ");
			e.printStackTrace();
		}*/
        
    }
	
	
	void mostrarDano(JPanel panel, int x, int y, JLabel picLabel) {
		Dimension size = picLabel.getPreferredSize();
        picLabel.setBounds(x, y, size.width, size.height);
        panel.add(picLabel, 0);
    }
	
	void fire(JPanel panel, int x, int y, JLabel picLabel) {	
		Dimension size = picLabel.getPreferredSize();
        picLabel.setBounds(x, y, size.width, size.height);
        panel.add(picLabel, 0);
	}
	
	public BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
	
	public static BufferedImage rotate(BufferedImage bimg, double angle) {

	    int w = bimg.getWidth();    
	    int h = bimg.getHeight();

	    BufferedImage rotated = new BufferedImage(w, h, bimg.getType());  
	    Graphics2D graphic = rotated.createGraphics();
	    graphic.rotate(Math.toRadians(angle), w/2, h/2);
	    graphic.drawImage(bimg, null, 0, 0);
	    graphic.dispose();
	    return rotated;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}



	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	    if (key == KeyEvent.VK_LEFT) {
	        dirIzq = true;
	    }

	    else if (key == KeyEvent.VK_RIGHT) {
	        dirDer = true;
	    }

	    else if (key == KeyEvent.VK_UP) {
	        dirArriba = true;
	    }

	    else if (key == KeyEvent.VK_DOWN) {
	        dirAbajo = true;
	    }
	    
	    else if (key == KeyEvent.VK_SPACE) {
	    	fire=true;
	    }
	}


	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	    if (key == KeyEvent.VK_LEFT) {
	        dirIzq = false;
	    }

	    else if (key == KeyEvent.VK_RIGHT) {
	        dirDer = false;
	    }

	    else if (key == KeyEvent.VK_UP) {
	        dirArriba = false;
	    }

	    else if (key == KeyEvent.VK_DOWN) {
	        dirAbajo = false;
	    }
	    else if (key == KeyEvent.VK_SPACE) {
	    	fire=false;
	    }
	}
	
	
    
}

