package com.code;

import java.awt.*;

public class Pianos {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeyBoard().createAndShowPiano();
            }
        });
    }
}