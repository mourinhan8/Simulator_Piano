package com.code;

import javax.swing.*;
import java.awt.*;

class BlackKey extends JButton implements Key {

    private final int note;

    BlackKey(int pos) {
        note = firstNote + 1 + 2 * pos + (pos + 3) / 5 + pos / 5;
        int left = 10 + WD + ((WD * 3) / 2) * (pos + (pos / 5) + ((pos + 3) / 5));
        setBackground(Color.BLACK);
        setBounds(left, 10, WD, HT);
    }

    public int getNote() {
        return note;
    }
}