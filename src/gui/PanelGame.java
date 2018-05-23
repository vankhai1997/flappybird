package gui;

import com.t3h.flappybird.CheckBirdDie;
import com.t3h.flappybird.Constants;
import com.t3h.flappybird.ManagerGame;
import com.t3h.flappybird.Scores;
import model.Bird;
import model.Pipe;

import javax.swing.*;
import java.awt.*;

public class PanelGame extends JPanel implements Constants {
    private Pipe pipe = new Pipe();
    private Bird bird = new Bird();
    private Scores score = new Scores();
    private CheckBirdDie check = new CheckBirdDie();
    ManagerGame managerGame = new ManagerGame();

    public PanelGame() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Image BG = new ImageIcon(ManagerGame.class.getResource("/imgs/background.png")).getImage();
        g2d.drawImage(BG, 0, 0, W, H, null);

        pipe = new Pipe();
        pipe.drawPipe(g2d); //dow pipe
        //nền đất
        Image land = new ImageIcon(ManagerGame.class.getResource("/imgs/Vien.png")).getImage();
        g2d.drawImage(land, 0, yLand, W, hLand, null);
        score = new Scores();
        bird.drawBird(g2d);
        managerGame.drawScores(g2d);
        repaint();
    }
}
