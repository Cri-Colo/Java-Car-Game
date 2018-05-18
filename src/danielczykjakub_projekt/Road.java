package danielczykjakub_projekt;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;


public class Road extends JComponent {
    
    private Timer treeTimer;
    private final ArrayList<RoadStripe> StripesList = new ArrayList<>();
    private final ArrayList<Tree> TreesList = new ArrayList<>();
    private Timer stripesTimer;
    private boolean gameStarted = false;
    
    public Road() {
        setSize(400, 500);
        stripesTimer = new Timer(500, (e) -> {
            addNewStripes(100);
            removeRedundantStripes();
            repaint();
        });
        treeTimer = new Timer(200, (e) -> {
            addNewTrees(100);
            removeRedundantTrees();
            repaint();
        });
    }
    
    public void startTimers() {
        gameStarted = true;
        treeTimer.start();
        stripesTimer.start();
        Tree tree1 = new Tree(10, -80, 100);
        add(tree1);
        TreesList.add(tree1);
        tree1.startTimer();
        Tree tree2 = new Tree(360, -80, 100);
        add(tree2);
        TreesList.add(tree2);
        tree2.startTimer();
        for (RoadStripe stripe : StripesList) {
            stripe.startTimer();
        }
        for (Tree tree : TreesList) {
            tree.startTimer();
        }
    }
    
    public void setTimersSpeed(int speed) {
        int spawnSpeed = prepareSpawnSpeed(speed);
        stripesTimer.stop();
        stripesTimer = new Timer(spawnSpeed, (e) -> {
            addNewStripes(speed);
            removeRedundantStripes();
            repaint();
        });
        stripesTimer.start();
        
        treeTimer.stop();
        treeTimer = new Timer(spawnSpeed / 2, (e) -> {
            addNewTrees(speed);
            removeRedundantTrees();
            repaint();
        });
        treeTimer.start();
    }
    
    private int prepareSpawnSpeed(int speed) {
        if (speed >= 70) {
            return 2000;
        } else if (speed >= 30) {
            return 1000;
        } else {
            return 500;
        }
    }
    
    public void prepareStripes() {
        RoadStripe stripe = new RoadStripe(147, 30, 100);
        StripesList.add(stripe);
        add(stripe);
        RoadStripe stripe2 = new RoadStripe(247, 30, 100);
        StripesList.add(stripe2);
        add(stripe2);
        RoadStripe stripe3 = new RoadStripe(147, 340, 100);
        StripesList.add(stripe3);
        add(stripe3);
        RoadStripe stripe4 = new RoadStripe(247, 340, 100);
        StripesList.add(stripe4);
        add(stripe4);
    }
    
    public void prepareTrees() {
        Tree tree = new Tree(10, 30, 100);
        TreesList.add(tree);
        add(tree);
        Tree tree1 = new Tree(360, 30, 100);
        TreesList.add(tree1);
        add(tree1);
        Tree tree2 = new Tree(10, 130, 100);
        TreesList.add(tree2);
        add(tree2);
        Tree tree3 = new Tree(360, 130, 100);
        TreesList.add(tree3);
        add(tree3);
        Tree tree4 = new Tree(10, 230, 100);
        TreesList.add(tree4);
        add(tree4);
        Tree tree5 = new Tree(360, 230, 100);
        TreesList.add(tree5);
        add(tree5);
        Tree tree6 = new Tree(10, 330, 100);
        TreesList.add(tree6);
        add(tree6);
        Tree tree7 = new Tree(360, 330, 100);
        TreesList.add(tree7);
        add(tree7);
        Tree tree8 = new Tree(10, 430, 100);
        TreesList.add(tree8);
        add(tree8);
        Tree tree9 = new Tree(360, 430, 100);
        TreesList.add(tree9);
        add(tree9);
    }
    
    private void addNewStripes(int speed) {
        RoadStripe stripe = new RoadStripe(147, -100, speed);
        add(stripe);
        StripesList.add(stripe);
        stripe.startTimer();
        RoadStripe stripe2 = new RoadStripe(247, -100, speed);
        add(stripe2);
        StripesList.add(stripe2);
        stripe2.startTimer();
    }
    
    private void addNewTrees(int speed) {
        Tree tree = new Tree(10, -130, speed);
        add(tree);
        TreesList.add(tree);
        tree.startTimer();
        Tree tree1 = new Tree(360, -130, speed);
        add(tree1);
        TreesList.add(tree1);
        tree1.startTimer();
    }
    
    private void removeRedundantStripes() {
        if(StripesList.get(0).getY() >= 500) {
            remove(StripesList.get(0));
            remove(StripesList.get(1));
            StripesList.remove(0);
            StripesList.remove(1);
        }
    }
    
    private void removeRedundantTrees() {
        if(TreesList.get(0).getY() >= 500) {
            remove(TreesList.get(0));
            remove(TreesList.get(1));
            TreesList.remove(0);
            TreesList.remove(1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(48, 45, 45));
        g.fillRect(0, 0, getSize().width, getSize().height);
        g.setColor(new Color(48, 218, 54));
        g.fillRect(0, 0, 50, getSize().height);
        g.fillRect(350, 0, 50, getSize().height);
        if (!gameStarted) {
            g.setColor(Color.white);
            g.setFont(new Font("Calibri", Font.BOLD, 23));
            g.drawString("PRESS SPACE TO START", 60, 200);
        }
    }
                
}
