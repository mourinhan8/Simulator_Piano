package com.code;

import javax.swing.*;
import java.awt.*;

class WhiteKey extends JButton implements Key {

    private final int note;

    WhiteKey(int pos) {
        note = firstNote + 2 * pos - (pos + 4) / 7 - pos / 7;
        int WWD = (WD * 3) / 2;
        int left = 10 + WWD * pos;
        setBackground(Color.WHITE);
        int WHT = (HT * 3) / 2;
        setBounds(left, 10, WWD, WHT);
    }

    public int getNote() {
        return note;
    }
}
