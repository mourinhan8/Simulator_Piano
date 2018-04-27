package com.code;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class KeyBoard {
    JButton btnNewButton, btnD_2, btnE, btnF_1, btnC, btnA,
            btnB, btnC_3, btnD_3, btnF_2, btnC_1, btnD, btnF, btnG, btnBb, btnC_2, btnD_1;
    JLabel lblNewLabel;
    JFrame frame;

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
                    JOptionPane.showMessageDialog(frame, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        a.setFont(new Font("Tahoma", Font.BOLD, 22));
    }

    KeyBoard() {

        btnNewButton = new JButton("C");
        button(btnNewButton);
        btnNewButton.setBounds(10, 204, 70, 222);


        btnD_2 = new JButton("D");
        button(btnD_2);
        btnD_2.setBounds(90, 204, 70, 222);


        btnE = new JButton("E");
        button(btnE);
        btnE.setBounds(170, 204, 70, 222);


        btnF_1 = new JButton("F");
        button(btnF_1);
        btnF_1.setBounds(250, 204, 70, 222);


        btnC = new JButton("G");
        button(btnC);
        btnC.setBounds(330, 204, 70, 222);

        btnA = new JButton("A");
        button(btnA);
        btnA.setBounds(410, 204, 70, 222);

        btnB = new JButton("B");
        button(btnB);
        btnB.setBounds(490, 204, 70, 222);

        btnC_3 = new JButton("C1");
        button(btnC_3);
        btnC_3.setBounds(570, 204, 70, 222);

        btnD_3 = new JButton("D1");
        button(btnD_3);
        btnD_3.setBounds(650, 204, 70, 222);

        btnF_2 = new JButton("F1");
        button(btnF_2);
        btnF_2.setBounds(730, 204, 70, 222);

        btnC_1 = new JButton("C#");
        button(btnC_1);
        btnC_1.setBounds(49, 11, 70, 175);

        btnD = new JButton("D#");
        button(btnD);
        btnD.setBounds(129, 11, 70, 175);

        btnF = new JButton("F#");
        button(btnF);
        btnF.setBounds(286, 11, 70, 175);

        btnG = new JButton("G#");
        button(btnG);
        btnG.setBounds(366, 11, 70, 175);

        btnBb = new JButton("Bb");
        button(btnBb);
        btnBb.setBounds(446, 11, 70, 175);

        btnC_2 = new JButton("C#1");
        button(btnC_2);
        btnC_2.setBounds(591, 11, 86, 175);

        btnD_1 = new JButton("D#1");
        button(btnD_1);
        btnD_1.setBounds(687, 11, 86, 175);

        lblNewLabel = new JLabel("Simulator Piano");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
        lblNewLabel.setBounds(244, 469, 316, 45);
    }
}
