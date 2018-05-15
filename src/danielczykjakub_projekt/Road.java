package danielczykjakub_projekt;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;


public class Road extends JComponent {
    
    private int treeYPosition = 0;
    private Timer treeTimer;
    private ArrayList<RoadStripe> StripesList = new ArrayList<>();
    private ArrayList<Tree> TreesList = new ArrayList<>();
    private Timer stripesTimer;
    
    public Road() {
        setSize(400, 500);
        treeTimer = new Timer(50, (e) -> {
            treeYPosition++;
            repaint();
        });
        stripesTimer = new Timer(500, (e) -> {
            RoadStripe stripe = new RoadStripe(147, -100);
            add(stripe);
            stripe.startTimer();
            RoadStripe stripe2 = new RoadStripe(247, -100);
            add(stripe2);
            stripe2.startTimer();
            repaint();
        });
        treeTimer = new Timer(200, (e) -> {
            Tree tree = new Tree(10, -130);
            add(tree);
            tree.startTimer();
            Tree tree1 = new Tree(360, -130);
            add(tree1);
            tree1.startTimer();
            repaint();
        });
    }
    
    public void startTimers() {
        treeTimer.start();
        stripesTimer.start();
        Tree tree1 = new Tree(10, -80);
        add(tree1);
        tree1.startTimer();
        Tree tree2 = new Tree(360, -80);
        add(tree2);
        tree2.startTimer();
        for (RoadStripe stripe : StripesList) {
            stripe.startTimer();
        }
        for (Tree tree : TreesList) {
            tree.startTimer();
        }
    }
    
    public void prepareStripes() {
        RoadStripe stripe = new RoadStripe(147, 30);
        StripesList.add(stripe);
        add(stripe);
        RoadStripe stripe2 = new RoadStripe(247, 30);
        StripesList.add(stripe2);
        add(stripe2);
        RoadStripe stripe3 = new RoadStripe(147, 340);
        StripesList.add(stripe3);
        add(stripe3);
        RoadStripe stripe4 = new RoadStripe(247, 340);
        StripesList.add(stripe4);
        add(stripe4);
    }
    
    public void prepareTrees() {
        Tree tree = new Tree(10, 30);
        TreesList.add(tree);
        add(tree);
        Tree tree1 = new Tree(360, 30);
        TreesList.add(tree1);
        add(tree1);
        Tree tree2 = new Tree(10, 130);
        TreesList.add(tree2);
        add(tree2);
        Tree tree3 = new Tree(360, 130);
        TreesList.add(tree3);
        add(tree3);
        Tree tree4 = new Tree(10, 230);
        TreesList.add(tree4);
        add(tree4);
        Tree tree5 = new Tree(360, 230);
        TreesList.add(tree5);
        add(tree5);
        Tree tree6 = new Tree(10, 330);
        TreesList.add(tree6);
        add(tree6);
        Tree tree7 = new Tree(360, 330);
        TreesList.add(tree7);
        add(tree7);
        Tree tree8 = new Tree(10, 430);
        TreesList.add(tree8);
        add(tree8);
        Tree tree9 = new Tree(360, 430);
        TreesList.add(tree9);
        add(tree9);
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
                
}
