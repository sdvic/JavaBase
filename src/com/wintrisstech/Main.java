package com.wintrisstech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class Main extends JComponent implements Runnable, ActionListener, KeyListener
{
    Timer paintTicker = new Timer(20, this);
    int paintTickerCounter;
    private Image[] thomasSpriteImageArray;
    private Image[] forwardThomasSpriteImageArray = new Image[8];
    private Image[] reverseThomasSpriteImageArray = new Image[8];
    private int thomasSpriteImageArrayIndex = 0;
    private int thomasSpeed = 5;

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Main());
    }

    @Override
    public void run()
    {
        JFrame gameWindow = new JFrame("Thomas the tank");
        thomasSpriteImageArray = reverseThomasSpriteImageArray;
        gameWindow.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        gameWindow.add(this);// Adds the paint method to the JFrame
        gameWindow.addKeyListener(this);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(new Color(200, 235, 255));
        gameWindow.setVisible(true);
        paintTicker.start();
        try
        {
            forwardThomasSpriteImageArray[0] = read(new File("src/Thomas1.png"));
            forwardThomasSpriteImageArray[1] = read(new File("src/Thomas2.png"));
            forwardThomasSpriteImageArray[2] = read(new File("src/Thomas3.png"));
            forwardThomasSpriteImageArray[3] = read(new File("src/Thomas4.png"));
            forwardThomasSpriteImageArray[4] = read(new File("src/Thomas5.png"));
            forwardThomasSpriteImageArray[5] = read(new File("src/Thomas6.png"));
            forwardThomasSpriteImageArray[6] = read(new File("src/Thomas7.png"));
            forwardThomasSpriteImageArray[7] = read(new File("src/Thomas8.png"));
            reverseThomasSpriteImageArray[0] = read(new File("src/ReversedThomas1.png"));
            reverseThomasSpriteImageArray[1] = read(new File("src/ReversedThomas2.png"));
            reverseThomasSpriteImageArray[2] = read(new File("src/ReversedThomas3.png"));
            reverseThomasSpriteImageArray[3] = read(new File("src/ReversedThomas4.png"));
            reverseThomasSpriteImageArray[4] = read(new File("src/ReversedThomas5.png"));
            reverseThomasSpriteImageArray[5] = read(new File("src/ReversedThomas6.png"));
            reverseThomasSpriteImageArray[6] = read(new File("src/ReversedThomas7.png"));
            reverseThomasSpriteImageArray[7] = read(new File("src/ReversedThomas8.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(thomasSpriteImageArray[thomasSpriteImageArrayIndex], 500, 500, this);
        g2.setFont(new Font("Bank Gothic", Font.BOLD, 16));
        g2.drawString("Thomas Speed " + thomasSpeed, 1000, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        paintTickerCounter++;
        repaint();
        if (paintTickerCounter % thomasSpeed == 0)
        {
            gameTicker();
        }
    }

    public void gameTicker()
    {
        thomasSpriteImageArrayIndex++;
        thomasSpriteImageArrayIndex %= 8;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_DOWN)//Decrease Thomas speed
        {
            thomasSpeed++;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)//Increase Thomas speed
        {
            if (thomasSpeed > 1)
            {
                thomasSpeed--;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            thomasSpeed++;
            thomasSpriteImageArray = forwardThomasSpriteImageArray;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            thomasSpeed++;
            thomasSpriteImageArray = reverseThomasSpriteImageArray;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
