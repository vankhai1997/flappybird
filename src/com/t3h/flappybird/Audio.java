package com.t3h.flappybird;

import javax.sound.sampled.*;
import java.io.IOException;

public class Audio {
    private Clip clip;
    private Audio audioScores;

    public Audio(String path) {
        try {
            AudioInputStream in = AudioSystem
                    .getAudioInputStream(
                            getClass().getResource(path)
                    );

            clip = AudioSystem.getClip();
            clip.open(in);
        } catch (UnsupportedAudioFileException | LineUnavailableException
                | IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    public void loop() {
        clip.loop(-1);
    }


}
