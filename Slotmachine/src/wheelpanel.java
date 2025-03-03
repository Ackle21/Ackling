import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class wheelpanel extends JPanel implements Runnable {

	private BufferedImage diamond;
	private BufferedImage emerald;
	private BufferedImage ruby;
	private BufferedImage sapphire;
	private BufferedImage topaz;
	BufferedImage[] symbols;
	/**
	 * Create the panel.
	 */
	int y=0; // Wertebereich von 0 bis this.getwidth
	int state;
	Random r= new Random();
	public wheelpanel() {
		setBackground(Color.WHITE);
		try {
			diamond = ImageIO.read(new FileInputStream("res/Diamond.png"));
			emerald = ImageIO.read(new FileInputStream("res/Emerald.png"));
			ruby = ImageIO.read(new FileInputStream("res/Ruby.png"));
			sapphire = ImageIO.read(new FileInputStream("res/Sapphire.png"));
			topaz = ImageIO.read(new FileInputStream("res/Topaz.png"));
			symbols = new BufferedImage[]{diamond,emerald,ruby,sapphire,topaz};
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		
		
		
		for (int i = symbols.length-1; i > 0; i--) {
			
		g.drawImage(symbols[i],0, y-100*(4-i),getHeight(),getWidth(),this);
		}
		

	}

	@Override
	public void run() {
		state = r.nextInt(5);
		while (true) {
			
			
		}
		
	}
	public void rotate() {
		BufferedImage buffer= symbols[4];
		
		symbols[4]=symbols[3];
		symbols[3]=symbols[2];
		symbols[2]=symbols[1];
		symbols[1]=symbols[0];
		symbols[0]=buffer;
		
				
	}
	public void push() {
		if (y<100) {
			y+=10;
			this.paintImmediately(0,0,this.getWidth(),this.getHeight());
		}else {
			y=0;
			rotate();
			this.paintImmediately(0,0,this.getWidth(),this.getHeight());
		}
	}
}
