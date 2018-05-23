package model;

import com.t3h.flappybird.Audio;
import com.t3h.flappybird.Constants;

import javax.swing.*;
import java.awt.*;

public class Bird extends JPanel implements Constants {
    private static int x = 50;
    private static int y = 160;
    private static int vt;

    public static final int SIZEB = 35;
    private Audio audioJump;
    private boolean birDown= false;
    private Audio audioBirdDown;
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void drawBird(Graphics2D g2d) {
        Image bird = new ImageIcon(Bird.class.getResource("/imgs/bird_blue.gif")).getImage();
        g2d.drawImage(bird, x, y, SIZEB, SIZEB, null);
    }

    public void birdDown() {
        vt+=g;
        y+=1;

    }

    public void birdFly() {
        vt=0;
        y -= 35;
        audioJump = new Audio("/sound/flap.wav ");
        audioJump.play();
    }


    public void dieBird() {
        if (birDown==false){
            audioBirdDown = new Audio("/sound/swosing.wav");
            audioBirdDown.play();
        }
        birDown=true;
        x++;
        y += 15;
    }



}
