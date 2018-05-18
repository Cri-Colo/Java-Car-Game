package danielczykjakub_projekt;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;


public class PoliceCar extends JComponent {
    
    private BufferedImage policeCarImage;
    private int yPosition;
    private final Timer timer;
    
    public PoliceCar(int roadNumber, int velocityInMs) {
        setSize(100, 100);
        
        switch (roadNumber) {
            case 1:
                roadNumber = 75;
                break;
            case 2:
                roadNumber = 175;
                break;
            case 3:
                roadNumber = 275;
                break;
        }
        
        setLocation(roadNumber, -200);
        try {
            policeCarImage = ImageIO.read(getClass().getResource("/resources/policeCar.png"));
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        timer = new Timer(velocityInMs, (e) -> {
            yPosition += 10;
            setLocation(getLocation().x, yPosition);
            repaint();
        });
    }
    
    public void startTimer() {
        timer.start();
    }
    
    public void stop() {
        timer.stop();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(policeCarImage, 0, 0, this);
    }
    
}
