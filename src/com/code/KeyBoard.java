package com.code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

class KeyBoard extends JFrame implements KeyListener {

    private SoundPlayer soundPlayer;


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
            soundPlayer = new SoundPlayer("/resources/C.wav");
        }
        if (keyCode == KeyEvent.VK_W) {
            soundPlayer = new SoundPlayer("/resources/D.wav");
        }
        if (keyCode == KeyEvent.VK_E) {
            soundPlayer = new SoundPlayer("/resources/E.wav");
        }
        if (keyCode == KeyEvent.VK_R) {
            soundPlayer = new SoundPlayer("/resources/F.wav");
        }
        if (keyCode == KeyEvent.VK_T) {
            soundPlayer = new SoundPlayer("/resources/G.wav");
        }
        if (keyCode == KeyEvent.VK_Y) {
            soundPlayer = new SoundPlayer("/resources/A.wav");
        }
        if (keyCode == KeyEvent.VK_U) {
            soundPlayer = new SoundPlayer("/resources/B.wav");
        }
        if (keyCode == KeyEvent.VK_I) {
            soundPlayer = new SoundPlayer("/resources/C1.wav");
        }
        if (keyCode == KeyEvent.VK_O) {
            soundPlayer = new SoundPlayer("/resources/D1.wav");
        }
        if (keyCode == KeyEvent.VK_P) {
            soundPlayer = new SoundPlayer("/resources/E1.wav");
        }
        if (keyCode == KeyEvent.VK_2) {
            soundPlayer = new SoundPlayer("/resources/C#.wav");
        }
        if (keyCode == KeyEvent.VK_3) {
            soundPlayer = new SoundPlayer("/resources/D#.wav");
        }
        if (keyCode == KeyEvent.VK_4) {
            soundPlayer = new SoundPlayer("/resources/F#.wav");
        }
        if (keyCode == KeyEvent.VK_5) {
            soundPlayer = new SoundPlayer("/resources/G#.wav");
        }
        if (keyCode == KeyEvent.VK_6) {
            soundPlayer = new SoundPlayer("/resources/Bb.wav");
        }
        if (keyCode == KeyEvent.VK_7) {
            soundPlayer = new SoundPlayer("/resources/C1#.wav");
        }
        if (keyCode == KeyEvent.VK_8) {
            soundPlayer = new SoundPlayer("/resources/D1#.wav");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
