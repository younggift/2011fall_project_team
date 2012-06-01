/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.nenu.pk.prototypes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.*;
import java.util.LinkedList;

/**
 *
 * @author Administrator
 */
public class MouseGet implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener
{

    public static void main(String[] args) {
        new MouseGet().run();
    }

    private static final int TRAIL_SIZE = 10;
    private static final Color[] COLORS = {
        Color.white, Color.black, Color.yellow, Color.magenta
    };

    private LinkedList trailList;
    private boolean trailMode;
    private int colorIndex;


    public void init() {
       
        trailList = new LinkedList();

       /* Window window = screen.getFullScreenWindow();
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
        window.addMouseWheelListener(this);
        window.addKeyListener(this);
        * 
        */
        
    }


    /*public synchronized void draw(Graphics2D g) {
        int count = trailList.size();

        if (count > 1 && !trailMode) {
            count = 1;
        }

        Window window = screen.getFullScreenWindow();

        // draw background
        g.setColor(window.getBackground());
        g.fillRect(0, 0, screen.getWidth(), screen.getHeight());

        // draw instructions
        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(window.getForeground());
        g.drawString("MouseTest. Press Escape to exit.", 5,
            FONT_SIZE);

        // draw mouse trail
        for (int i=0; i<count; i++) {
            Point p = (Point)trailList.get(i);
            g.drawString("Hello World!", p.x, p.y);
        }
    }
*/

    // from the MouseListener interface
    @Override
    public void mousePressed(MouseEvent e) {
        trailMode = !trailMode;
    }


    // from the MouseListener interface
    @Override
    public void mouseReleased(MouseEvent e) {
        // do nothing
    }


    // from the MouseListener interface
    @Override
    public void mouseClicked(MouseEvent e) {
        // called after mouse is released - ignore it
    }


    // from the MouseListener interface
    @Override
    public void mouseEntered(MouseEvent e) {
        mouseMoved(e);
    }


    // from the MouseListener interface
    @Override
    public void mouseExited(MouseEvent e) {
        mouseMoved(e);
    }


    // from the MouseMotionListener interface
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }


    // from the MouseMotionListener interface
    @Override
    public synchronized void mouseMoved(MouseEvent e) {
        Point p = new Point(e.getX(), e.getY());
        trailList.addFirst(p);
        while (trailList.size() > TRAIL_SIZE) {
            trailList.removeLast();
        }
    }


    // from the MouseWheelListener interface
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        colorIndex = (colorIndex + e.getWheelRotation()) %
            COLORS.length;

        if (colorIndex < 0) {
            colorIndex+=COLORS.length;
        }
       // Window window = screen.getFullScreenWindow();
        //window.setForeground(COLORS[colorIndex]);
    }


    // from the KeyListener interface
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            // exit the program
            stop();
        }
    }


    // from the KeyListener interface
    @Override
    public void keyReleased(KeyEvent e) {
        // do nothing
    }


    // from the KeyListener interface
    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }
    
    private void run() {
        System.out.println("Program is running!");
        //throw new UnsupportedOperationException("Not yet implemented");
    }
 
    private void stop() {
        System.out.println("Program exit!");
        System.exit(0);
        //throw new UnsupportedOperationException("Not yet implemented");
    }

   
}
