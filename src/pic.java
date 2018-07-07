import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class pic extends JPanel{

    private BufferedImage image;
    private int l,c;
    public pic(String fname){

        
        try {
            image = ImageIO.read(new File(fname));
             l= image.getWidth();
             c= image.getHeight();

        } catch (IOException ioe) {
            System.out.println("Could not read in the pic");
          
        }

    }

  
	public Dimension getPreferredSize() {
        return new Dimension(l,c);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,this);
    }
}


