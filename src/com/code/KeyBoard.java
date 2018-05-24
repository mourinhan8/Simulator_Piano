package com.code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

class KeyBoard extends JFrame implements KeyListener {



    private Image backgroundImage;

    KeyBoard() {
        new JFrame("Piano Tiles");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(400, 100);
        try {
            backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("resources/KeyBoard.png"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_Q) {
            new SoundPlayer("/resources/C.wav");
        }
        if (keyCode == KeyEvent.VK_W) {
            new SoundPlayer("/resources/D.wav");
        }
        if (keyCode == KeyEvent.VK_E) {
            new SoundPlayer("/resources/E.wav");
        }
        if (keyCode == KeyEvent.VK_R) {
            new SoundPlayer("/resources/F.wav");
        }
        if (keyCode == KeyEvent.VK_T) {
            new SoundPlayer("/resources/G.wav");
        }
        if (keyCode == KeyEvent.VK_Y) {
            new SoundPlayer("/resources/A.wav");
        }
        if (keyCode == KeyEvent.VK_U) {
            new SoundPlayer("/resources/B.wav");
        }
        if (keyCode == KeyEvent.VK_I) {
            new SoundPlayer("/resources/C1.wav");
        }
        if (keyCode == KeyEvent.VK_O) {
            new SoundPlayer("/resources/D1.wav");
        }
        if (keyCode == KeyEvent.VK_P) {
            new SoundPlayer("/resources/E1.wav");
        }
        if (keyCode == KeyEvent.VK_2) {
            new SoundPlayer("/resources/C#.wav");
        }
        if (keyCode == KeyEvent.VK_3) {
            new SoundPlayer("/resources/D#.wav");
        }
        if (keyCode == KeyEvent.VK_4) {
            new SoundPlayer("/resources/F#.wav");
        }
        if (keyCode == KeyEvent.VK_5) {
            new SoundPlayer("/resources/G#.wav");
        }
        if (keyCode == KeyEvent.VK_6) {
            new SoundPlayer("/resources/Bb.wav");
        }
        if (keyCode == KeyEvent.VK_7) {
            new SoundPlayer("/resources/C1#.wav");
        }
        if (keyCode == KeyEvent.VK_8) {
            new SoundPlayer("/resources/D1#.wav");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
