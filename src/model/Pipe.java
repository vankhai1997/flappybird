package model;

import com.t3h.flappybird.Constants;
import com.t3h.flappybird.Scores;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Pipe extends JPanel implements Constants {
    private static int x1 = 300, x2 = x1 + 200, x3 = x2 + 200, x4 = x3 + 200;
    private static int h1, h2, h3, h4;
    private static boolean bl1 = false;
    private static boolean bl2 = false;
    private static boolean bl3 = false;
    private static boolean bl4 = false;
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getH1() {
        return h1;
    }

    public int getH2() {
        return h2;
    }

    public int getH3() {
        return h3;
    }

    public int getH4() {
        return h4;
    }


    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getX3() {
        return x3;
    }

    public int getX4() {
        return x4;
    }


    public void random() {
        Random rd = new Random();
//        h1 = rd.nextInt(200);
//        h2 = rd.nextInt(200);
//        h3 = rd.nextInt(200);
        if (bl1 == false) {
            h1 = rd.nextInt(200);
            bl1 = true;
        }
        if (bl2 == false) {
            h2 = rd.nextInt(200);
            bl2 = true;
        }
        if (bl3 == false) {
            h3 = rd.nextInt(200);
            bl3 = true;
        }

        if (bl4 == false) {
            h4 = rd.nextInt(200);
            bl4 = true;
        }

    }

    public void drawPipe(Graphics2D g2d) {

        random();
        Image pipe1 = new ImageIcon(Pipe.class.getResource("/imgs/OngTren1.png")).getImage();
        Image pipe2 = new ImageIcon(Pipe.class.getResource("/imgs/OngDuoi1.png")).getImage();
        g2d.drawImage(pipe1, x1, 0, WIDTHP, h1, null);
        g2d.drawImage(pipe2, x1, h1 + 100, WIDTHP, HEIGHTP, null);

        //ong nuoc thu 2
        g2d.drawImage(pipe1, x2, 0, WIDTHP, h2, null);
        g2d.drawImage(pipe2, x2, h2 + 100, WIDTHP, HEIGHTP, null);

        //ống nước thư 3
        g2d.drawImage(pipe1, x3, 0, WIDTHP, h3, null);
        g2d.drawImage(pipe2, x3, h3 + 100, WIDTHP, HEIGHTP, null);

        g2d.drawImage(pipe1, x4, 0, WIDTHP, h4, null);
        g2d.drawImage(pipe2, x4, h4 + 100, WIDTHP, HEIGHTP, null);
    }

    public void subXPipe() {
        if (this.getSpeed()==1) {
            x1--;
            x2--;
            x3--;
            x4--;
        }
         if (getSpeed()==2) {
            x1 -= 5;
            x2 -= 5;
            x3 -= 5;
            x4 -= 5;
            System.out.println("ssđsd");
        }

    }

    public void lap() {
        if (x1 == -WIDTHP) {
            x1 = 800;
            bl1 = false;
        }

        if (x2 == -WIDTHP) {
            x2 = 800;
            bl2 = false;
        }

        if (x3 == -WIDTHP) {
            x3 = 800;
            bl3 = false;
        }

        if (x4 == -WIDTHP) {
            x4 = 800;
            bl4 = false;
        }

    }

//

}
