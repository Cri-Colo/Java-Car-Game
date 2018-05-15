package danielczykjakub_projekt;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Car extends JComponent {

    private BufferedImage carImage;
    private int carXPosition = 175;
    
    public Car() {
        setSize(100, 100);
        setLocation(carXPosition, 360);
        try {
            carImage = ImageIO.read(getClass().getResource("/resources/car.png"));
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
    
    public void moveLeft() {
        if (carXPosition != 75) {
            carXPosition -= 100;
            setLocation(carXPosition, 360);
            repaint();
        }
    }
    
    public void moveRight() {
        if (carXPosition != 275) {
            carXPosition += 100;
            setLocation(carXPosition, 360);
            repaint();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(carImage, 0, 0, this);
    }
            
}
