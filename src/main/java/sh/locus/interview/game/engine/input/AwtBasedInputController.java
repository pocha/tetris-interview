package sh.locus.interview.game.engine.input;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtBasedInputController implements InputController, KeyListener {

    private InputKey keyStroke;

    @Override
    public InputKey consumeKeyStroke() {
        InputKey key = keyStroke;
        keyStroke = null;
        return key;
    }

    @Override
    public void start() {

        Frame frame = new Frame("Gamepad");
        frame.setSize(400, 100);
        frame.setLayout(new CardLayout());
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        frame.addKeyListener(this);
        frame.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP:
                this.keyStroke = InputKey.UP_ARROW;
                break;
            case KeyEvent.VK_LEFT:
                this.keyStroke = InputKey.LEFT_ARROW;
                break;
            case KeyEvent.VK_RIGHT:
                this.keyStroke = InputKey.RIGHT_ARROW;
                break;
            case KeyEvent.VK_DOWN:
                this.keyStroke = InputKey.DOWN_ARROW;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
