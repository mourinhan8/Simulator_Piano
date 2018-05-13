package com.code;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

class KeyBoard {
    public JFrame frame;

    String link(String s) {
        return "Music_notes\\" + s + ".wav";
    }

    private void button(JButton a) {
        String name = a.getText();
        if (name.contains("#") || name.contains("b")) {
            a.setForeground(Color.WHITE);
            a.setBackground(Color.BLACK);
        } else
            a.setBackground(Color.WHITE);
        a.setVerticalAlignment(SwingConstants.BOTTOM);
        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(link(name)));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "File not found.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        a.setFont(new Font("Tahoma", Font.BOLD, 16));
    }

    public KeyBoard() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setSize(824, 564);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(400, 100);
        frame.getContentPane().setLayout(null);
        int x1 = 10;
        String[] button2 = {"C", "D", "E", "F", "G", "A", "B", "C1", "D1", "E1"};
        for (String element: button2) {
            JButton newButton = new JButton(element);
            button(newButton);
            newButton.setBounds(x1, 204, 70, 222);
            frame.getContentPane().add(newButton);
            if (Objects.equals(element, "A")) {
                JButton button = new JButton("Bb");
                button(button);
                button.setBounds(x1 + 36, 11, 70, 175);
                frame.getContentPane().add(button);
            }
            if (!element.contains("E") && !element.contains("B")) {
                JButton button1 = new JButton(element + "#");
                button(button1);
                button1.setBounds(x1 + 36, 11, 70, 175);
                frame.getContentPane().add(button1);
            }
            x1 += 80;
        }
        JLabel lblNewLabel = new JLabel("Simulator Piano");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
        lblNewLabel.setBounds(244, 469, 316, 45);
        frame.getContentPane().add(lblNewLabel);
    }
}
