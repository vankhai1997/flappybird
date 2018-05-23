package com.t3h.flappybird;

import model.Bird;
import model.Pipe;

public class CheckBirdDie implements Constants {
    private boolean check;
    private boolean checkF=true;
    Bird bird = new Bird();
    Pipe pipe = new Pipe();

    public boolean birdDie() {
        if (bird.getY() + SIZEB >= yLand||bird.getY()<=0) {
            check = true;
        }
        if ((bird.getY() <= pipe.getH1()) && (bird.getX() + SIZEB) >= pipe.getX1()
                && (bird.getX() <= (pipe.getX1() + WIDTHP))) {
            check = true;
        }
        if ((bird.getY() + SIZEB) >= (pipe.getH1() + 100) && ((bird.getX() + SIZEB) >= pipe.getX1()
                && bird.getX() <= (pipe.getX1() + WIDTHP))) {
            check = true;
        }

        if ((bird.getY() <= pipe.getH2()) && (bird.getX() + SIZEB) >= pipe.getX2()
                && (bird.getX() <= (pipe.getX2() + WIDTHP))) {
            check = true;
        }

        if ((bird.getY() + SIZEB) >= (pipe.getH2() + 100) && ((bird.getX() + SIZEB) >= pipe.getX2()
                && bird.getX() <= (pipe.getX2() + WIDTHP))) {
            check = true;
        }

        if ((bird.getY() <= pipe.getH3()) && (bird.getX() + SIZEB) >= pipe.getX3() && (bird.getX() <= (pipe.getX3() + WIDTHP))) {
            check = true;
        }

        if ((bird.getY() + SIZEB) >= (pipe.getH3() + 100) && ((bird.getX() + SIZEB) >= pipe.getX3() && bird.getX() <= (pipe.getX3() + WIDTHP))) {
            check = true;
        }

        if ((bird.getY() <= pipe.getH4()) && (bird.getX() + SIZEB) >= pipe.getX4() && (bird.getX() <= (pipe.getX4() + WIDTHP))) { check = true;

        }

        if ((bird.getY() + SIZEB) >= (pipe.getH4() + 100) && ((bird.getX() + SIZEB) >= pipe.getX4() && bird.getX() <= (pipe.getX4() + WIDTHP))) {
            check = true;
        }


        return check;
    }

    public boolean isCheckF() {
        return checkF;
    }

    public void setCheckF(boolean checkF) {
        this.checkF = checkF;
    }
}
