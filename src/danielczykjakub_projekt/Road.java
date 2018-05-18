package danielczykjakub_projekt;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;


public class Road extends JComponent {
    
    private final Timer treeTimer;
    private final ArrayList<RoadStripe> StripesList = new ArrayList<>();
    private final ArrayList<Tree> TreesList = new ArrayList<>();
    private final Timer stripesTimer;
    private boolean gameStarted = false;
    
    public Road() {
        setSize(400, 500);
        stripesTimer = new Timer(500, (e) -> {
            addNewStripes();
            removeRedundantStripes();
            repaint();
        });
        treeTimer = new Timer(200, (e) -> {
            addNewTrees();
            removeRedundantTrees();
            repaint();
        });
    }
    
    public void startTimers() {
        gameStarted = true;
        treeTimer.start();
        stripesTimer.start();
        Tree tree1 = new Tree(10, -80);
        add(tree1);
        TreesList.add(tree1);
        tree1.startTimer();
        Tree tree2 = new Tree(360, -80);
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
    
    private void addNewStripes() {
        RoadStripe stripe = new RoadStripe(147, -100);
        add(stripe);
        StripesList.add(stripe);
        stripe.startTimer();
        RoadStripe stripe2 = new RoadStripe(247, -100);
        add(stripe2);
        StripesList.add(stripe2);
        stripe2.startTimer();
    }
    
    private void addNewTrees() {
        Tree tree = new Tree(10, -130);
        add(tree);
        TreesList.add(tree);
        tree.startTimer();
        Tree tree1 = new Tree(360, -130);
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
