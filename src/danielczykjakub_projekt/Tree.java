package danielczykjakub_projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

public class Tree extends JComponent {
    
    private int yPosition;
    private Timer timer;
    private BufferedImage treeImage;
    
    public Tree(int x, int y, int speed) {
        setSize(26, 30);
        yPosition = y;
        setLocation(x, y);
        timer = new Timer(speed, (e) -> {
            yPosition += 10;
            setLocation(getLocation().x, yPosition);
            repaint();
        });
        try {
            treeImage = ImageIO.read(getClass().getResource("/resources/tree.png"));
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        
    }

    
    public void startTimer() {
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.drawImage(treeImage, 0, 0, this);
    }
    
}
