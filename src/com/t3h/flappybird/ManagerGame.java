package com.t3h.flappybird;

import model.Bird;
import model.Pipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerGame extends JPanel implements Runnable, KeyListener, Constants {
    private Thread thread;
    private Bird bird = new Bird();
    private Pipe pipe = new Pipe();
    private CheckBirdDie check = new CheckBirdDie();
    private Scores score = new Scores();
    //    private Audio audioJump;
    private Audio audioHit;
    private boolean runStart;
    public ManagerGame() {
        addKeyListener(this);
        runStart = false;
        setFocusable(true);
        requestFocus();
        runThread();
    }
    public void runThread() {

        thread = new Thread(this);
        thread.start();
    }

    public void run() {

        while (true) {
            repaint();
            if (runStart == true) {
                pipe.subXPipe();
                bird.birdDown();
            }
            try {
                Thread.sleep(9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pipe.lap();

            if (check.birdDie() == true) {
                if (bird.getY() + SIZEB >= yLand) {
                    audioHit = new Audio("/sound/die.wav");
                    audioHit.play();
                    thread.stop();
                }
                bird.dieBird();
                repaint();
                if (check.isCheckF() == true) {
                    audioHit = new Audio("/sound/eat_explo.wav");
                    audioHit.play();
                    check.setCheckF(false);
                }
            }
            score.sumScores();
            repaint();
        }
    }

    public void drawScores(Graphics2D g2d){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Scores: " + score.getScores(), 20, 20);
        repaint();
        if (check.birdDie() == true) {
            Image GOver = new ImageIcon(ManagerGame.class.getResource("/imgs/GameOver.png")).getImage();
            g2d.drawImage(GOver, xGOver, yGOver, wGOver, hGOver, null);
            g2d.setColor(Color.blue);
            g2d.setFont(new Font("Arial", Font.BOLD, 30));
            g2d.drawString("Scores: " + score.getScores(), 300, 250);
            repaint();
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if (bird.getY() + SIZEB < yLand && check.birdDie() != true) {
                bird.birdFly();
                repaint();
                runStart = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            runStart = true;
        }
    }
}



