package com.code;

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Pianos {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                Pianos window = new Pianos();
                window.frame.setVisible(true);
            }
        });
    }


    private void button(JButton a) {
        String name = a.getText();
        StringBuilder s = new StringBuilder("Music_notes\\" + name + ".wav");
        if (name.contains("#") || name.contains("b")) {
            a.setForeground(Color.WHITE);
            a.setBackground(Color.BLACK);
        }
        else
            a.setBackground(Color.WHITE);
        a.setVerticalAlignment(SwingConstants.BOTTOM);
        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {

                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(s.toString()));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(frame, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        a.setFont(new Font("Tahoma", Font.BOLD, 22));
    }

    private Pianos() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Piano");
        frame.setBounds(200, 200, 824, 564);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("C");
        button(btnNewButton);
        btnNewButton.setBounds(10, 204, 70, 222);

        frame.getContentPane().add(btnNewButton);

        JButton btnD_2 = new JButton("D");
        button(btnD_2);
        btnD_2.setBounds(90, 204, 70, 222);
        frame.getContentPane().add(btnD_2);

        JButton btnE = new JButton("E");
        button(btnE);
        btnE.setBounds(170, 204, 70, 222);
        frame.getContentPane().add(btnE);

        JButton btnF_1 = new JButton("F");
        button(btnF_1);
        btnF_1.setBounds(250, 204, 70, 222);
        frame.getContentPane().add(btnF_1);

        JButton btnC = new JButton("G");
        button(btnC);
        btnC.setBounds(330, 204, 70, 222);
        frame.getContentPane().add(btnC);

        JButton btnA = new JButton("A");
        button(btnA);
        btnA.setBounds(410, 204, 70, 222);
        frame.getContentPane().add(btnA);

        JButton btnB = new JButton("B");
        button(btnB);
        btnB.setBounds(490, 204, 70, 222);
        frame.getContentPane().add(btnB);

        JButton btnC_3 = new JButton("C1");
        button(btnC_3);
        btnC_3.setBounds(570, 204, 70, 222);
        frame.getContentPane().add(btnC_3);

        JButton btnD_3 = new JButton("D1");
        button(btnD_3);
        btnD_3.setBounds(650, 204, 70, 222);
        frame.getContentPane().add(btnD_3);

        JButton btnF_2 = new JButton("F1");
        button(btnF_2);
        btnF_2.setBounds(730, 204, 70, 222);
        frame.getContentPane().add(btnF_2);

        JButton btnC_1 = new JButton("C#");
        button(btnC_1);
        btnC_1.setBounds(49, 11, 70, 175);
        frame.getContentPane().add(btnC_1);

        JButton btnD = new JButton("D#");
        button(btnD);
        btnD.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnD.setBounds(129, 11, 70, 175);
        frame.getContentPane().add(btnD);

        JButton btnF = new JButton("F#");
        button(btnF);
        btnF.setBounds(286, 11, 70, 175);
        frame.getContentPane().add(btnF);

        JButton btnG = new JButton("G#");
        button(btnG);
        btnG.setBounds(366, 11, 70, 175);
        frame.getContentPane().add(btnG);

        JButton btnBb = new JButton("Bb");
        button(btnBb);
        btnBb.setBounds(446, 11, 70, 175);
        frame.getContentPane().add(btnBb);

        JButton btnC_2 = new JButton("C#1");
        button(btnC_2);
        btnC_2.setBounds(591, 11, 86, 175);
        frame.getContentPane().add(btnC_2);

        JButton btnD_1 = new JButton("D#1");
        button(btnD_1);
        btnD_1.setBounds(687, 11, 86, 175);
        frame.getContentPane().add(btnD_1);

        JLabel lblNewLabel = new JLabel("Simulator Piano");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
        lblNewLabel.setBounds(244, 469, 316, 45);
        frame.getContentPane().add(lblNewLabel);
    }
}