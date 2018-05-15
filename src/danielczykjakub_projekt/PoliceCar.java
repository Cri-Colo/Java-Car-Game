package danielczykjakub_projekt;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class PoliceCar extends JComponent {
    
    BufferedImage policeCarImage;
    
    public PoliceCar() {
        setSize(100, 100);
        setLocation(200, 200);
        try {
            policeCarImage = ImageIO.read(getClass().getResource("/resources/policeCar.png"));
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(policeCarImage, 0, 0, this);
    }
    
}
