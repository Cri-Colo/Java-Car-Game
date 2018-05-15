package danielczykjakub_projekt;

import java.awt.Graphics;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;
import sun.font.TrueTypeFont;


public class Road extends JComponent implements PropertyChangeListener {
    
    private int treeYPosition = 0;
    private Timer treeTimer;
    private ArrayList<RoadStripe> StripesList = new ArrayList<>();
    private Timer stripesTimer;
    
    public Road() {
        setSize(400, 500);
        treeTimer = new Timer(50, (e) -> {
            treeYPosition++;
            repaint();
        });
        stripesTimer = new Timer(500, (e) -> {
            RoadStripe stripe = new RoadStripe(147, -100);
            StripesList.add(stripe);
            add(stripe);
            stripe.startTimer();
            RoadStripe stripe2 = new RoadStripe(247, -100);
            StripesList.add(stripe2);
            add(stripe2);
            stripe2.startTimer();
            repaint();
        });
    }
    
    public void startTimers() {
        for (RoadStripe stripe : StripesList) {
            stripe.startTimer();
        }
        treeTimer.start();
        stripesTimer.start();
    }
    
    public void prepareStripes() {
        RoadStripe stripe = new RoadStripe(147, 30);
        StripesList.add(stripe);
        add(stripe);
        RoadStripe stripe2 = new RoadStripe(247, 30);
        StripesList.add(stripe2);
        add(stripe2);
        RoadStripe stripe3 = new RoadStripe(147, 190);
        StripesList.add(stripe3);
        add(stripe3);
        RoadStripe stripe4 = new RoadStripe(247, 190);
        StripesList.add(stripe4);
        add(stripe4);
        RoadStripe stripe5 = new RoadStripe(147, 340);
        StripesList.add(stripe5);
        add(stripe5);
        RoadStripe stripe6 = new RoadStripe(247, 340);
        StripesList.add(stripe6);
        add(stripe6);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(48, 45, 45));
        g.fillRect(0, 0, getSize().width, getSize().height);
        g.setColor(new Color(48, 218, 54));
        g.fillRect(0, 0, 50, getSize().height);
        g.fillRect(350, 0, 50, getSize().height);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
    }
                
}
