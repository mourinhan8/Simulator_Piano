package com.code;

import java.awt.*;

public class Pianos {
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                KeyBoard window = new KeyBoard();
                window.frame.setVisible(true);
            }
        });
    }

}