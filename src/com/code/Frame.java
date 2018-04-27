package com.code;

import javax.swing.*;

class Frame extends JFrame {

    Frame() {

        new JFrame("Piano");
        setSize(824, 564);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(400, 100);
        getContentPane().setLayout(null);
        KeyBoard kb = new KeyBoard();
        getContentPane().add(kb.btnNewButton);
        getContentPane().add(kb.btnD_2);
        getContentPane().add(kb.btnE);
        getContentPane().add(kb.btnF_1);
        getContentPane().add(kb.btnC);
        getContentPane().add(kb.btnA);
        getContentPane().add(kb.btnB);
        getContentPane().add(kb.btnC_3);
        getContentPane().add(kb.btnD_3);
        getContentPane().add(kb.btnF_2);
        getContentPane().add(kb.btnC_1);
        getContentPane().add(kb.btnD);
        getContentPane().add(kb.btnF);
        getContentPane().add(kb.btnG);
        getContentPane().add(kb.btnBb);
        getContentPane().add(kb.btnC_2);
        getContentPane().add(kb.btnD_1);
        getContentPane().add(kb.lblNewLabel);
    }
}
