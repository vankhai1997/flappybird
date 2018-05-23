package gui;

import com.t3h.flappybird.Audio;
import com.t3h.flappybird.Constants;
import com.t3h.flappybird.ManagerGame;
import model.Bird;

import javax.swing.*;

public class GUI extends JFrame implements Constants {
    private Bird bird = new Bird();
    private ManagerGame managerGame;
    private PanelGame panelGame;
    private Audio menu;

    public GUI() {
        setTitle("Flappy Bird");
        setSize(W, H);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


//        menuMain = new menuMain();
//        menuMain.setStart(this);
//        add(menuMain);
        managerGame = new ManagerGame();
        panelGame = new PanelGame();
        add(managerGame);
        add(panelGame);
        menu = new Audio("/sound/playgame.mid");
        menu.play();
        menu.loop();

//
    }

//    @Override
//    public void addGame() {
//        remove(menuMain);
//        menuMain = null;
//
//        managerGame.setFocusable(true);
//        managerGame.requestFocus();
//    }
}
