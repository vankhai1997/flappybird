package com.t3h.flappybird;

import model.Bird;
import model.Pipe;

public class Scores implements Constants {
    CheckBirdDie check = new CheckBirdDie();
    private int scores = 0;
    Pipe pipe = new Pipe();
    Bird bird = new Bird();
    private Boolean b1 = false;
    private Boolean b2 = false;
    private Boolean b3 = false;
    private Boolean b4 = false;
    private Audio audioScores;

    public void setScores(int scores) {
        this.scores = scores;
    }

    public void sumScores() {
        if (bird.getX() + SIZEB > pipe.getX1() && bird.getX() < pipe.getX1() + WIDTHP) {
            b1 = true;
        }
        if (check.birdDie() != true && b1 == true && bird.getX() > pipe.getX1() + WIDTHP) {
            scores++;
            setScores(scores);
            audioScores = new Audio("/sound/point.wav");
            audioScores.play();
            b1 = false;
        }

        if (bird.getX() + SIZEB > pipe.getX2() && bird.getX() < pipe.getX2() + WIDTHP) {
            b2 = true;
        }
        if (check.birdDie() != true && b2 == true && bird.getX() > pipe.getX2() + WIDTHP) {
            scores++;
            setScores(scores);
            audioScores = new Audio("/sound/point.wav");
            audioScores.play();
            b2 = false;
        }

        if (bird.getX() + SIZEB > pipe.getX3() && bird.getX() < pipe.getX3() + WIDTHP) {
            b3 = true;
        }
        if (check.birdDie() != true && b3 == true && bird.getX() > pipe.getX3() + WIDTHP) {
            scores++;
            setScores(scores);
            audioScores = new Audio("/sound/point.wav");
            audioScores.play();
            b3 = false;
        }

        if (bird.getX() + SIZEB > pipe.getX4() && bird.getX() < pipe.getX4() + WIDTHP) {
            b4 = true;
        }
        if (check.birdDie() != true && b4 == true && bird.getX() > pipe.getX4() + WIDTHP) {
            scores++;
            setScores(scores);
            audioScores = new Audio("/sound/point.wav");
            audioScores.play();
            b4 = false;
        }

        if (scores < 3) {
       pipe.setSpeed(1);

        }else if (scores<10){
            pipe.setSpeed(2);
            System.out.println("dfdf");
        }else {
            pipe.setSpeed(3);
        }
    }


    public int getScores() {
        return scores;
    }
}
